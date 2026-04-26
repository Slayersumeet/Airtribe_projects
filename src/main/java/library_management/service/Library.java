package library_management.service;

import library_management.model.*;
import library_management.strategy.SearchStrategy;
import library_management.observer.*;

import java.util.*;

public class Library {

    private List<Book> books = new ArrayList<>();
    private Map<String, Patron> patrons = new HashMap<>();
    private List<Loan> loans = new ArrayList<>();
    private BookNotifier notifier = new BookNotifier();

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(String isbn) {
        books.removeIf(b -> b.getIsbn().equals(isbn));
    }

    public List<Book> searchBooks(SearchStrategy strategy, String keyword) {
        return strategy.search(books, keyword);
    }

    public void addPatron(Patron patron) {
        patrons.put(patron.getId(), patron);
    }

    public void checkoutBook(String patronId, String isbn) {
        Patron p = patrons.get(patronId);

        for (Book b : books) {
            if (b.getIsbn().equals(isbn) && b.isAvailable()) {

                Loan loan = new Loan(b, p);
                loans.add(loan);

                b.setAvailable(false);
                p.borrowBook(b);

                System.out.println("Book issued successfully");
                return;
            }
        }
        System.out.println("Book not available");
    }

    public void returnBook(String patronId, String isbn) {
        for (Loan loan : loans) {
            if (loan.getBook().getIsbn().equals(isbn)
                    && loan.getPatron().getId().equals(patronId)
                    && !loan.isReturned()) {

                loan.markReturned();
                loan.getBook().setAvailable(true);
                loan.getPatron().returnBook(loan.getBook());

                notifier.notifyObservers("Book returned: " + loan.getBook().getTitle());

                System.out.println("Book returned");
                return;
            }
        }
    }

    public void registerObserver(UserNotification o) {
        notifier.addObserver(o);
    }
}