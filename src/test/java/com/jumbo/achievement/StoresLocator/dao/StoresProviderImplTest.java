package com.jumbo.achievement.StoresLocator.dao;

import com.jumbo.achievement.StoresLocator.dto.Store;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collection;

@RunWith(SpringRunner.class)
@TestPropertySource("/application.properties")
public class StoresProviderImplTest {

    @Value("${stores.file.path}")
    private String filePath;

    @Test
    public void whenRequested_returnsStoresList() {
        StoresProvider storesProvider = new StoresProviderImpl(filePath);
        Collection<Store> allStores = storesProvider.getAllStores();
        Assert.assertNotNull(allStores);
        Assert.assertEquals(10, allStores.size());
    }
}
