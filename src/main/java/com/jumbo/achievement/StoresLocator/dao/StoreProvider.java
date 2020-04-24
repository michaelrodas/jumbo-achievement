package com.jumbo.achievement.StoresLocator.dao;

import com.jumbo.achievement.StoresLocator.dto.Store;

import java.util.Collection;

public interface StoreProvider {
    Collection<Store> getAllStores();
}
