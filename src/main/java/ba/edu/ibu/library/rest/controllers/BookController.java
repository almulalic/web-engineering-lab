package ba.edu.ibu.library.rest.controllers;

import ba.edu.ibu.library.core.model.Book;
import ba.edu.ibu.library.core.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/books")
public class BookController {
    private final BookService bookService;

    public BookController(final BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> findAll() {
        return bookService.findAll();
    }

    @GetMapping("/{id}")
    public Book findById(@PathVariable int id) {
        return bookService.findById(id);
    }

    @GetMapping("sendMail/{message}")
    public String sendMail(@PathVariable String message) {
        return bookService.sendEmailToAllUsers(message);
    }
}