package com.jumbo.achievement.StoresLocator.dao;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jumbo.achievement.StoresLocator.dto.JsonStore;
import com.jumbo.achievement.StoresLocator.dto.Store;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by MichaelR on 8/9/2018.
 */
@Repository
public class StoreDAO implements IStoreDAO{
    private static final Logger logger = LoggerFactory.getLogger(StoreDAO.class);

    @Override
    @Cacheable("stores")
    public Collection<Store> getAllStores() {
        ArrayList<Store> stores = null;
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
        TypeReference<JsonStore> typeReference = new TypeReference<JsonStore>(){};
        InputStream inputStream = TypeReference.class.getResourceAsStream("/json/stores.json");
        try {
            logger.info("Loading stores from JSON file...");
            JsonStore jsonStore =  mapper.readValue(inputStream,typeReference);
            stores = new ArrayList<>(jsonStore.getStores());
        } catch (IOException e){
            logger.error("Unable to load JSON file: " + e.getMessage());
        }
        return stores;
    }
}
