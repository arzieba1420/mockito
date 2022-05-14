package mockito.test_doubles.dummy;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static java.time.LocalDate.*;


public class DummyTest {


    @Test
    public void demoDummy(){
        BookRepository bookRepository = new FakeBookRepository();
        EmailService emailService = new DummyEmailService();
        BookService bookService = new BookService(bookRepository,emailService);

        bookService.addBook(new Book("1234","Mockito In Action",250, now()));
        bookService.addBook(new Book("1235","JUnit In Action",200, now()));

        Assertions.assertEquals(2,bookService.findNumbersOfBooks());

    }

}
