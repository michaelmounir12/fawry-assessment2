package org.example;

public interface ShippingService {
    public static void sendTo(String address) {
        System.out.println("Shipping paper book to " + address);
    }
}
