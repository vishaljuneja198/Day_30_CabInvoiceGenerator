package com.bridgelabz;

import java.util.Objects;

public class InvoiceSummary {
    private int numofRides;
    private double totalFare;
    private double avrageFare;

    public InvoiceSummary(int numofRides, double totalFare) {
        this.numofRides = numofRides;
        this.totalFare = totalFare;
        this.avrageFare = this.totalFare;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof InvoiceSummary)) return false;
        InvoiceSummary that = (InvoiceSummary) o;
        return numofRides == that.numofRides && Double.compare(that.totalFare, totalFare) == 0 && Double.compare(that.avrageFare, avrageFare) == 0;
    }
}