package com.jumbo.achievement.storelocator.core;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@ToString
@EqualsAndHashCode
public class Location {

    private double latitude;
    private double longitude;

}
