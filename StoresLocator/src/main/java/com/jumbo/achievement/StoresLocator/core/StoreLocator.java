package com.jumbo.achievement.StoresLocator.core;

import com.jumbo.achievement.StoresLocator.dto.ComplexStore;
import com.jumbo.achievement.StoresLocator.dto.Store;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by MichaelR on 8/9/2018.
 */
public class StoreLocator {

    @Autowired
    private ArrayList<Store> allStores;

    public StoreLocator(ArrayList<Store> allStores) {
        this.allStores = allStores;
    }

    public Collection<Store> locateNearestStores(Location startingPoint){
        Location initialLocation = startingPoint;
        double distance = -1;

        Map<UUID, ComplexStore> result = allStores.parallelStream()
                .map(store -> new ComplexStore(initialLocation.distanceTo(store), store))
                .sorted(Comparator.comparing(ComplexStore::getDistanceToStore))
                .limit(5)
                .collect(Collectors.toMap(c -> c.getStore().getUuid(), c -> c));

        /*
        allStores.parallelStream().map(store -> new ComplexStore(initialLocation.distanceTo(store), store))
        .collect(Collectors.toMap(c -> c.getDistanceToStore(), c -> c.getStore(), LinkedHashMap::new));
*/
        //result.forEach((k,v) -> System.out.println(v.getDistanceToStore() + "::" + v.getStore().getUuid()));

        //result.entrySet().stream().limit(5).map(entry -> entry.getValue().getStore()).collect(Collectors.toList());
        return result.entrySet().stream().map(entry -> entry.getValue().getStore()).collect(Collectors.toList());
    }
}
