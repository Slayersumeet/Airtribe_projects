package library_management.strategy;

import library_management.model.Book;
import java.util.*;

public class IsbnSearch implements SearchStrategy {

    public List<Book> search(List<Book> books, String keyword) {
        List<Book> result = new ArrayList<>();
        for (Book b : books) {
            if (b.getIsbn().equals(keyword)) {
                result.add(b);
            }
        }
        return result;
    }
}