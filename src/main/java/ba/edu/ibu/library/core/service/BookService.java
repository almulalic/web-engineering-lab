package ba.edu.ibu.library.core.service;

import ba.edu.ibu.library.core.api.MailSender;
import ba.edu.ibu.library.core.model.Book;
import ba.edu.ibu.library.core.model.User;
import ba.edu.ibu.library.core.repository.BookRepository;
import ba.edu.ibu.library.core.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private final BookRepository bookRepository;
    private final UserRepository usersRepository;
    private final MailSender mailSender;

    public BookService(
        BookRepository bookRepository,
        UserRepository usersRepository,
        MailSender mailSender
    ) {
        this.bookRepository = bookRepository;
        this.usersRepository = usersRepository;
        this.mailSender = mailSender;
    }

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public Book findById(int id) {
        return bookRepository.findbyId(id);
    }

    public String sendEmailToAllUsers(String message) {
        List<User> users = usersRepository.findAll();

        return mailSender.send(users, message);
    }
}
