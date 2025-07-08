package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        Inventory inventory = new Inventory();

        inventory.addBook(new PaperBook("1", "Java Basics", 2019, 30.0, 10));
        inventory.addBook(new EBook("2", "Spring Boot Guide", 2021, 20.0, "PDF"));
        inventory.addBook(new ShowcaseBook("3", "Ancient Manuscript", 1990));

        try {
            double paid = inventory.buyBook("1", 2, "michael@example.com", "Cairo");
            System.out.println("Quantum book store: Paid amount = " + paid);
        } catch (Exception e) {
            System.out.println("Quantum book store: " + e.getMessage());
        }

        try {
            double paid = inventory.buyBook("2", 1, "michael@example.com", null);
            System.out.println("Quantum book store: Paid amount = " + paid);
        } catch (Exception e) {
            System.out.println("Quantum book store: " + e.getMessage());
        }
        try {
            double paid = inventory.buyBook("3", 1, "michael@example.com", null);
            System.out.println("Quantum book store: Paid amount = " + paid);
        } catch (Exception e) {
            System.out.println("Quantum book store: " + e.getMessage());
        }

        System.out.println("Quantum book store: Removing outdated books...");
        for (Book b : inventory.removeOutdatedBooks(10)) {
            System.out.println("Removed book isbn: " + b.getISBN());
        }
    }
}