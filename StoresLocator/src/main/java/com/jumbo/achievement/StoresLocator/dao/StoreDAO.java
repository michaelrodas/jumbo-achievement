package com.jumbo.achievement.StoresLocator.dao;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jumbo.achievement.StoresLocator.dto.JsonStore;
import com.jumbo.achievement.StoresLocator.dto.Store;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/**
 * Created by MichaelR on 8/9/2018.
 */
@Component
public class StoreDAO implements IStoreDAO{
    @Override
    public ArrayList<Store> getAllStores() {
        ArrayList<Store> stores = null;
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
        TypeReference<JsonStore> typeReference = new TypeReference<JsonStore>(){};
        InputStream inputStream = TypeReference.class.getResourceAsStream("/json/stores.json");
        try {
            JsonStore jsonStore =  mapper.readValue(inputStream,typeReference);
            stores = new ArrayList<>(jsonStore.getStores());
        } catch (IOException e){
            System.out.println("Unable to load JSON file: " + e.getMessage());
        }
        return stores;
    }
}
