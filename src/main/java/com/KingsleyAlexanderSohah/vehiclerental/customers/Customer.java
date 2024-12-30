package com.KingsleyAlexanderSohah.vehiclerental.customers;

import com.KingsleyAlexanderSohah.vehiclerental.LoyaltyProgram;

public class Customer implements LoyaltyProgram {
    private final String customerId;
    private final String name;
    private String rentalHistory;
    private int loyaltyPoints;

    public Customer(String customerId, String name) {
        this.customerId = customerId;
        this.name = name;
        this.rentalHistory = "";
        this.loyaltyPoints = 0;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }

    public String getRentalHistory() {
        return rentalHistory;
    }

    public void addRentalHistory(String rental) {
        this.rentalHistory += rental + "\n";
    }

    @Override
    public void addLoyaltyPoints(int points) {
        this.loyaltyPoints += points;
    }

    @Override
    public int getLoyaltyPoints() {
        return loyaltyPoints;
    }
}
