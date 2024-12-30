package com.KingsleyAlexanderSohah.vehiclerental;

import com.KingsleyAlexanderSohah.vehiclerental.customers.Customer;

public interface Rentable {
    void rent(Customer customer, int days);
    void returnVehicle();
}
