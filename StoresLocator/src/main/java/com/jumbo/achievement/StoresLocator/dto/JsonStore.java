package com.jumbo.achievement.StoresLocator.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

public class JsonStore {
    @JsonIgnore
    private Attributes attributes;
    private List<Store> stores;

    public JsonStore(Attributes attributes, List<Store> stores) {
        this.attributes = attributes;
        this.stores = stores;
    }

    public JsonStore() {
    }

    public Attributes getAttributes() {
        return attributes;
    }

    public void setAttributes(Attributes attributes) {
        this.attributes = attributes;
    }

    public List<Store> getStores() {
        return stores;
    }

    public void setStores(List<Store> stores) {
        this.stores = stores;
    }

    private static class Attributes {

        public Attributes() {
        }

        // Setters and Getters
    }
}
