package duy.nb.finalproject.demo.service;

import duy.nb.finalproject.demo.dto.FilterDto;
import duy.nb.finalproject.demo.entities.Post;
import duy.nb.finalproject.demo.entities.SavedPost;
import duy.nb.finalproject.demo.entities.Stop;
import duy.nb.finalproject.demo.entities.StopNearest;
import duy.nb.finalproject.demo.exception.NotFoundException;
import duy.nb.finalproject.demo.repository.PostRepository;
import duy.nb.finalproject.demo.repository.SavedPostRepository;
import duy.nb.finalproject.demo.repository.StopNearestRepository;
import duy.nb.finalproject.demo.repository.StopRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Service
public class PostService {
    private PostRepository postRepository;
    private StopRepository stopRepository;
    private StopNearestRepository stopNearestRepository;
    private SavedPostRepository savedPostRepository;

    public PostService(PostRepository postRepository, StopRepository stopRepository, StopNearestRepository stopNearestRepository, SavedPostRepository savedPostRepository) {
        this.postRepository = postRepository;
        this.stopRepository = stopRepository;
        this.stopNearestRepository = stopNearestRepository;
        this.savedPostRepository = savedPostRepository;
    }

    private Pageable createPageRequestUsing(int page, int size) {
        return PageRequest.of(page, size);
    }

