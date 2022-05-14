package mockito.test_doubles.stub;

import java.util.ArrayList;
import java.util.List;

import static java.time.LocalDate.now;

public class BookRepositoryStub implements BookRepository {
    @Override
    public List<Book> findNewBooks(int days) {
        List<Book> newBooks = new ArrayList<>();
        Book book1 = new Book("1234","Mockito In Action",500, now());
        Book book2 = new Book("1235","JUnit In Action",400, now());

        newBooks.add(book1);
        newBooks.add(book2);

        return newBooks;
    }
}
