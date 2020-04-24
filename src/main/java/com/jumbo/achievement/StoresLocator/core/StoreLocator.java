package com.jumbo.achievement.StoresLocator.core;

import com.jumbo.achievement.StoresLocator.dto.ComplexStore;

import java.util.Collection;

public interface StoreLocator {

    Collection<ComplexStore> locateNearestStores(Location startingPoint);
}
