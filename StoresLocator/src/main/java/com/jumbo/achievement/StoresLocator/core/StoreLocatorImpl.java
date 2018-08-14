package com.jumbo.achievement.StoresLocator.core;

import com.jumbo.achievement.StoresLocator.dao.IStoreDAO;
import com.jumbo.achievement.StoresLocator.dto.ComplexStore;
import com.jumbo.achievement.StoresLocator.dto.Store;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Comparator;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * Created by MichaelR on 8/9/2018.
 */
@Service
public class StoreLocatorImpl implements StoreLocator{
    private static final Logger logger = LoggerFactory.getLogger(StoreLocatorImpl.class);
    @Autowired
    private IStoreDAO storeDAO;


    public StoreLocatorImpl(IStoreDAO storeDAO) {
        this.storeDAO = storeDAO;
    }

    public Collection<ComplexStore> locateNearestStores(Location startingPoint){
        Location initialLocation = startingPoint;
        Collection<Store> allStores = storeDAO.getAllStores();
/*
       Collection<ComplexStore> foundStores = allStores.parallelStream()
                .map(store -> new ComplexStore(initialLocation.distanceTo(store), store))
                .sorted(Comparator.comparing(ComplexStore::getDistanceToStore))
                //.peek(c -> c.getDistanceToStore()).collect(Collectors.toList());
                .limit(5)
                .collect(Collectors.toList());
*/

        TreeSet<ComplexStore> sortedStoresByDistance = allStores.parallelStream()
                .map(store -> new ComplexStore(initialLocation.distanceTo(store), store))
                .collect(Collectors.toCollection(
                        ()->new TreeSet<>(Comparator.comparingDouble(ComplexStore::getDistanceToStore))));

        return sortedStoresByDistance.stream().limit(5).collect(Collectors.toList());
    }
}
