package com.cabinvoicegenerator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CabInvoiceTest {
    CabInvoiceGenerator invoiceGenerator = new CabInvoiceGenerator();
    // UC-1 test method to check the fare returned through the method
    @Test
    public void givenMultipleRide_ShouldReturnFare() {
        Ride[] rides = {
                new Ride(2.0,5),
                new Ride(1.0,1)
        };
        CabInvoiceData result = invoiceGenerator.calculateFareForMultiple_Ride(rides);
        CabInvoiceData expectedData = new CabInvoiceData(2,36.0);
        Assertions.assertEquals(result,expectedData);
    }

    // UC4 - test method for  UserID to get the invoice summary
    @Test
    public void givenUserID_ShouldReturnInvoiceData() {
        CabInvoiceData cabInvoiceData = invoiceGenerator.cabSummaryCalculate(2);
        CabInvoiceData expectedResult = new CabInvoiceData(2, 37.0);
        Assertions.assertEquals(cabInvoiceData.getInvoiceData(),expectedResult.getInvoiceData());
    }
}
