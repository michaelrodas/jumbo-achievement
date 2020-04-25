package com.jumbo.achievement.storelocator.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
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

    public Store(double latitude, double longitude, String uuid) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.uuid = uuid;
    }

}
