package com.jumbo.achievement.StoresLocator.dao;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jumbo.achievement.StoresLocator.dto.JsonStore;
import com.jumbo.achievement.StoresLocator.dto.Store;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static com.fasterxml.jackson.databind.DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY;
import static java.util.Collections.unmodifiableList;

@Slf4j
@Repository
class StoresProviderImpl implements StoresProvider {

    private final String storesFilePath;

    StoresProviderImpl(@Value("${stores.file.path}") String storesFilePath) {
        this.storesFilePath = storesFilePath;
    }

    @Override
    @Cacheable("stores")
    public Collection<Store> getAllStores() {
        List<Store> stores = new ArrayList<>();
        final ObjectMapper mapper = new ObjectMapper().configure(ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
        final TypeReference<JsonStore> typeReference = new TypeReference<JsonStore>(){};

        try {
            log.info("Loading stores from JSON file...");
            final InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(storesFilePath);
            final JsonStore jsonStore =  mapper.readValue(inputStream,typeReference);
            stores = unmodifiableList(jsonStore.getStores());
        } catch (IOException e){
            log.error("Unable to load JSON file: " + e.getMessage());
        }
        return stores;
    }
}
