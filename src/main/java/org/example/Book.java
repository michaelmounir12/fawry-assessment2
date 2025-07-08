package org.example;
// Add a book to the inventory with some details like
//ISBN(just any string identifier), title, year when the
//book is published, price
abstract public class Book {
    private String ISBN;
    private String title;
    private Integer year;
    private double price;

    public Book(String ISBN, String title, Integer year, double price) {
        this.ISBN = ISBN;
        this.title = title;
        this.year = year;
        this.price = price;
    }

    public String getISBN() {
        return ISBN;
    }

    public Integer getYear() {
        return year;
    }

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }
}
