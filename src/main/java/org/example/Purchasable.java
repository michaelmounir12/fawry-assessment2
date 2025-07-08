package org.example;

public interface Purchasable {
    double buy(int quantity, String email, String address) throws Exception;
}