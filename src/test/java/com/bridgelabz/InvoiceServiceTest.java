package com.bridgelabz;

//import org.junit.Before;
//import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InvoiceServiceTest {
    InvoiceGenerator invoiceGenerator;
    @Test
    public void givenMultipleRide_ShouldReturnInvoiceSummary() {
        Ride[] rides = {
                new Ride(CategoryRide.REGULAR, 2, 5),
                new Ride(CategoryRide.REGULAR, 0.1, 1)
        };
        InvoiceSummary summary = invoiceGenerator.calculateFare(rides);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(30, 2);
        assertEquals(expectedInvoiceSummary, summary);
    }

    @Test
    public void givenUserIDAndRides_ShouldReturnInvoiceSummary() {
        Map<String, Ride[]> rideBook = new HashMap<>();
        Ride[] rides = {
                new Ride(CategoryRide.REGULAR, 2.0, 5),
                new Ride(CategoryRide.REGULAR, 0.1, 1)
        };
        Ride[] rides1 = {
                new Ride(CategoryRide.REGULAR, 3.0, 5),
                new Ride(CategoryRide.REGULAR, 0.1, 1)
        };
        rideBook.put("ram", rides);
        rideBook.put("kumar", rides1);
        String userID = "ram";
        InvoiceSummary summary = invoiceGenerator.calculateFare(userID, rideBook);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(30, 2);
        assertEquals(expectedInvoiceSummary, summary);
    }


    @Test
    public void givenNormalAndPremiumRideRate_ShouldReturnTotalFare() {
        Map<String, Ride[]> rideBook = new HashMap<>();
        Ride[] rides = {
                new Ride(CategoryRide.PREMIUM, 2.0, 5),
                new Ride(CategoryRide.REGULAR, 0.1, 1)
        };
        Ride[] rides1 = {
                new Ride(CategoryRide.PREMIUM, 3.0, 5),
                new Ride(CategoryRide.REGULAR, 0.1, 1)
        };
        rideBook.put("ram", rides);
        rideBook.put("kumar", rides1);
        String userID = "kumar";
        InvoiceSummary summary = invoiceGenerator.calculateFare(userID, rideBook);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(60, 2);
        assertEquals(expectedInvoiceSummary, summary);
    }
}