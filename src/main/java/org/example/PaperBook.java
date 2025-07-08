package org.example;

public class PaperBook extends Book implements Purchasable {
    private int stock;
    public PaperBook(String ISBN, String title, Integer year, double price,int stock) {
       super(ISBN, title, year, price);
       this.stock = stock;
    }
    public double buy(int quantity, String email, String address) {
        if (stock < quantity) throw new RuntimeException("Not enough stock");
        stock -= quantity;
        ShippingService.sendTo(address);
        return quantity * this.getPrice();
    }


}
