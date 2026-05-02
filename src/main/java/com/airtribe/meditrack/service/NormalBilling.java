package com.airtribe.meditrack.service;

import com.airtribe.meditrack.interfaces.BillingStrategy;

public class NormalBilling implements BillingStrategy {
    public double calculate(double amount) {
        return amount + amount * 0.1;
    }
}