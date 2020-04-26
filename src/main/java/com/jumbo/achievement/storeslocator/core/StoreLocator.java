package com.jumbo.achievement.storeslocator.core;

import com.jumbo.achievement.storeslocator.dto.ComplexStore;
import com.jumbo.achievement.storeslocator.dto.Location;

import java.util.Collection;

public interface StoreLocator {

    Collection<ComplexStore> locateNearestStores(Location startingPoint);
}
