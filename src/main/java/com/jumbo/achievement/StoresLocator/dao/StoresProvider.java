package com.jumbo.achievement.StoresLocator.dao;

import com.jumbo.achievement.StoresLocator.dto.Store;

import java.util.Collection;

/**
 * Created by MichaelR on 8/9/2018.
 */
public interface StoresProvider {
    Collection<Store> getAllStores();
}
