package com.jumbo.achievement.storelocator.core;

import com.jumbo.achievement.storelocator.dto.ComplexStore;

import java.util.Collection;

public interface StoreLocator {

    Collection<ComplexStore> locateNearestStores(Location startingPoint);
}
