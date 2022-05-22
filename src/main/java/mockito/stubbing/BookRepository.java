package mockito.stubbing;


import java.util.List;

public interface BookRepository {

    List<Book> findNewBooks(int days);
    Book findBookByBookId(String id);

    void save(Book book);
}
