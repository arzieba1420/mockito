package mockito.test_doubles.spy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static java.time.LocalDate.now;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class SpyTest {

    @Test
    public void demoSpy(){

        BookRepositorySpy bookRepository = new BookRepositorySpy();
        BookService bookService = new BookService(bookRepository);

        Book book1 = new Book("1234","Mockito In Action",500, now());
        Book book2 = new Book("1235","JUnit In Action",400, now());

        bookService.addBook(book1);
        bookService.addBook(book2);

        assertEquals(2,bookRepository.timesCalled());
        assertTrue(bookRepository.calledWith(book2));
    }

    @Test
    public void demoSpyWithMockito(){

        BookRepository bookRepositorySpy = spy(BookRepository.class);
        BookService bookService = new BookService(bookRepositorySpy);

        Book book1 = new Book("1234","Mockito In Action",500, now());
        Book book2 = new Book("1235","JUnit In Action",400, now());

        bookService.addBook(book1);
        bookService.addBook(book2);

        verify(bookRepositorySpy).save(book1);
        verify(bookRepositorySpy).save(book2);

    }
}
