package duy.nb.finalproject.demo.entities;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "phone",nullable = false)
    private String username;
    @Column(name = "password",nullable = false)
    private String password;
    @Column(name = "full_name")
    @NotNull
    private String fullName;
    @Column
    private String image;
    @Column
    private double latitude;
    @Column
    private double longitude;

    public User() {
    }

    public User(String username, String passwords, String fullName, String image, double latitude, double longitude) {
        this.username = username;
        this.password = passwords;
        this.fullName = fullName;
        this.image = image;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public User(Integer id, String username, String password, String fullName, String image, double latitude, double longitude) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.image = image;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}

