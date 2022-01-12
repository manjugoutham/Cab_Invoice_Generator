package com.cabinvoicegenerator;
public class CabInvoiceData {

    int totalNumberOfRide;
    double totalFare;
    double avgFarePerRide;

    public CabInvoiceData(int totalNumberOfRide, double totalFare) {
        this.totalNumberOfRide = totalNumberOfRide;
        this.totalFare = totalFare;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;

        CabInvoiceData other = (CabInvoiceData) obj;
        return totalNumberOfRide == other.totalNumberOfRide && Double.compare(other.totalFare, totalFare) == 0 && Double.compare(other.avgFarePerRide, avgFarePerRide) == 0;
    }

    public CabInvoiceData getInvoiceData() {
        this.avgFarePerRide = this.totalFare / this.totalNumberOfRide;
        return this;
    }
}
