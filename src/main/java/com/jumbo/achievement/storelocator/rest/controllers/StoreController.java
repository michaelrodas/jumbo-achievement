package com.jumbo.achievement.storelocator.rest.controllers;

import com.jumbo.achievement.storelocator.core.Location;
import com.jumbo.achievement.storelocator.core.StoreLocator;
import com.jumbo.achievement.storelocator.dto.ComplexStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/stores")
final class StoreController {

    private final StoreLocator storeLocator;

    @Autowired
    public StoreController(StoreLocator storeLocator) {
        this.storeLocator = storeLocator;
    }

    @GetMapping(value = "/{latitude}/{longitude}")
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
