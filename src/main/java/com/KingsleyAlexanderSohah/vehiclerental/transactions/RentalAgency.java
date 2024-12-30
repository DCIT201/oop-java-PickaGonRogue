package com.KingsleyAlexanderSohah.vehiclerental.transactions;

import com.KingsleyAlexanderSohah.vehiclerental.vehicles.Vehicle;
import com.KingsleyAlexanderSohah.vehiclerental.exceptions.VehicleNotAvailableException;
import com.KingsleyAlexanderSohah.vehiclerental.exceptions.InvalidRentalPeriodException;
import java.util.ArrayList;
import java.util.List;

public class RentalAgency {
    private List<Vehicle> vehicleFleet;

    public RentalAgency() {
        this.vehicleFleet = new ArrayList<>();
    }

    public void addVehicle(Vehicle vehicle) {
        vehicleFleet.add(vehicle);
    }

    public Vehicle rentVehicle(String vehicleId, int days) throws VehicleNotAvailableException, InvalidRentalPeriodException {
        if (days <= 0) {
            throw new InvalidRentalPeriodException("Rental period must be greater than zero.");
        }
        for (Vehicle vehicle : vehicleFleet) {
            if (vehicle.getVehicleId().equals(vehicleId) && vehicle.isAvailableForRental()) {
                vehicle.setAvailable(false);
                return vehicle;
            }
        }
        throw new VehicleNotAvailableException("Vehicle with ID " + vehicleId + " is not available for rental.");
    }

    public void returnVehicle(Vehicle vehicle) {
        vehicle.setAvailable(true);
    }

    public void generateReport() {
        // Implement report generation logic
    }
}
