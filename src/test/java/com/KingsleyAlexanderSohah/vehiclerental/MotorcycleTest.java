package com.KingsleyAlexanderSohah.vehiclerental;

import com.KingsleyAlexanderSohah.vehiclerental.vehicles.Motorcycle;
import com.KingsleyAlexanderSohah.vehiclerental.customers.Customer;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MotorcycleTest {
    @Test
    public void
    testCalculateRentalCost() {
        Motorcycle motorcycle = new Motorcycle("M001", "Harley", 30);
        assertEquals(81, motorcycle.calculateRentalCost(3)); // 10% discount
    }

    @Test
    public void testRentAndReturn() {
        Motorcycle motorcycle = new Motorcycle("M001", "Harley", 30);
        Customer customer = new Customer("CU001", "John Doe");
        motorcycle.rent(customer, 3);
        assertFalse(motorcycle.isAvailable());
        motorcycle.returnVehicle();
        assertTrue(motorcycle.isAvailable());
    }
}
