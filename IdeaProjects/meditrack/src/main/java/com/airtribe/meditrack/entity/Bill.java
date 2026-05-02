package com.airtribe.meditrack.entity;

import com.airtribe.meditrack.interfaces.BillingStrategy;

public class Bill {

    private double amount;
    private BillingStrategy strategy;

    public Bill(double amount, BillingStrategy strategy) {
        this.amount = amount;
        this.strategy = strategy;
    }

    public double generateBill() {
        return strategy.calculate(amount);
    }
}