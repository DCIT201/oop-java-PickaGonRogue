package com.KingsleyAlexanderSohah.vehiclerental;

import com.KingsleyAlexanderSohah.vehiclerental.vehicles.Car;
import com.KingsleyAlexanderSohah.vehiclerental.customers.Customer;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CarTest {
    @Test
    public void testCalculateRentalCost() {
        Car car = new Car("C001", "Toyota", 50);
        assertEquals(150, car.calculateRentalCost(3));
    }

    @Test
    public void testRentAndReturn() {
        Car car = new Car("C001", "Toyota", 50);
        Customer customer = new Customer("CU001", "John Doe");
        car.rent(customer, 3);
        assertFalse(car.isAvailable());
        car.returnVehicle();
        assertTrue(car.isAvailable());
    }
}
