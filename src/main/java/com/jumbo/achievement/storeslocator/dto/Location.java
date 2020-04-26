package com.jumbo.achievement.storeslocator.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Builder
@Getter
public class Location {

    private double latitude;
    private double longitude;

}
