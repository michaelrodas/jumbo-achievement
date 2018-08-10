package com.jumbo.achievement.StoresLocator.core;

import com.jumbo.achievement.StoresLocator.dto.Store;

/**
 * Created by MichaelR on 8/9/2018.
 */
public class Location
{
    //@Min(value = -90, message = "Age should not be less than 18")
    //@Max(value = 90, message = "Age should not be greater than 150")
    private double      latitude;
    //@Min(value = -180, message = "Age should not be less than 18")
    //@Max(value = 180, message = "Age should not be greater than 150")
    private double      longitude;

    public Location(double lat, double lng)
    {
        latitude = lat;
        longitude = lng;
    }

    // Compute the distance in meters
    public double distanceTo(Store store)
    {
        double earthRadius = 3958.75;
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
