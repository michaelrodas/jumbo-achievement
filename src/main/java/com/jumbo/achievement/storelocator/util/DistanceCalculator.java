package com.jumbo.achievement.storelocator.util;

import com.jumbo.achievement.storelocator.dto.Location;
import com.jumbo.achievement.storelocator.dto.Store;

import static java.lang.Math.*;
import static java.lang.Math.sqrt;

public class DistanceCalculator {

    private DistanceCalculator() {
    }

    // Compute the distance in meters
    public static double distanceTo(Location location, Store store) {
        final double earthRadius = 3958.75;
        double dLat = toRadians(location.getLatitude() - store.getLatitude());
        double dLng = toRadians(location.getLongitude() - store.getLongitude());
        double a = sin(dLat / 2) * sin(dLat / 2) +
                cos(toRadians(location.getLatitude())) *
                        cos(toRadians(location.getLatitude())) *
                        sin(dLng / 2) * sin(dLng / 2);
        double c = 2 * atan2(sqrt(a), sqrt(1 - a));
        double dist = earthRadius * c;
        return dist * 1609;
    }
}
