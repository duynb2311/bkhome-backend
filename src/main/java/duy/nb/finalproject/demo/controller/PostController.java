package duy.nb.finalproject.demo.controller;

import duy.nb.finalproject.demo.dto.FilterDto;
import duy.nb.finalproject.demo.entities.Post;
import duy.nb.finalproject.demo.service.PostService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/v1/posts")
public class PostController {
    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping
    public Post createPost(@RequestBody Post post) throws ParseException {
        return postService.createPost(post);
    }

    @PutMapping("/{id}")
    public Post updatePost(@PathVariable int id, @RequestBody Post post){
        return postService.updatePost(id, post);
    }

    @GetMapping("/{id}")
    public Post findById(@PathVariable int id){
        return postService.findById(id);
    }

    @GetMapping("/user/{id}")
    public List<Post> findByUserId(@PathVariable int id){
        return postService.findByUserId(id);
    }

    @GetMapping
    public Page<Post> findWithFilter(
            @RequestParam(value = "address", defaultValue = ",") String address,
            @RequestParam(value = "minFee", defaultValue = "0") BigDecimal minFee,
            @RequestParam(value = "maxFee", defaultValue = "100000000") BigDecimal maxFee,
            @RequestParam(value = "minArea", defaultValue = "0") int minArea,
            @RequestParam(value = "maxArea", defaultValue = "1000") int maxArea,
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "10") int size
            ){
        return postService.findWithFilter(address,minFee,maxFee,minArea,maxArea, page, size);
    }

    @GetMapping("/nearstop")
    public Page<Post> findNearStop(
            @RequestParam(value = "address", defaultValue = ",") String address,
            @RequestParam(value = "busNum", defaultValue = "0") String busNum,
            @RequestParam(value = "maxDistance", defaultValue = "0") double maxDistance,
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "10") int size
            ){
        return postService.findNearStop(address,busNum,maxDistance, page, size);
    }

    @PostMapping("/search")
    public Page<Post> findWithDetailsFilter(@RequestBody FilterDto filterDto,
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "10") int size
            ){
        return postService.findWithDetailsFilter(filterDto,page,size);
    }

    @GetMapping("/searchbymap")
    public Page<Post> findByMap(
            @RequestParam(value = "latitude", defaultValue = "0") double latitude,
            @RequestParam(value = "longitude", defaultValue = "0") double longitude,
            @RequestParam(value = "distance", defaultValue = "0") double maxDistance,
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "10") int size
            ){
        return postService.findByMap(latitude,longitude,maxDistance, page, size) ;
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePost(@PathVariable int id){
        postService.deletePost(id);
        return ResponseEntity.ok("Delete success");
    }
}
