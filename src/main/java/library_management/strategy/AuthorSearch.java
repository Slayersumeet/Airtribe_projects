package library_management.strategy;

import library_management.model.Book;
import java.util.*;

public class AuthorSearch implements SearchStrategy {

    public List<Book> search(List<Book> books, String keyword) {
        List<Book> result = new ArrayList<>();
        for (Book b : books) {
            if (b.getAuthor().toLowerCase().contains(keyword.toLowerCase())) {
                result.add(b);
            }
        }
        return result;
    }
}