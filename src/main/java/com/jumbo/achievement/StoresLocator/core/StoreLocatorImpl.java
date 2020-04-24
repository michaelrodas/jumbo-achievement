package com.jumbo.achievement.StoresLocator.core;

import com.jumbo.achievement.StoresLocator.dao.StoresProvider;
import com.jumbo.achievement.StoresLocator.dto.ComplexStore;
import com.jumbo.achievement.StoresLocator.dto.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.stream.Collectors;

import static com.jumbo.achievement.StoresLocator.util.DistanceCalculator.distanceTo;
import static java.util.Comparator.comparingDouble;
import static java.util.stream.Collectors.toCollection;

@Service
final class StoreLocatorImpl implements StoreLocator {

    final private StoresProvider storesProvider;

    @Autowired
    StoreLocatorImpl(StoresProvider storesProvider) {
        this.storesProvider = storesProvider;
    }

    public Collection<ComplexStore> locateNearestStores(Location startingPoint) {

        return storesProvider.getAllStores().parallelStream()
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
