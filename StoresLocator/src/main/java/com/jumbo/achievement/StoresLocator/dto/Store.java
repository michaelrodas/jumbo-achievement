package com.jumbo.achievement.StoresLocator.dto;

/**
 * Created by MichaelR on 8/9/2018.
 */
public class Store {
    private double latitude;
    private double longitude;
    private String uuid;
    private String city;
    private String postalCode;
    private String street;
    private String street2;
    private String street3;
    private String addressName;
    private int complexNumber;
    private boolean showWarningMessage;
    private String todayOpen;
    private String locationType;
    private boolean collectionPoint;
    private int sapStoreID;
    private String todayClose;

    public Store() {
    }

    public Store(double latitude, double longitude, String uuid) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.uuid = uuid;
    }

    public Store(double latitude, double longitude, String uuid, String city, String postalCode, String street,
                 String street2, String street3, String addressName, int complexNumber, boolean showWarningMessage,
                 String todayOpen, String locationType, boolean collectionPoint, int sapStoreID, String todayClose) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.uuid = uuid;
        this.city = city;
        this.postalCode = postalCode;
        this.street = street;
        this.street2 = street2;
        this.street3 = street3;
        this.addressName = addressName;
        this.complexNumber = complexNumber;
        this.showWarningMessage = showWarningMessage;
        this.todayOpen = todayOpen;
        this.locationType = locationType;
        this.collectionPoint = collectionPoint;
        this.sapStoreID = sapStoreID;
        this.todayClose = todayClose;
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

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getStreet2() {
        return street2;
    }

    public void setStreet2(String street2) {
        this.street2 = street2;
    }

    public String getStreet3() {
        return street3;
    }

    public void setStreet3(String street3) {
        this.street3 = street3;
    }

    public String getAddressName() {
        return addressName;
    }

    public void setAddressName(String addressName) {
        this.addressName = addressName;
    }

    public int getComplexNumber() {
        return complexNumber;
    }

    public void setComplexNumber(int complexNumber) {
        this.complexNumber = complexNumber;
    }

    public boolean isShowWarningMessage() {
        return showWarningMessage;
    }

    public void setShowWarningMessage(boolean showWarningMessage) {
        this.showWarningMessage = showWarningMessage;
    }

    public String getTodayOpen() {
        return todayOpen;
    }

    public void setTodayOpen(String todayOpen) {
        this.todayOpen = todayOpen;
    }

    public String getLocationType() {
        return locationType;
    }

    public void setLocationType(String locationType) {
        this.locationType = locationType;
    }

    public boolean isCollectionPoint() {
        return collectionPoint;
    }

    public void setCollectionPoint(boolean collectionPoint) {
        this.collectionPoint = collectionPoint;
    }

    public int getSapStoreID() {
        return sapStoreID;
    }

    public void setSapStoreID(int sapStoreID) {
        this.sapStoreID = sapStoreID;
    }

    public String getTodayClose() {
        return todayClose;
    }

    public void setTodayClose(String todayClose) {
        this.todayClose = todayClose;
    }
}
