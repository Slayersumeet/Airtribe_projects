package library_management.main;

import library_management.model.*;
import library_management.service.Library;
import library_management.strategy.*;
import library_management.observer.*;

public class Main {

    public static void main(String[] args) {

        Library lib = new Library();


        lib.addBook(new Book("JAMES BOND", "SANDY", "199", 2020));
        lib.addBook(new Book("Harry and brook", "luffy", "200", 2021));


        Patron p = new Patron("1", "Sumeet");
        lib.addPatron(p);

        lib.registerObserver(new UserNotification("Sumeet"));

        System.out.println("<<--_ Search Results _-->>");
        for (Book b : lib.searchBooks(new TitleSearch(), "james")) {
            System.out.println(b);
        }


        System.out.println("\nCheckout:");
        lib.checkoutBook("1", "199");

        System.out.println("\nReturn:");
        lib.returnBook("1", "199");
    }
}