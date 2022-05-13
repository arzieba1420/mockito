package mockito.test_doubles.fake;

import org.junit.jupiter.api.*;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class FakeTest {

    @Test
    public void testFake(){

        BookRepository bookRepository = new FakeBookRepository();
        BookService bookService = new BookService(bookRepository);

        bookService.addBook(new Book("1234","Mockito in action",250, LocalDate.now()));
        bookService.addBook(new Book("1235","JUnit 5 in action",200, LocalDate.now()));
        assertEquals(2,bookService.findNumbersOfBooks());
    }


}
