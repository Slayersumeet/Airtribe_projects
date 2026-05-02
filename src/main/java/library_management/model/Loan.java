package library_management.model;

import java.time.LocalDate;

public class Loan {
    private Book book;
    private Patron patron;
    private LocalDate issueDate;
    private LocalDate dueDate;
    private boolean returned;

    public Loan(Book book, Patron patron) {
        this.book = book;
        this.patron = patron;
        this.issueDate = LocalDate.now();
        this.dueDate = issueDate.plusDays(14);
        this.returned = false;
    }

    public Book getBook() { return book; }
    public Patron getPatron() { return patron; }
    public boolean isReturned() { return returned; }

    public void markReturned() {
        this.returned = true;
    }
}