package com.jumbo.achievement.storeslocator.dao;

import com.jumbo.achievement.storeslocator.dto.Store;

import java.util.Collection;

public interface StoreProvider {
    Collection<Store> getAllStores();
}
