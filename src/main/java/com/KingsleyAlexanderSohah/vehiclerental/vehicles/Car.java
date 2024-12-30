package com.KingsleyAlexanderSohah.vehiclerental.vehicles;

import com.KingsleyAlexanderSohah.vehiclerental.Rentable;
import com.KingsleyAlexanderSohah.vehiclerental.customers.Customer;

public class Car extends Vehicle implements Rentable {
    public Car(String vehicleId, String model, double baseRentalRate) {
        super(vehicleId, model, baseRentalRate);
    }

    @Override
    public double calculateRentalCost(int days) {
        return getBaseRentalRate() * days;
    }

    @Override
    public boolean isAvailableForRental() {
        return isAvailable();
    }

    @Override
    public void rent(Customer customer, int days) {
        if (isAvailableForRental()) {
            setAvailable(false);
            customer.addRentalHistory("Rented Car: " + getModel() + " for " + days + " days.");
        }
    }

    @Override
    public void returnVehicle() {
        setAvailable(true);
    }
}
