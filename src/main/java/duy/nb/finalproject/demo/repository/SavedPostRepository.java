package duy.nb.finalproject.demo.repository;

import duy.nb.finalproject.demo.entities.SavedPost;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SavedPostRepository extends JpaRepository<SavedPost, Integer> {
    List<SavedPost> findByUserId(int id);

    List<SavedPost> findByUserIdAndPostId(int userId, int postId );

    List<SavedPost> findByPostId(int postId);
}
