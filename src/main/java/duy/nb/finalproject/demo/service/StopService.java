package duy.nb.finalproject.demo.service;

import duy.nb.finalproject.demo.entities.Post;
import duy.nb.finalproject.demo.entities.Stop;
import duy.nb.finalproject.demo.entities.StopNearest;
import duy.nb.finalproject.demo.exception.NotFoundException;
import duy.nb.finalproject.demo.repository.PostRepository;
import duy.nb.finalproject.demo.repository.StopNearestRepository;
import duy.nb.finalproject.demo.repository.StopRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StopService {
    private StopRepository stopRepository;
    private StopNearestRepository stopNearestRepository;

    private PostRepository postRepository;

    public StopService(StopRepository stopRepository, StopNearestRepository stopNearestRepository, PostRepository postRepository) {
        this.stopRepository = stopRepository;
        this.stopNearestRepository = stopNearestRepository;
        this.postRepository = postRepository;
    }

    public StopService(StopRepository stopRepository) {
        this.stopRepository = stopRepository;
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

    @Transactional
    public Stop createStop(Stop stop){
        List<Post> posts = postRepository.findByAddressContainingOrderByCreateDateDesc(",");
        Stop createStop = stopRepository.save(stop);
        for(Post post:posts){
            double distance = calculateDistance(post.getLatitude(), post.getLongitude(), stop.getLatitude(), stop.getLongitude());
            if(distance < 1500){
                StopNearest stopNearest = new StopNearest();
                stopNearest.setPostId(post.getId());
                stopNearest.setStopId(stop.getId());
                stopNearest.setDistance(distance);
                stopNearestRepository.save(stopNearest);
            }
        }
        return createStop;
    }

    public List<Stop> findByBusNum(String num){
        List<Stop> stops = stopRepository.findByBusNum(num);
        if(stops.isEmpty()){
            throw new NotFoundException("Can't find BusStop!");
        }else {
            return stops;
        }
    }

    public List<Object> findAllBusNum(){
        return stopRepository.findAllBusNum();
    }
}
