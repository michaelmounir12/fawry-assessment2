package org.example;

import java.util.*;

public class Inventory {
    Map<String, Book> inventory = Collections.synchronizedMap(new HashMap<>());

    public void addBook(Book book){

        inventory.put(book.getISBN(), book);

    }
    public Book removeBook(String isbn) {
        return inventory.remove(isbn);
    }
    public List<Book> removeOutdatedBooks(int maxYears){
        List<Book> outdatedBooks = new ArrayList<>();
        int curYear = Calendar.getInstance().get(Calendar.YEAR);
        for(Book book : inventory.values()){
            if(curYear-book.getYear() > maxYears){
                outdatedBooks.add(removeBook(book.getISBN()));
            }
        }
        return outdatedBooks;
    }
    public double buyBook(String isbn, int quantity, String email, String address) throws Exception {
        Book book = inventory.get(isbn);
        if (book == null ) throw new Exception("Book not for sale");
        if (!(book instanceof Purchasable purchasable)) {
            throw new Exception("Book is not purchasable");
        }

        return purchasable.buy(quantity, email, address);
    }


}
