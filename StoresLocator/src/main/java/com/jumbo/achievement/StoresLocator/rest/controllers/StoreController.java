package com.jumbo.achievement.StoresLocator.rest.controllers;

import com.jumbo.achievement.StoresLocator.dao.IStoreDAO;
import com.jumbo.achievement.StoresLocator.dto.Store;
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
    private IStoreDAO storeDAO;

    @RequestMapping(value = "/{latitude}/{longitude}", method = RequestMethod.GET)
    public ResponseEntity<Collection<Store>> getNearestStores(@PathVariable double latitude, @PathVariable double longitude){
        Collection<Store> storesList = storeDAO.getAllStores();
        //TODO invocar logica que trae las 5 tiendas
        Collection<Store> foundStores = null;
        if(foundStores.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(foundStores, HttpStatus.OK);
    }
}
