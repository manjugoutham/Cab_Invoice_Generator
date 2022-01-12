package com.cabinvoicegenerator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CabInvoiceTest {
    CabInvoiceGenerator invoiceGenerator = new CabInvoiceGenerator();
    // UC-1 test method to check the fare returned through the method
    @Test
    public void givenDistanceAndTime_ShouldReturnFare() {
        double distance = 2.0;
        int time = 5;
        double result = invoiceGenerator.calculateFare(distance, time);
        Assertions.assertEquals(25,result,0);
    }

    // UC-1 test method check the minimum fare data
    @Test
    public void givenDistanceAndTime_ShouldReturnMinFare(){
        double distance = 0.1;
        int time = 1;
        double result = invoiceGenerator.calculateFare(distance,time);
        Assertions.assertEquals(5.0,result,0.0);
    }

    // UC-3 test method check the Enhanced Invoice
    @Test
    public void givenMultipleRide_ShouldReturnFare() {
        Ride[] rides = {
                new Ride(2.0,5),
                new Ride(1.0,1)
        };
        CabInvoiceData result = invoiceGenerator.calculateFareForMultiple_Ride(rides);
        CabInvoiceData expectedData = new CabInvoiceData(2,36.0,18.0);
        Assertions.assertEquals(result,expectedData);
    }
}
