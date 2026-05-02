package com.airtribe.meditrack.entity;

public final class BillSummary {

    private final double amount;
    private final double tax;
    private final double total;

    public BillSummary(double amount, double tax) {
        this.amount = amount;
        this.tax = tax;
        this.total = amount + tax;
    }

    public double getTotal() {
        return total;
    }
}