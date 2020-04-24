package com.jumbo.achievement.StoresLocator.core;

import com.jumbo.achievement.StoresLocator.dao.StoreProvider;
import com.jumbo.achievement.StoresLocator.dto.ComplexStore;
import com.jumbo.achievement.StoresLocator.dto.Store;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static com.jumbo.achievement.StoresLocator.core.Location.builder;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class StoreLocatorTest {

    @Test
    public void givenInitialPosition_findsStores() {
        final double latitude = 4.651356;
        final double longitude = -74.0603624;

        List<Store> storesList = buildStoresList();

        StoreProvider storeProviderMock = mock(StoreProvider.class);
        when(storeProviderMock.getAllStores()).thenReturn(storesList);

        StoreLocator storeLocator = new StoreLocatorImpl(storeProviderMock);

        Location startingPoint = builder().
                latitude(latitude).
                longitude(longitude)
                .build();

        Collection<ComplexStore> result = storeLocator.locateNearestStores(startingPoint);

        Assert.assertNotNull(result);
        Assert.assertFalse(result.isEmpty());
        Assert.assertEquals(storesList.get(0).getUuid(), ((ComplexStore) result.toArray()[0]).getStore().getUuid());
        Assert.assertEquals(storesList.get(1).getUuid(), ((ComplexStore) result.toArray()[2]).getStore().getUuid());
        Assert.assertEquals(storesList.get(2).getUuid(), ((ComplexStore) result.toArray()[1]).getStore().getUuid());
    }

    private List<Store> buildStoresList() {
        List<Store> stores;
        Store store1 = new Store(51.778461, 4.615551, "EOgKYx4XFiQAAAFJa_YYZ4At"); //distance 1.07
        Store store2 = new Store(51.874272, 6.245829, "7ewKYx4Xqp0AAAFIHigYwKrH"); //distance 1.09
        Store store3 = new Store(52.264417, 4.762433, "gssKYx4XJwoAAAFbn.BMqPTb"); //distance 1.08
        stores = Arrays.asList(store1, store2, store3);

        return stores;
    }
}
