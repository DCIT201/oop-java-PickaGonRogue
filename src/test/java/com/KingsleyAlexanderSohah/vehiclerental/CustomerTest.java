package com.KingsleyAlexanderSohah.vehiclerental;

import com.KingsleyAlexanderSohah.vehiclerental.customers.Customer;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CustomerTest {
    @Test
    public void testAddRentalHistory() {
        Customer customer = new Customer("CU001", "John Doe");
        customer.addRentalHistory("Rented Car: Toyota for 3 days.");
        assertTrue(customer.getRentalHistory().contains("Rented Car: Toyota for 3 days."));
    }

    @Test
    public void testLoyaltyPoints() {
        Customer customer = new Customer("CU001", "John Doe");
        customer.addLoyaltyPoints(10);
        assertEquals(10, customer.getLoyaltyPoints());
    }
}
