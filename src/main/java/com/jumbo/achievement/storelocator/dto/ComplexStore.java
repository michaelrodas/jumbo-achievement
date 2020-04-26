package com.jumbo.achievement.storelocator.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Builder
@Getter
public class ComplexStore {

    private double distanceToStore;
    private Store store;

}
