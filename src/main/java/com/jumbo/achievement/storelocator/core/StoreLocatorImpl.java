package com.jumbo.achievement.storelocator.core;

import com.jumbo.achievement.storelocator.dao.StoreProvider;
import com.jumbo.achievement.storelocator.dto.ComplexStore;
import com.jumbo.achievement.storelocator.dto.Location;
import com.jumbo.achievement.storelocator.dto.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

import static com.jumbo.achievement.storelocator.util.DistanceCalculator.distanceTo;
import static java.util.Comparator.comparingDouble;

@Service
final class StoreLocatorImpl implements StoreLocator {

    private final StoreProvider storeProvider;

    @Autowired
    StoreLocatorImpl(StoreProvider storeProvider) {
        this.storeProvider = storeProvider;
    }

    public Collection<ComplexStore> locateNearestStores(Location startingPoint) {

        return storeProvider.getAllStores().parallelStream()
                .map(store -> buildComplexStore(startingPoint, store))
                .sorted(comparingDouble(ComplexStore::getDistanceToStore))
                .limit(5)
                .collect(Collectors.toList());
    }

    private ComplexStore buildComplexStore(final Location startingPoint,
                                           final Store store) {
        return ComplexStore.builder()
                .store(store)
                .distanceToStore(distanceTo(startingPoint, store))
                .build();
    }
}
