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

/**
 * Created by MichaelR on 8/9/2018.
 */
@RestController
@RequestMapping("/stores")
public class StoreController {

    @Autowired
    private StoreLocator storeLocator;

    @RequestMapping(value = "/{latitude}/{longitude}", method = RequestMethod.GET)
    public ResponseEntity<Collection<ComplexStore>> getNearestStores(@PathVariable double latitude, @PathVariable double longitude){
        Location startingPoint = new Location(latitude, longitude);
        Collection<ComplexStore> foundStores = storeLocator.locateNearestStores(startingPoint);
        if(foundStores.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(foundStores, HttpStatus.OK);
    }
}
