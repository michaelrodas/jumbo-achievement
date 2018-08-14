package com.jumbo.achievement.StoresLocator.core;

import com.jumbo.achievement.StoresLocator.dto.Store;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Component;

/**
 * Created by MichaelR on 8/9/2018.
 */
@Configurable
public class Location
{
    private double      latitude;
    private double      longitude;

    public Location(double lat, double lng)
    {
        latitude = lat;
        longitude = lng;
    }

    // Compute the distance in meters
    public double distanceTo(Store store)
    {
        final double earthRadius = 3958.75;
        double dLat = Math.toRadians(latitude - store.getLatitude());
        double dLng = Math.toRadians(longitude - store.getLongitude());
        double a = Math.sin(dLat/2) * Math.sin(dLat/2) +
                Math.cos(Math.toRadians(latitude)) *
                        Math.cos(Math.toRadians(latitude)) *
                        Math.sin(dLng/2) * Math.sin(dLng/2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
        double dist = earthRadius * c;
        return dist * 1609;
    }

    public String toString()
    {
        return "Location: (" + latitude + ", " + longitude + ")";
    }
}
