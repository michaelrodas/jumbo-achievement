package com.jumbo.achievement.storeslocator.dao;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jumbo.achievement.storeslocator.dto.JsonStore;
import com.jumbo.achievement.storeslocator.dto.Store;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static java.util.Collections.unmodifiableList;

@Slf4j
@Repository
class StoreProviderImpl implements StoreProvider {

    private final String storesFilePath;

    StoreProviderImpl(@Value("${stores.file.path}") String storesFilePath) {
        this.storesFilePath = storesFilePath;
    }

    @Override
    @Cacheable("stores")
    public Collection<Store> getAllStores() {
        List<Store> stores = new ArrayList<>();

        try {
            log.info("Loading stores from JSON file...");
            URL sourceFile = getClass().getClassLoader().getResource(storesFilePath);
            final JsonStore jsonStore = new ObjectMapper().readValue(sourceFile, JsonStore.class);
            stores = unmodifiableList(jsonStore.getStores());
        } catch (IOException | IllegalArgumentException e) {
            log.error("Unable to load JSON file {}: ", storesFilePath, e);
        }
        return stores;
    }
}
