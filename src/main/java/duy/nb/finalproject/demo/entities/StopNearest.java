package duy.nb.finalproject.demo.entities;

import jakarta.validation.constraints.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "stop_nearest")
public class StopNearest {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "stop_id")
    @NotNull
    private int stopId;
    @Column(name = "post_id")
    @NotNull
    private int postId;
    @Column(name = "distance")
    @NotNull
    private double distance;

    public StopNearest() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStopId() {
        return stopId;
    }

    public void setStopId(int stopId) {
        this.stopId = stopId;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public StopNearest(int stopId, int postId, double distance) {
        this.stopId = stopId;
        this.postId = postId;
        this.distance = distance;
    }

    public StopNearest(int id, int stopId, int postId, double distance) {
        this.id = id;
        this.stopId = stopId;
        this.postId = postId;
        this.distance = distance;
    }
}
