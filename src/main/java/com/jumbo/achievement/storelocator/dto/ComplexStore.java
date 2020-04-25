package com.jumbo.achievement.storelocator.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@ToString
@EqualsAndHashCode
public class ComplexStore {

    private double distanceToStore;
    private Store store;

}
