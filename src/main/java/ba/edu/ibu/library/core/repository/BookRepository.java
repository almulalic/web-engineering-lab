package ba.edu.ibu.library.core.repository;

import ba.edu.ibu.library.core.model.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class BookRepository {
    private List<Book> books;

    public BookRepository() {
        this.books = Arrays.asList(
          new Book(1, "Book1", "science fiction", 2019),
          new Book(2, "Book2", "drama", 2003),
          new Book(3, "Book3", "history", 2010)
        );
    }

    public List<Book> findAll() {
        return books;
    }

    public Book findbyId(int id) {
        return books.stream()
            .filter(x -> x.getId() == id)
            .findFirst()
            .orElse(null);
    }
}
