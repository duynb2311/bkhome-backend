package duy.nb.finalproject.demo.entities;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "stop")
public class Stop {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "bus_num")
    private String busNum;
    @Column(name = "train_id")
    private int trainId;
    @Column(name = "latitude")
    @NotNull
    private double latitude;
    @Column(name = "longitude")
    @NotNull
    private double longitude;
    @Column(name = "type")
    @NotNull
    private String type;

    public Stop() {
    }

    public Stop(String busNum, int trainId, double latitude, double longitude, String type) {
        this.busNum = busNum;
        this.trainId = trainId;
        this.latitude = latitude;
        this.longitude = longitude;
        this.type = type;
    }

    public Stop(int id, String busNum, int trainId, double latitude, double longitude, String type) {
        this.id = id;
        this.busNum = busNum;
        this.trainId = trainId;
        this.latitude = latitude;
        this.longitude = longitude;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBusNum() {
        return busNum;
    }

    public void setBusNum(String busNum) {
        this.busNum = busNum;
    }

    public int getTrainId() {
        return trainId;
    }

    public void setTrainId(int trainId) {
        this.trainId = trainId;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Stop{" +
                "id=" + id +
                ", busNum='" + busNum + '\'' +
                ", trainId=" + trainId +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", type='" + type + '\'' +
                '}';
    }
}