    public double calculateDistance(double lat1, double lon1, double lat2, double lon2){
        final int R = 6371;

        double lat1Rad = Math.toRadians(lat1);
        double lon1Rad = Math.toRadians(lon1);
        double lat2Rad = Math.toRadians(lat2);
        double lon2Rad = Math.toRadians(lon2);

        double dLat = lat2Rad - lat1Rad;
        double dLon = lon2Rad - lon1Rad;

        double a = Math.sin(dLat/2) * Math.sin(dLat/2) +
                Math.cos(lat1Rad) * Math.cos(lat2Rad) *
                        Math.sin(dLon/2) * Math.sin(dLon/2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
        double distance = R * c * 1000;
        return distance;
    }

    public static int binarySearch(List<StopNearest> list, double target) {
        int left = 0;
        int right = list.size() - 1;
        int closestIndex = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (list.get(mid).getDistance() == target) {
                return mid;
            } else if (list.get(mid).getDistance() < target) {
                closestIndex = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return closestIndex;
    }

    @Transactional
    public Post createPost(Post post) throws ParseException {
        DateTimeFormatter customFormater = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDate = customFormater.format(LocalDateTime.now());
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = dateFormat.parse(formattedDate);
        post.setCreateDate(date);
        Post createPost = postRepository.save(post);

        List<Stop> stops = stopRepository.findAll();
        for (Stop stop: stops){
            List<StopNearest> stopNearests = stopNearestRepository.findByStopIdOrderByDistanceDesc(stop.getId());
            double distance = calculateDistance(post.getLatitude(), post.getLongitude(), stop.getLatitude(), stop.getLongitude());
            if(distance < 1500){
                    StopNearest stopNearest = new StopNearest();
                    stopNearest.setPostId(createPost.getId());
                    stopNearest.setStopId(stop.getId());
                    stopNearest.setDistance(distance);
                    stopNearestRepository.save(stopNearest);
            }
        }

        return createPost;
    }

    public Post updatePost(int id, Post post){
        post.setId(id);
        return postRepository.save(post);
    }

    public Post findById(int id) throws NotFoundException{
        Post post = postRepository.findById(id).orElseThrow(() -> new NotFoundException("Post not found"));
        return post;
    }

    public List<Post> findByUserId(int id){
        return postRepository.findByUserIdOrderByCreateDateDesc(id);
    }

    public Page<Post> findWithFilter(String address, BigDecimal minFee, BigDecimal maxFee, int minArea, int maxArea, int page, int size){
        Pageable pageable = PageRequest.of(page, size);
        return postRepository.findWithFilterValue(address, minFee, maxFee, minArea, maxArea, pageable);
    }

    public Page<Post> findNearStop(String address, String busNum, double maxDistance, int page, int size){
        List<Post> allPost= postRepository.findByAddressContainingOrderByCreateDateDesc(address);
        List<Stop> stops = stopRepository.findByBusNum(busNum);
        List<Post> result = new ArrayList<>();
        int[] postIds = new int[100000000];
        for (Stop stop:stops){
            List<StopNearest> stopNearests = stopNearestRepository.findByStopIdOrderByDistanceAsc(stop.getId());
            int closestIndex = binarySearch(stopNearests, maxDistance);
            for (int i= 0; i<=closestIndex; i++){
                postIds[stopNearests.get(i).getPostId()] = 1;
            }
        }
        for (Post post:allPost){
            if (postIds[post.getId()]==1){
                result.add(post);
            }
        }

        Pageable pageable = createPageRequestUsing(page, size);

        int start = page*size;
        List<Post> list;
        if(result.size()< start){
            list = List.of();
        }else {
            int toIndex = Math.min(start+size, result.size());
            list = result.subList(start, toIndex);
        }

        return new PageImpl<>(list, pageable, result.size() );
    }
    public Page<Post> findWithDetailsFilter(FilterDto filterDto, int page, int size){
        if((!Objects.equals(filterDto.getBusNum(), "")||filterDto.getTrainId()!=0)&& filterDto.getDistance()!=0){
            List<Post> allPost= postRepository.findWithDetailsFilter(filterDto);
            List<Stop> stops = stopRepository.findByBusNum(filterDto.getBusNum());
            List<Post> result = new ArrayList<>();
            int[] postIds = new int[100000000];
            for (Stop stop:stops){
                List<StopNearest> stopNearests = stopNearestRepository.findByStopIdOrderByDistanceAsc(stop.getId());
                int closestIndex = binarySearch(stopNearests, filterDto.getDistance());
                for (int i= 0; i<=closestIndex; i++){
                    postIds[stopNearests.get(i).getPostId()] = 1;
                }
            }
            for (Post post:allPost){
                if (postIds[post.getId()]==1){
                    result.add(post);
                }
            }
            result.sort(Comparator.comparing(Post::getCreateDate).reversed());
            Pageable pageable = createPageRequestUsing(page, size);

            int start = page*size;
            List<Post> list;
            if(result.size()< start){
                list = List.of();
            }else {
                int toIndex = Math.min(start+size, result.size());
                list = result.subList(start, toIndex);
            }

            return new PageImpl<>(list, pageable, result.size() );
        }else {
            List<Post> result = postRepository.findWithDetailsFilter(filterDto);
            Pageable pageable = createPageRequestUsing(page, size);
            result.sort(Comparator.comparing(Post::getCreateDate).reversed());

            int start = page*size;
            List<Post> list;
            if(result.size()< start){
                list = List.of();
            }else {
                int toIndex = Math.min(start+size, result.size());
                list = result.subList(start, toIndex);
            }

            return new PageImpl<>(list, pageable, result.size() );
        }

    };

    public Page<Post> findByMap(double latitude, double longitude, double maxDistance, int page, int size) {
        List<Post> allPosts = postRepository.findByAddressContainingOrderByCreateDateDesc(" ");
        List<Post> result = new ArrayList<>();
        for (Post post: allPosts){
            double distance = calculateDistance(latitude, longitude, post.getLatitude(), post.getLongitude());
            if (distance <= maxDistance) result.add(post);
        }
        Pageable pageable = createPageRequestUsing(page, size);

        int start = page*size;
        List<Post> list;
        if(result.size()< start){
            list = List.of();
        }else {
            int toIndex = Math.min(start+size, result.size());
            list = result.subList(start, toIndex);
        }

        return new PageImpl<>(list, pageable, result.size() );
    }

    @Transactional
    public void deletePost(int id){
        List<StopNearest> stopNearests = stopNearestRepository.findByPostId(id);
        for (StopNearest stopNearest:stopNearests){
            stopNearestRepository.delete(stopNearest);
        }
        List<SavedPost> savedPosts = savedPostRepository.findByPostId(id);
        for (SavedPost savedPost: savedPosts) {
            savedPostRepository.delete(savedPost);
        }
        Post post = postRepository.findById(id).orElseThrow(() -> new NotFoundException("Post not found"));
        postRepository.delete(post);
    }
}
