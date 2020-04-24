package com.jumbo.achievement.StoresLocator.core;

import com.jumbo.achievement.StoresLocator.dao.StoreProvider;
import com.jumbo.achievement.StoresLocator.dto.ComplexStore;
import com.jumbo.achievement.StoresLocator.dto.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

import static com.jumbo.achievement.StoresLocator.util.DistanceCalculator.distanceTo;
import static java.util.Comparator.comparingDouble;

@Service
final class StoreLocatorImpl implements StoreLocator {

    final private StoreProvider storeProvider;

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
