package com.cabinvoicegenerator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CabInvoiceTest {

    CabInvoiceGenerator invoiceGenerator = new CabInvoiceGenerator();

    // UC5 Added : Premium Rides to compute fare

    @Test
    public void givenDistanceAndTime_ShouldReturnFare() {
        double distance = 2.0;
        int time = 5;
        String type = "Normal";
        double result = invoiceGenerator.calculateFare(distance, time, type);
        Assertions.assertEquals(25, result, 0.0);
    }

    @Test
    public void givenDistanceAndTime_PremiumData_ShouldReturnFare() {
        double distance = 2.0;
        int time = 5;
        String type = "Premium";
        double result = invoiceGenerator.calculateFare(distance, time, type);
        Assertions.assertEquals(40, result, 0.0);
    }

    @Test
    public void givenDistanceAndTime_ShouldReturnMinFare() {
        double distance = 0.1;
        int time = 1;
        String type = "Normal";
        double result = invoiceGenerator.calculateFare(distance, time, type);
        Assertions.assertEquals(5.0, result, 0.0);
    }

    @Test
    public void givenDistanceAndTime_PremiumData_ShouldReturnMinFare() {
        double distance = 0.1;
        int time = 1;
        String type = "Premium";
        double result = invoiceGenerator.calculateFare(distance, time, type);
        Assertions.assertEquals(20.0, result, 0.0);
    }
    @Test
    public void givenMultipleRide_ShouldReturnFare() {
        Ride[] rides = { new Ride(2.0, 5), new Ride(0.1, 1) };
        String type = "Normal";
        CabInvoiceData result = invoiceGenerator.calculateFareForMultiple_Ride(rides, type);
        CabInvoiceData expectedData = new CabInvoiceData(2, 27.0);
        Assertions.assertEquals(result, expectedData);
    }

    @Test
    public void givenMultipleRide_PremiumData_ShouldReturnFare() {
        Ride[] rides = { new Ride(2.0, 5), new Ride(1.0, 1) };
        String type = "Premium";
        CabInvoiceData result = invoiceGenerator.calculateFareForMultiple_Ride(rides, type);
        CabInvoiceData expectedData = new CabInvoiceData(2, 57.0);
        Assertions.assertEquals(result, expectedData);
    }

    @Test
    public void givenUserID_ShouldReturnInvoiceData() {
        String type = "Normal";
        CabInvoiceData cabInvoiceData = invoiceGenerator.cabSummaryCalculate(1, type);
        CabInvoiceData expectedResult = new CabInvoiceData(2, 27.0);
        Assertions.assertEquals(cabInvoiceData.getInvoiceData(), expectedResult.getInvoiceData());
    }

    @Test
    public void givenUserID_PremiumData_ShouldReturnInvoiceData() {
        String type = "Premium";
        CabInvoiceData cabInvoiceData = invoiceGenerator.cabSummaryCalculate(1, type);
        CabInvoiceData expectedResult = new CabInvoiceData(2, 57.0);
        Assertions.assertEquals(cabInvoiceData.getInvoiceData(), expectedResult.getInvoiceData());
    }
}
