package com.jumbo.achievement.storeslocator.core;

import com.jumbo.achievement.storeslocator.dao.StoreProvider;
import com.jumbo.achievement.storeslocator.dto.ComplexStore;
import com.jumbo.achievement.storeslocator.dto.Location;
import com.jumbo.achievement.storeslocator.dto.Store;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static com.jumbo.achievement.storeslocator.dto.Location.builder;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class StoreLocatorTest {

    @Test
    public void givenInitialPosition_findsStores() {
        final double latitude = 4.651356;
        final double longitude = -74.0603624;

        final List<Store> storesList = buildStoresList();

        final StoreProvider storeProviderMock = mock(StoreProvider.class);
        when(storeProviderMock.getAllStores()).thenReturn(storesList);

        final StoreLocator storeLocator = new StoreLocatorImpl(storeProviderMock);

        final Location startingPoint = builder().
                latitude(latitude).
                longitude(longitude)
                .build();

        final Collection<ComplexStore> result = storeLocator.locateNearestStores(startingPoint);

        Assert.assertNotNull(result);
        Assert.assertFalse(result.isEmpty());
        Assert.assertEquals(storesList.get(0).getUuid(), ((ComplexStore) result.toArray()[0]).getStore().getUuid());
        Assert.assertEquals(storesList.get(1).getUuid(), ((ComplexStore) result.toArray()[2]).getStore().getUuid());
        Assert.assertEquals(storesList.get(2).getUuid(), ((ComplexStore) result.toArray()[1]).getStore().getUuid());
    }

    @Test
    public void whenNoStoresProvided_returnsEmptyResult() {
        final double latitude = 4.651356;
        final double longitude = -74.0603624;

        final StoreProvider storeProviderMock = mock(StoreProvider.class);
        when(storeProviderMock.getAllStores()).thenReturn(Collections.emptyList());

        final StoreLocator storeLocator = new StoreLocatorImpl(storeProviderMock);

        final Location startingPoint = builder().
                latitude(latitude).
                longitude(longitude)
                .build();

        final Collection<ComplexStore> result = storeLocator.locateNearestStores(startingPoint);

        Assert.assertNotNull(result);
        Assert.assertTrue(result.isEmpty());
    }

    private List<Store> buildStoresList() {
        final List<Store> stores;

        final Store store1 = new Store(51.778461, 4.615551, "EOgKYx4XFiQAAAFJa_YYZ4At"); //distance 1.07
        final Store store2 = new Store(51.874272, 6.245829, "7ewKYx4Xqp0AAAFIHigYwKrH"); //distance 1.09
        final Store store3 = new Store(52.264417, 4.762433, "gssKYx4XJwoAAAFbn.BMqPTb"); //distance 1.08

        stores = Arrays.asList(store1, store2, store3);

        return stores;
    }
}
