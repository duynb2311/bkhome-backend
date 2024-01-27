package duy.nb.finalproject.demo.entities;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "saved_post")
public class SavedPost {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "user_id")
    @NotNull
    private int userId;
    @Column(name = "post_id")
    @NotNull
    private int postId;
    @Column(name = "create_date")
    @NotNull
    private Date createDate;

    public SavedPost() {
    }

    public SavedPost(int userId, int postId, Date createDate) {
        this.userId = userId;
        this.postId = postId;
        this.createDate = createDate;
    }

    public SavedPost(int id, int userId, int postId, Date createDate) {
        this.id = id;
        this.userId = userId;
        this.postId = postId;
        this.createDate = createDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
