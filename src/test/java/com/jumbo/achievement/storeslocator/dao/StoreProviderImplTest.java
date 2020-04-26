package com.jumbo.achievement.storeslocator.dao;

import com.jumbo.achievement.storeslocator.dto.Store;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collection;

@RunWith(SpringRunner.class)
@TestPropertySource("/application.properties")
public class StoreProviderImplTest {

    @Value("${stores.file.path}")
    private String filePath;

    @Test
    public void whenRequested_returnsStoresList() {
        StoreProvider storeProvider = new StoreProviderImpl(filePath);
        Collection<Store> allStores = storeProvider.getAllStores();
        Assert.assertNotNull(allStores);
        Assert.assertEquals(10, allStores.size());
    }

    @Test
    public void whenFileNotFound_returnsEmptyList(){
        StoreProvider storeProvider = new StoreProviderImpl("dummyFile");
        Collection<Store> allStores = storeProvider.getAllStores();
        Assert.assertNotNull(allStores);
        Assert.assertTrue(allStores.isEmpty());
    }
}
