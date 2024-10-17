package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;

/**
 * Device entity that maps to the devices table in the database.
 */
@Entity
public class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "battery_power")
    private Integer batteryPower;

    @Column(name = "blue")
    private Boolean hasBluetooth;

    @Column(name = "clock_speed")
    private Float clockSpeed;

    @Column(name = "dual_sim")
    private Boolean hasDualSim;

    @Column(name = "fc")
    private Integer frontCamera;

    @Column(name = "four_g")
    private Boolean hasFourG;

    @Column(name = "int_memory")
    private Integer internalMemory;

    @Column(name = "m_dep")
    private Float mobileDepth;

    @Column(name = "mobile_wt")
    private Integer mobileWeight;

    @Column(name = "n_cores")
    private Integer numCores;

    @Column(name = "pc")
    private Integer primaryCamera;

    @Column(name = "px_height")
    private Integer pixelHeight;

    @Column(name = "px_width")
    private Integer pixelWidth;

    @Column(name = "ram")
    private Integer ram;

    @Column(name = "sc_h")
    private Integer screenHeight;

    @Column(name = "sc_w")
    private Integer screenWidth;

    @Column(name = "talk_time")
    private Integer talkTime;

    @Column(name = "three_g")
    private Boolean hasThreeG;

    @Column(name = "touch_screen")
    private Boolean hasTouchScreen;

    @Column(name = "wifi")
    private Boolean hasWifi;

    // Field to store the predicted price range
    @Column(name = "price_range")
    private String priceRange;

    // Getters and setters for all fields

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getBatteryPower() {
        return batteryPower;
    }

    public void setBatteryPower(Integer batteryPower) {
        this.batteryPower = batteryPower;
    }

    public Boolean getHasBluetooth() {
        return hasBluetooth;
    }

    public void setHasBluetooth(Boolean hasBluetooth) {
        this.hasBluetooth = hasBluetooth;
    }

    public Float getClockSpeed() {
        return clockSpeed;
    }

    public void setClockSpeed(Float clockSpeed) {
        this.clockSpeed = clockSpeed;
    }

    public Boolean getHasDualSim() {
        return hasDualSim;
    }

    public void setHasDualSim(Boolean hasDualSim) {
        this.hasDualSim = hasDualSim;
    }

    public Integer getFrontCamera() {
        return frontCamera;
    }

    public void setFrontCamera(Integer frontCamera) {
        this.frontCamera = frontCamera;
    }

    public Boolean getHasFourG() {
        return hasFourG;
    }

    public void setHasFourG(Boolean hasFourG) {
        this.hasFourG = hasFourG;
    }

    public Integer getInternalMemory() {
        return internalMemory;
    }

    public void setInternalMemory(Integer internalMemory) {
        this.internalMemory = internalMemory;
    }

    public Float getMobileDepth() {
        return mobileDepth;
    }

    public void setMobileDepth(Float mobileDepth) {
        this.mobileDepth = mobileDepth;
    }

    public Integer getMobileWeight() {
        return mobileWeight;
    }

    public void setMobileWeight(Integer mobileWeight) {
        this.mobileWeight = mobileWeight;
    }

    public Integer getNumCores() {
        return numCores;
    }

    public void setNumCores(Integer numCores) {
        this.numCores = numCores;
    }

    public Integer getPrimaryCamera() {
        return primaryCamera;
    }

    public void setPrimaryCamera(Integer primaryCamera) {
        this.primaryCamera = primaryCamera;
    }

    public Integer getPixelHeight() {
        return pixelHeight;
    }

    public void setPixelHeight(Integer pixelHeight) {
        this.pixelHeight = pixelHeight;
    }

    public Integer getPixelWidth() {
        return pixelWidth;
    }

    public void setPixelWidth(Integer pixelWidth) {
        this.pixelWidth = pixelWidth;
    }

    public Integer getRam() {
        return ram;
    }

    public void setRam(Integer ram) {
        this.ram = ram;
    }

    public Integer getScreenHeight() {
        return screenHeight;
    }

    public void setScreenHeight(Integer screenHeight) {
        this.screenHeight = screenHeight;
    }

    public Integer getScreenWidth() {
        return screenWidth;
    }

    public void setScreenWidth(Integer screenWidth) {
        this.screenWidth = screenWidth;
    }

    public Integer getTalkTime() {
        return talkTime;
    }

    public void setTalkTime(Integer talkTime) {
        this.talkTime = talkTime;
    }

    public Boolean getHasThreeG() {
        return hasThreeG;
    }

    public void setHasThreeG(Boolean hasThreeG) {
        this.hasThreeG = hasThreeG;
    }

    public Boolean getHasTouchScreen() {
        return hasTouchScreen;
    }

    public void setHasTouchScreen(Boolean hasTouchScreen) {
        this.hasTouchScreen = hasTouchScreen;
    }

    public Boolean getHasWifi() {
        return hasWifi;
    }

    public void setHasWifi(Boolean hasWifi) {
        this.hasWifi = hasWifi;
    }

    public String getPriceRange() {
        return priceRange;
    }

    public void setPriceRange(String priceRange) {
        this.priceRange = priceRange;
    }
}
