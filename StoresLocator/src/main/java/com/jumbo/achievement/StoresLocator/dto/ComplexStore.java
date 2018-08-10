package com.jumbo.achievement.StoresLocator.dto;

/**
 * Created by MichaelR on 8/9/2018.
 */
public class ComplexStore {

    private double distanceToStore;
    private Store store;

    public ComplexStore(double distanceToStore, Store store) {
        this.distanceToStore = distanceToStore;
        this.store = store;
    }

    public double getDistanceToStore() {
        return distanceToStore;
    }

    public void setDistanceToStore(double distanceToStore) {
        this.distanceToStore = distanceToStore;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }
}
