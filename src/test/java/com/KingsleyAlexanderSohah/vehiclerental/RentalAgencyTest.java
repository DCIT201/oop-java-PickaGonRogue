package com.KingsleyAlexanderSohah.vehiclerental;

import com.KingsleyAlexanderSohah.vehiclerental.exceptions.InvalidRentalPeriodException;
import com.KingsleyAlexanderSohah.vehiclerental.exceptions.VehicleNotAvailableException;
import com.KingsleyAlexanderSohah.vehiclerental.transactions.RentalAgency;
import com.KingsleyAlexanderSohah.vehiclerental.vehicles.Car;
import com.KingsleyAlexanderSohah.vehiclerental.vehicles.Vehicle;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RentalAgencyTest {
    @Test
    public void testRentVehicle() throws VehicleNotAvailableException, InvalidRentalPeriodException {
        RentalAgency agency = new RentalAgency();
        Car car = new Car("C001", "Toyota", 50);
        agency.addVehicle(car);
        Vehicle rentedCar = agency.rentVehicle("C001", 3);
        assertNotNull(rentedCar);
        assertFalse(rentedCar.isAvailable());
    }

    @Test
    public void testRentVehicleNotAvailable() {
        RentalAgency agency = new RentalAgency();
        Car car = new Car("C001", "Toyota", 50);
        agency.addVehicle(car);
        assertThrows(VehicleNotAvailableException.class, () -> {
            agency.rentVehicle("C002", 3);
        });
    }

    @Test
    public void testInvalidRentalPeriod() {
        RentalAgency agency = new RentalAgency();
        Car car = new Car("C001", "Toyota", 50);
        agency.addVehicle(car);
        assertThrows(InvalidRentalPeriodException.class, () -> {
            agency.rentVehicle("C001", 0);
        });
    }
}
