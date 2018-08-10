package com.jumbo.achievement.StoresLocator.dao;

import com.jumbo.achievement.StoresLocator.dto.Store;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * Created by MichaelR on 8/9/2018.
 */
@Component
public class StoreDAO implements IStoreDAO{
    @Override
    public Collection<Store> getAllStores() {
        //TODO lee archivo json y arma lista de Stores
        return null;
    }
}
