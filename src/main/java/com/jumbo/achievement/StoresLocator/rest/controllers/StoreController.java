package com.jumbo.achievement.StoresLocator.rest.controllers;

import com.jumbo.achievement.StoresLocator.core.Location;
import com.jumbo.achievement.StoresLocator.core.StoreLocator;
import com.jumbo.achievement.StoresLocator.dto.ComplexStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/stores")
final class StoreController {

    private final StoreLocator storeLocator;

    @Autowired
    public StoreController(StoreLocator storeLocator) {
        this.storeLocator = storeLocator;
    }

    @RequestMapping(value = "/{latitude}/{longitude}", method = RequestMethod.GET)
    public ResponseEntity<Collection<ComplexStore>> getNearestStores(
            @PathVariable final double latitude,
            @PathVariable final double longitude) {

        Location startingPoint = Location.builder().
                latitude(latitude).
                longitude(longitude)
                .build();

        Collection<ComplexStore> foundStores = storeLocator.locateNearestStores(startingPoint);

        return foundStores.isEmpty() ?
                new ResponseEntity<>(HttpStatus.NO_CONTENT) :
                new ResponseEntity<>(foundStores, HttpStatus.OK);
    }
}
