package duy.nb.finalproject.demo.entities;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import springfox.documentation.spring.web.json.Json;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
@Table(name = "post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "user_id")
    @NotNull
    private int userId;
    @Column(name = "title")
    @NotNull
    private String title;
    @Column(name = "address")
    @NotNull
    private String address;
    @Column(name = "image_paths")
    @NotNull
    private String imagePaths;
    @Column(name = "type")
    @NotNull
    private String type;
    @Column(name = "latitude")
    @NotNull
    private double latitude;
    @Column(name = "longitude")
    @NotNull
    private double longitude;
    @Column(name = "video_path")
    private String videoPath;
    @Column(name = "area")
    @NotNull
    private int area;
    @Column(name = "rent_fee")
    @NotNull
    private BigDecimal rentFee;
    @Column(name = "rent_deposit")
    @NotNull
    private BigDecimal rentDeposit;
    @Column(name = "electric_cost")
    @NotNull
    private BigDecimal electricCost;
    @Column(name = "water_cost")
    @NotNull
    private BigDecimal waterCost;
    @Column(name = "service_fee")
    @NotNull
    private BigDecimal serviceFee;
    @Column(name = "structure")
    @NotNull
    private String structure;
    @Column(name = "furniture")
    @NotNull
    private String furniture;
    @Column(name = "other_feature")
    @NotNull
    private String otherFeature;
    @Column(name = "other_description")
    @NotNull
    private String otherDescription;
    @Column(name = "create_date")
    @NotNull
    private Date createDate;

    public Post() {
    }

    public Post(int userId, String title, String address, String imagePaths, String type, double latitude, double longitude, String videoPath, int area, BigDecimal rentFee, BigDecimal rentDeposit, BigDecimal electricCost, BigDecimal waterCost, BigDecimal serviceFee, String structure, String furniture, String otherFeature, String otherDescription, Date createDate) {
        this.userId = userId;
        this.title = title;
        this.address = address;
        this.imagePaths = imagePaths;
        this.type = type;
        this.latitude = latitude;
        this.longitude = longitude;
        this.videoPath = videoPath;
        this.area = area;
        this.rentFee = rentFee;
        this.rentDeposit = rentDeposit;
        this.electricCost = electricCost;
        this.waterCost = waterCost;
        this.serviceFee = serviceFee;
        this.structure = structure;
        this.furniture = furniture;
        this.otherFeature = otherFeature;
        this.otherDescription = otherDescription;
        this.createDate = createDate;
    }

    public Post(int id, int userId, String title, String address, String imagePaths, String type, double latitude, double longitude, String videoPath, int area, BigDecimal rentFee, BigDecimal rentDeposit, BigDecimal electricCost, BigDecimal waterCost, BigDecimal serviceFee, String structure, String furniture, String otherFeature, String otherDescription, Date createDate) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.address = address;
        this.imagePaths = imagePaths;
        this.type = type;
        this.latitude = latitude;
        this.longitude = longitude;
        this.videoPath = videoPath;
        this.area = area;
        this.rentFee = rentFee;
        this.rentDeposit = rentDeposit;
        this.electricCost = electricCost;
        this.waterCost = waterCost;
        this.serviceFee = serviceFee;
        this.structure = structure;
        this.furniture = furniture;
        this.otherFeature = otherFeature;
        this.otherDescription = otherDescription;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getImagePaths() {
        return imagePaths;
    }

    public void setImagePaths(String imagePaths) {
        this.imagePaths = imagePaths;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public String getVideoPath() {
        return videoPath;
    }

    public void setVideoPath(String videoPath) {
        this.videoPath = videoPath;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public BigDecimal getRentFee() {
        return rentFee;
    }

    public void setRentFee(BigDecimal rentFee) {
        this.rentFee = rentFee;
    }

    public BigDecimal getRentDeposit() {
        return rentDeposit;
    }

    public void setRentDeposit(BigDecimal rentDeposit) {
        this.rentDeposit = rentDeposit;
    }

    public BigDecimal getElectricCost() {
        return electricCost;
    }

    public void setElectricCost(BigDecimal electricCost) {
        this.electricCost = electricCost;
    }

    public BigDecimal getWaterCost() {
        return waterCost;
    }

    public void setWaterCost(BigDecimal waterCost) {
        this.waterCost = waterCost;
    }

    public BigDecimal getServiceFee() {
        return serviceFee;
    }

    public void setServiceFee(BigDecimal serviceFee) {
        this.serviceFee = serviceFee;
    }

    public String getStructure() {
        return structure;
    }

    public void setStructure(String structure) {
        this.structure = structure;
    }

    public String getFurniture() {
        return furniture;
    }

    public void setFurniture(String furniture) {
        this.furniture = furniture;
    }

    public String getOtherFeature() {
        return otherFeature;
    }

    public void setOtherFeature(String otherFeature) {
        this.otherFeature = otherFeature;
    }

    public String getOtherDescription() {
        return otherDescription;
    }

    public void setOtherDescription(String otherDescription) {
        this.otherDescription = otherDescription;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
