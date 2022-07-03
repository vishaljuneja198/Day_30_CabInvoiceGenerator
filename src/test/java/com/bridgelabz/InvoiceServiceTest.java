package com.bridgelabz;

//import org.junit.Before;
//import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InvoiceServiceTest {
    InvoiceGenerator invoiceGenerator;



    @Test
    public void givenDistanceAndTime_ShouldReturnTotalFare() {
        invoiceGenerator = new InvoiceGenerator();
        double distance = 2.0;
        int time = 5;

        double fare = invoiceGenerator.calculateFare(distance, time);
        assertEquals(25.0, fare, 0.0);
    }

    @Test
    public void givenDistanceAndTime_WhenTotalFareLessThan10_ShouldReturnMinimumFare() {
        invoiceGenerator = new InvoiceGenerator();
        double distance = 0.1;
        int time = 1;
        double fare = invoiceGenerator.calculateFare(distance, time);
        assertEquals(5.0, fare, 0.0);
    }

    @Test
    public void givenMultipleRidees_ShouldReturnTotalFare(){
        invoiceGenerator=new InvoiceGenerator();
        Ride[] rides = {new Ride(2.0,5),
                new Ride(0.1,1)};
        double fare = invoiceGenerator.calculateFare(rides);
        assertEquals(30.0,fare,0.0);
    }

    @Test
    public void givenMultipleRidesShouldReturnRideSummary() {

        Ride[] rides = {new Ride(2.0, 5),
                new Ride(0.1, 1)};

        InvoiceSummary summary = invoiceGenerator.getInvoiceSummary(rides);
        InvoiceSummary expectedInvoicesummary = new InvoiceSummary(2, 30.0);
        assertEquals(expectedInvoicesummary, summary);

    }

    @Test
    public void givenUserIdShouldReturnTheInvoice() {
        String userId = "abc@123";
        Ride[] rides = { new Ride(2.0, 5), new Ride(0.1, 1) };
        invoiceGenerator.addRides(userId, rides);
        double summary = invoiceGenerator.getInvoiceSummary(userId);
        InvoiceSummary checkSummary = new InvoiceSummary(2, 30.0);
        assertEquals(30.0, summary);

    }

}
