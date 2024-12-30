package com.KingsleyAlexanderSohah.vehiclerental.vehicles;

import com.KingsleyAlexanderSohah.vehiclerental.Rateable;
import java.util.ArrayList;
import java.util.List;

public abstract class Vehicle implements Rateable {
    private final String vehicleId;
    private final String model;
    private final double baseRentalRate;
    private boolean isAvailable;
    private final List<Integer> ratings;

    public Vehicle(String vehicleId, String model, double baseRentalRate) {
        this.vehicleId = vehicleId;
        this.model = model;
        this.baseRentalRate = baseRentalRate;
        this.isAvailable = true;
        this.ratings = new ArrayList<>();
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public String getModel() {
        return model;
    }

    public double getBaseRentalRate() {
        return baseRentalRate;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public abstract double calculateRentalCost(int days);

    public abstract boolean isAvailableForRental();

    @Override
    public void addRating(int rating) {
        ratings.add(rating);
    }

    @Override
    public double getAverageRating() {
        return ratings.stream().mapToInt(Integer::intValue).average().orElse(0.0);
    }
}
