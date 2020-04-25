package com.jumbo.achievement.storelocator.dao;

import com.jumbo.achievement.storelocator.dto.Store;

import java.util.Collection;

public interface StoreProvider {
    Collection<Store> getAllStores();
}
