package com.KingsleyAlexanderSohah.vehiclerental.vehicles;

import com.KingsleyAlexanderSohah.vehiclerental.Rentable;
import com.KingsleyAlexanderSohah.vehiclerental.customers.Customer;

public class Truck extends Vehicle implements Rentable {
    public Truck(String vehicleId, String model, double baseRentalRate) {
        super(vehicleId, model, baseRentalRate);
    }

    @Override
    public double calculateRentalCost(int days) {
        return getBaseRentalRate() * days * 1.2; // 20% surcharge for trucks
    }

    @Override
    public boolean isAvailableForRental() {
        return isAvailable();
    }

    @Override
    public void rent(Customer customer, int days) {
        if (isAvailableForRental()) {
            setAvailable(false);
            customer.addRentalHistory("Rented Truck: " + getModel() + " for " + days + " days.");
        }
    }

    @Override
    public void returnVehicle() {
        setAvailable(true);
    }
}
