package com.KingsleyAlexanderSohah.vehiclerental.vehicles;

import com.KingsleyAlexanderSohah.vehiclerental.Rentable;
import com.KingsleyAlexanderSohah.vehiclerental.customers.Customer;

public class Motorcycle extends Vehicle implements Rentable {
    public Motorcycle(String vehicleId, String model, double baseRentalRate) {
        super(vehicleId, model, baseRentalRate);
    }

    @Override
    public double calculateRentalCost(int days) {
        return getBaseRentalRate() * days * 0.9; // 10% discount for motorcycles
    }

    @Override
    public boolean isAvailableForRental() {
        return isAvailable();
    }

    @Override
    public void rent(Customer customer, int days) {
        if (isAvailableForRental()) {
            setAvailable(false);
            customer.addRentalHistory("Rented Motorcycle: " + getModel() + " for " + days + " days.");
        }
    }

    @Override
    public void returnVehicle() {
        setAvailable(true);
    }
}
