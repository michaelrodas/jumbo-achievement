package com.jumbo.achievement.StoresLocator.dao;

import com.jumbo.achievement.StoresLocator.dto.Store;
import org.junit.Assert;
import org.junit.Test;

import java.util.Collection;

public class IStoreDAOTest {

    @Test
    public void whenRequested_returnsStoresList() {
        IStoreDAO storeDAO = new StoreDAO();
        Collection<Store> allStores = storeDAO.getAllStores();
        Assert.assertNotNull(allStores);
        Assert.assertEquals(587, allStores.size());
    }
}
