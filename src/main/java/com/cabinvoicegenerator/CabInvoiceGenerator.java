package com.cabinvoicegenerator;

import java.util.HashMap;
import java.util.Map;

public class CabInvoiceGenerator {

    public static final double COSTPerKM = 10.0;
    public static final double COSTPerMIN = 1.0;
    public static final double MIN_FARE = 5;

    public static final double PREMIUMCOSTPerKM = 15.0;
    public static final double PREMIUMCOSTPerMIN = 2.0;
    public static final double PREMIUMMIN_FARE = 20;

    // UC-5 method to check the Total fare for both Normal and Premium Rides

    public double calculateFare(double distance, int time, String type) {
        if (type == "Normal") {
            double totalFare = distance * COSTPerKM + time * COSTPerMIN;
            if (totalFare < 5) {
                return MIN_FARE;
            }
            return totalFare;
        } else {
            double totalFare = distance * PREMIUMCOSTPerKM + time * PREMIUMCOSTPerMIN;
            if (totalFare < 20) {
                return PREMIUMMIN_FARE;
            }
            return totalFare;
        }
    }

    public CabInvoiceData calculateFareForMultiple_Ride(Ride[] rides, String type) {
        if (type == "Normal") {
            double totalFare = 0;
            for (int i = 0; i < rides.length; i++) {
                Ride ride = rides[i];
                double fare = ride.getDistance() * COSTPerKM + ride.getTime() * COSTPerMIN;
                totalFare += fare;
            }
            return new CabInvoiceData(rides.length, totalFare);
        } else {
            double totalFare = 0;
            for (int i = 0; i < rides.length; i++) {
                Ride ride = rides[i];
                double fare = ride.getDistance() * PREMIUMCOSTPerKM + ride.getTime() * PREMIUMCOSTPerMIN;
                totalFare += fare;
            }
            return new CabInvoiceData(rides.length, totalFare);
        }
    }


    public CabInvoiceData cabSummaryCalculate(int userId, String type) {
        if (type == "Normal") {
            Map<Integer, Ride[]> map = new HashMap<>();
            Ride[] rides = { new Ride(2.0, 5), new Ride(0.1, 1) };
            Ride[] rides1 = { new Ride(2.0, 5), new Ride(1.0, 1) };
            map.put(1, rides);
            map.put(2, rides1);
            for (Map.Entry<Integer, Ride[]> entry : map.entrySet()) {
                if (userId == entry.getKey()) {
                    Ride[] data = entry.getValue();
                    return calculateFareForMultiple_Ride(data, type);
                }
            }
            return null;
        } else {
            Map<Integer, Ride[]> map = new HashMap<>();
            Ride[] rides = { new Ride(2.0, 5), new Ride(1.0, 1) };
            Ride[] rides1 = { new Ride(2.0, 5), new Ride(1.0, 1) };
            map.put(1, rides);
            map.put(2, rides1);
            for (Map.Entry<Integer, Ride[]> entry : map.entrySet()) {
                if (userId == entry.getKey()) {
                    Ride[] data = entry.getValue();
                    return calculateFareForMultiple_Ride(data, type);
                }
            }
            return null;
        }
    }
}
