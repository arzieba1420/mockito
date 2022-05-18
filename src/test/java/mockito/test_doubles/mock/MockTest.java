package mockito.test_doubles.mock;


import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static java.time.LocalDate.now;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MockTest {

    @Test
    public void demoMock(){
        BookRepositoryMock bookRepository = new BookRepositoryMock();
        BookService bookService = new BookService(bookRepository);

       Book book1 = new Book("1234","Mockito In Action",500, now());
        Book book2 = new Book("1235","JUnit In Action",400, now());
        Book book3 = new Book("1236","Spring In Action",200, now());

        bookService.addBook(book1);
        bookService.addBook(book2);
        bookService.addBook(book3);

        bookRepository.verify(book3,2);
    }

    @Test
    public void demoMockWithMockito(){
        BookRepository bookRepository = Mockito.mock(BookRepository.class);
        BookService bookService = new BookService(bookRepository);

        Book book1 = new Book("1234","Mockito In Action",500, now());
        Book book2 = new Book("1235","JUnit In Action",400, now());
        Book book3 = new Book("1236","Spring In Action",200, now());

        bookService.addBook(book1);
        bookService.addBook(book2);
        bookService.addBook(book3);

        Mockito.verify(bookRepository,Mockito.times(2)).save(book3);
        Mockito.verify(bookRepository,Mockito.times(0)).save(book1);

    }
}
