package com.KingsleyAlexanderSohah.vehiclerental;

import com.KingsleyAlexanderSohah.vehiclerental.vehicles.Truck;
import com.KingsleyAlexanderSohah.vehiclerental.customers.Customer;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TruckTest {
    @Test
    public void testCalculateRentalCost() {
        Truck truck = new Truck("T001", "Ford", 70);
        assertEquals(252, truck.calculateRentalCost(3)); // 20% surcharge
    }

    @Test
    public void testRentAndReturn() {
        Truck truck = new Truck("T001", "Ford", 70);
        Customer customer = new Customer("CU001", "John Doe");
        truck.rent(customer, 3);
        assertFalse(truck.isAvailable());
        truck.returnVehicle();
        assertTrue(truck.isAvailable());
    }
}
