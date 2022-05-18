package mockito.test_doubles.mock;


import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.*;

public class BookRepositoryMock implements BookRepository {

    int saveCalled = 0;
    Book lastAddedBook = null;

    @Override
    public void save(Book book) {
        saveCalled++;
        lastAddedBook = book;
    }

    @Override
    public void delete(Book book) {

    }

    public void verify(Book book, int times){
        assertEquals(times,saveCalled);
        assertEquals(book,lastAddedBook);
    }

}
