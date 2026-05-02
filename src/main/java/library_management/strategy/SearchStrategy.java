package library_management.strategy;

import library_management.model.Book;
import java.util.List;

public interface SearchStrategy {
    List<Book> search(List<Book> books, String keyword);
}