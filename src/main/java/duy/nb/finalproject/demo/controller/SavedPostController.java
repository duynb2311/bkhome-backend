package duy.nb.finalproject.demo.controller;

import duy.nb.finalproject.demo.entities.SavedPost;
import duy.nb.finalproject.demo.service.SavedPostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/savedpost")
public class SavedPostController {
    private SavedPostService savedPostService;

    public SavedPostController(SavedPostService savedPostService) {
        this.savedPostService = savedPostService;
    }

    @PostMapping
    public SavedPost createSavedPost(@RequestBody SavedPost savedPost) throws ParseException {
        return savedPostService.createSavedPost(savedPost);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSavedPost(@PathVariable int id){
        savedPostService.deleteSavedPost(id);
        return ResponseEntity.status(HttpStatus.OK).body("Delete success SavedPost with id "+id);
    }

    @GetMapping("/{userId}")
    public List<SavedPost> findByUserId(@PathVariable int userId){
        return savedPostService.findByUserId(userId);
    }

    @GetMapping("/check")
    public List<SavedPost> getByUserIdAndPostId(@RequestParam(name = "userId") int userId, @RequestParam(name = "postId") int postId){
        return savedPostService.getByUserIdAndPostId(userId, postId);
    }
}
