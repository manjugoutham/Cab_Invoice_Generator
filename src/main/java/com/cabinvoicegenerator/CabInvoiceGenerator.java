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
}
