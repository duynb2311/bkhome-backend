package duy.nb.finalproject.demo.service;

import duy.nb.finalproject.demo.entities.SavedPost;
import duy.nb.finalproject.demo.exception.NotFoundException;
import duy.nb.finalproject.demo.repository.SavedPostRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@Service
public class SavedPostService {
    private SavedPostRepository savedPostRepository;

    public SavedPostService(SavedPostRepository savedPostRepository) {
        this.savedPostRepository = savedPostRepository;
    }

    public SavedPost createSavedPost(SavedPost savedPost) throws ParseException {
        DateTimeFormatter customFormater = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDate = customFormater.format(LocalDateTime.now());
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = dateFormat.parse(formattedDate);
        savedPost.setCreateDate(date);
        return savedPostRepository.save(savedPost);
    }

    public void deleteSavedPost(int id) throws NotFoundException {
        SavedPost savedPost = savedPostRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("SavedPost not found"));
        savedPostRepository.delete(savedPost);
    }

    public List<SavedPost> findByUserId(int id){
        return savedPostRepository.findByUserId(id);
    }

    public List<SavedPost> getByUserIdAndPostId(int userId, int postId){
        return savedPostRepository.findByUserIdAndPostId(userId,postId);
    }
}
