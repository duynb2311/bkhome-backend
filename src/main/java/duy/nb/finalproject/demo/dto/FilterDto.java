package duy.nb.finalproject.demo.dto;

import java.math.BigDecimal;

public class FilterDto {
    private String address;
    private String type;
    private int minArea;
    private int maxArea;
    private BigDecimal minRentFee;
    private BigDecimal maxRentFee;
    private BigDecimal maxDeposit;
    private BigDecimal maxElectricCost;
    private BigDecimal maxWaterCost;
    private String bedroom;
    private String livingroom;
    private String kitchen;
    private String bathroom;
    private String furniture1;
    private String furniture2;
    private String nonglanh;
    private String furniture4;
    private String furniture5;
    private String furniture6;
    private String feature1;
    private String feature2;
    private String feature3;
    private String feature4;
    private String feature5;
    private String feature6;
    private String busNum;
    private int trainId;
    private double distance;


    public FilterDto() {
    }

    public FilterDto(String address, String type, int minArea, int maxArea, BigDecimal minRentFee, BigDecimal maxRentFee, BigDecimal maxDeposit, BigDecimal maxElectricCost, BigDecimal maxWaterCost, String bedroom, String livingroom, String kitchen, String bathroom, String furniture1, String furniture2, String nonglanh, String furniture4, String furniture5, String furniture6, String feature1, String feature2, String feature3, String feature4, String feature5, String feature6, String busNum, int trainId, double distance) {
        this.address = address;
        this.type = type;
        this.minArea = minArea;
        this.maxArea = maxArea;
        this.minRentFee = minRentFee;
        this.maxRentFee = maxRentFee;
        this.maxDeposit = maxDeposit;
        this.maxElectricCost = maxElectricCost;
        this.maxWaterCost = maxWaterCost;
        this.bedroom = bedroom;
        this.livingroom = livingroom;
        this.kitchen = kitchen;
        this.bathroom = bathroom;
        this.furniture1 = furniture1;
        this.furniture2 = furniture2;
        this.nonglanh = nonglanh;
        this.furniture4 = furniture4;
        this.furniture5 = furniture5;
        this.furniture6 = furniture6;
        this.feature1 = feature1;
        this.feature2 = feature2;
        this.feature3 = feature3;
        this.feature4 = feature4;
        this.feature5 = feature5;
        this.feature6 = feature6;
        this.busNum = busNum;
        this.trainId = trainId;
        this.distance = distance;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getMinArea() {
        return minArea;
    }

    public void setMinArea(int minArea) {
        this.minArea = minArea;
    }

    public int getMaxArea() {
        return maxArea;
    }

    public void setMaxArea(int maxArea) {
        this.maxArea = maxArea;
    }

    public BigDecimal getMinRentFee() {
        return minRentFee;
    }

    public void setMinRentFee(BigDecimal minRentFee) {
        this.minRentFee = minRentFee;
    }

    public BigDecimal getMaxRentFee() {
        return maxRentFee;
    }

    public void setMaxRentFee(BigDecimal maxRentFee) {
        this.maxRentFee = maxRentFee;
    }

    public BigDecimal getMaxDeposit() {
        return maxDeposit;
    }

    public void setMaxDeposit(BigDecimal maxDeposit) {
        this.maxDeposit = maxDeposit;
    }

    public BigDecimal getMaxElectricCost() {
        return maxElectricCost;
    }

    public void setMaxElectricCost(BigDecimal maxElectricCost) {
        this.maxElectricCost = maxElectricCost;
    }

    public BigDecimal getMaxWaterCost() {
        return maxWaterCost;
    }

    public void setMaxWaterCost(BigDecimal maxWaterCost) {
        this.maxWaterCost = maxWaterCost;
    }

    public String getBedroom() {
        return bedroom;
    }

    public void setBedroom(String bedroom) {
        this.bedroom = bedroom;
    }

    public String getLivingroom() {
        return livingroom;
    }

    public void setLivingroom(String livingroom) {
        this.livingroom = livingroom;
    }

    public String getKitchen() {
        return kitchen;
    }

    public void setKitchen(String kitchen) {
        this.kitchen = kitchen;
    }

    public String getBathroom() {
        return bathroom;
    }

    public void setBathroom(String bathroom) {
        this.bathroom = bathroom;
    }

    public String getFurniture1() {
        return furniture1;
    }

    public void setFurniture1(String furniture1) {
        this.furniture1 = furniture1;
    }

    public String getFurniture2() {
        return furniture2;
    }

    public void setFurniture2(String furniture2) {
        this.furniture2 = furniture2;
    }

    public String getNonglanh() {
        return nonglanh;
    }

    public void setNonglanh(String nonglanh) {
        this.nonglanh = nonglanh;
    }

    public String getFurniture4() {
        return furniture4;
    }

    public void setFurniture4(String furniture4) {
        this.furniture4 = furniture4;
    }

    public String getFurniture5() {
        return furniture5;
    }

    public void setFurniture5(String furniture5) {
        this.furniture5 = furniture5;
    }

    public String getFurniture6() {
        return furniture6;
    }

    public void setFurniture6(String furniture6) {
        this.furniture6 = furniture6;
    }

    public String getFeature1() {
        return feature1;
    }

    public void setFeature1(String feature1) {
        this.feature1 = feature1;
    }

    public String getFeature2() {
        return feature2;
    }

    public void setFeature2(String feature2) {
        this.feature2 = feature2;
    }

    public String getFeature3() {
        return feature3;
    }

    public void setFeature3(String feature3) {
        this.feature3 = feature3;
    }

    public String getFeature4() {
        return feature4;
    }

    public void setFeature4(String feature4) {
        this.feature4 = feature4;
    }

    public String getFeature5() {
        return feature5;
    }

    public void setFeature5(String feature5) {
        this.feature5 = feature5;
    }

    public String getFeature6() {
        return feature6;
    }

    public void setFeature6(String feature6) {
        this.feature6 = feature6;
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

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "FilterDto{" +
                "address='" + address + '\'' +
                ", type='" + type + '\'' +
                ", minArea=" + minArea +
                ", maxArea=" + maxArea +
                ", minRentFee=" + minRentFee +
                ", maxRentFee=" + maxRentFee +
                ", maxDeposit=" + maxDeposit +
                ", maxElectricCost=" + maxElectricCost +
                ", maxWaterCost=" + maxWaterCost +
                ", bedroom='" + bedroom + '\'' +
                ", livingroom='" + livingroom + '\'' +
                ", kitchen='" + kitchen + '\'' +
                ", bathroom='" + bathroom + '\'' +
                ", furniture1='" + furniture1 + '\'' +
                ", furniture2='" + furniture2 + '\'' +
                ", furniture3='" + nonglanh + '\'' +
                ", furniture4='" + furniture4 + '\'' +
                ", furniture5='" + furniture5 + '\'' +
                ", furniture6='" + furniture6 + '\'' +
                ", feature1='" + feature1 + '\'' +
                ", feature2='" + feature2 + '\'' +
                ", feature3='" + feature3 + '\'' +
                ", feature4='" + feature4 + '\'' +
                ", feature5='" + feature5 + '\'' +
                ", feature6='" + feature6 + '\'' +
                '}';
    }
}
