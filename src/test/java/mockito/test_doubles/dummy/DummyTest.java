package mockito.test_doubles.dummy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

import static java.time.LocalDate.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DummyTest {

    @Test
    public void demoDummy(){
        BookRepository bookRepository = new FakeBookRepository();
        EmailService emailService = new DummyEmailService();
        BookService bookService = new BookService(bookRepository,emailService);

        bookService.addBook(new Book("1234","Mockito In Action",250, now()));
        bookService.addBook(new Book("1235","JUnit In Action",200, now()));

        assertEquals(2,bookService.findNumbersOfBooks());
    }

    @Test
    public void demoDummyWithMockito(){
        BookRepository bookRepository = Mockito.mock(BookRepository.class);
        EmailService emailService = Mockito.mock(EmailService.class);
        BookService bookService = new BookService(bookRepository,emailService);

        Book book1 = new Book("1234","Mockito in action",250, LocalDate.now());
        Book book2 = new Book("1235","JUnit 5 in action",200, LocalDate.now());

        Collection<Book> books = new ArrayList<>();
        books.add(book1);
        books.add(book2);

        Mockito.when(bookRepository.findAll()).thenReturn(books);

        assertEquals(2,bookService.findNumbersOfBooks());


    }

}
