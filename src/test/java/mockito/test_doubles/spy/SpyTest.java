package mockito.test_doubles.spy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static java.time.LocalDate.now;
import static org.junit.jupiter.api.Assertions.*;

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
}
