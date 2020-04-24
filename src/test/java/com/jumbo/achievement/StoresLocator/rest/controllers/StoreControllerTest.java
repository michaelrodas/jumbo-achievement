package com.jumbo.achievement.StoresLocator.rest.controllers;

import com.jumbo.achievement.StoresLocator.core.StoreLocator;
import com.jumbo.achievement.StoresLocator.dto.ComplexStore;
import com.jumbo.achievement.StoresLocator.dto.Store;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.core.Is.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(StoreController.class)
public class StoreControllerTest {

    @Autowired
    private MockMvc mvc;
    @MockBean
    private StoreLocator service;

    @Test
    public void givenInitialPosition_whenFindsStores_thenReturnJsonArray()
            throws Exception {

        given(service.locateNearestStores(any())).willReturn(getFoundStoresList());

        mvc.perform(get("/stores/4.651356/-74.0603624")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(3)))
                .andExpect(jsonPath("$[0].distanceToStore", is(1.07)));
    }

    private List<ComplexStore> getFoundStoresList() {
        List<ComplexStore> stores;

        Store store1 = new Store(51.778461, 4.615551, "EOgKYx4XFiQAAAFJa_YYZ4At"); //distance 1.07
        Store store2 = new Store(51.874272, 6.245829, "7ewKYx4Xqp0AAAFIHigYwKrH"); //distance 1.09
        Store store3 = new Store(52.264417, 4.762433, "gssKYx4XJwoAAAFbn.BMqPTb"); //distance 1.08

        ComplexStore complexStore1 = new ComplexStore(1.07, store1);
        ComplexStore complexStore2 = new ComplexStore(1.09, store2);
        ComplexStore complexStore3 = new ComplexStore(1.08, store3);

        stores = Arrays.asList(complexStore1, complexStore2, complexStore3);

        return stores;
    }
}
