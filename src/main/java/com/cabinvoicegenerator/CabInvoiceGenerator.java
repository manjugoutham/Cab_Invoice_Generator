package com.cabinvoicegenerator;

import java.util.HashMap;
import java.util.Map;

public class CabInvoiceGenerator {

    public static final double COSTPerKM = 10.0;
    public static final double COSTPerMIN = 1.0;
    public static final double MIN_FARE = 5;

    // UC-3 method to check the Enhanced Invoice

    public CabInvoiceData calculateFareForMultiple_Ride(Ride[] rides) {
        double totalFare = 0;
        for (int i = 0; i < rides.length; i++) {
            Ride ride = rides[i];
            double fare = ride.getDistance() * COSTPerKM + ride.getTime() * COSTPerMIN;
            totalFare += fare;
        }
        return new CabInvoiceData(rides.length, totalFare);
    }
    // UC4 - Added UserID to get the invoice summary
    public CabInvoiceData cabSummaryCalculate(int userId) {
        Map<Integer, Ride[]> map = new HashMap<>();
        Ride[] rides = {
                new Ride(2.0,5),
                new Ride(0.1,1)
        };
        Ride[] rides1 = {
                new Ride(3.0,5),
                new Ride(0.1,1)
        };
        map.put(1, rides);
        map.put(2, rides1);
        for(Map.Entry<Integer, Ride[]> entry : map.entrySet()) {
            if(userId == entry.getKey()) {
                Ride[] data = entry.getValue();
                return calculateFareForMultiple_Ride(data);
            }
        }
        return null;
    }
}
