package com.jumbo.achievement.StoresLocator.dto;

import java.util.UUID;

/**
 * Created by MichaelR on 8/9/2018.
 */
public class Store {
    private double latitude;
    private double longitude;
    private UUID uuid;
    //TODO poner atributos como en JSON

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

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }
}
