package com.cabinvoicegenerator;

public class CabInvoiceGenerator {

    public static final double COSTPerKM = 10.0;
    public static final double COSTPerMIN = 1.0;
    public static final double MIN_FARE = 5;

    // UC-1 method to check the total fare for the journey

    public double calculateFare(double distance, int time) {
        double totalFare = (distance * COSTPerKM) + (time * COSTPerMIN);
        if (totalFare < 5) {
            return MIN_FARE;
        }
        return totalFare;
    }

    // UC-2 method to check the total fare for the multiple journey

    public double calculateFareForMultiple_Ride(Ride[] rides) {
        double totalFare = 0;
        for(int i = 0; i < rides.length; i++) {
            Ride ride = rides[i];
            double fare = ride.getDistance() * COSTPerKM + ride.getTime() * COSTPerMIN;
            totalFare += fare;
        }
        return totalFare;
    }
}
