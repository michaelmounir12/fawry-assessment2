package org.example;

public class EBook extends Book implements  Purchasable {
    private String fileType;
    public EBook(String ISBN, String title, Integer year, double price,String fileType) {
        super(ISBN, title, year, price);
        this.fileType = fileType;
    }
    public double buy(int quantity, String email, String address) {

        MailService.sendTo(email);
        return this.getPrice();
    }

}
