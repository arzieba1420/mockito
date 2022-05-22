package mockito.annotations_support;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AnnotationsTest {

    @InjectMocks
    private BookService bookService;
    @Mock
    private BookRepository bookRepositoryMock;

    @Test
    public void demoCreateMocksUsingAnnotations(){
        Book book1 = new Book("1234","Mockito in action",500, LocalDate.now());
        Book book2 = new Book("1235","JUnit 5 in action",400, LocalDate.now());
        List<Book> books = new ArrayList<>();

        books.add(book1);
        books.add(book2);

        when(bookRepositoryMock.findNewBooks(7)).thenReturn(books);

        List<Book> newBooksWithAppliedDiscount = bookService.getNewBooksWithAppliedDiscount(10, 7);

        assertEquals(2,newBooksWithAppliedDiscount.size());
        assertEquals(450,newBooksWithAppliedDiscount.get(0).getPrice());
        assertEquals(360,newBooksWithAppliedDiscount.get(1).getPrice());
    }

    @Test
    public void sort(){

        int [] unsorted = {4,34,1,55,23,12,7,2,18};
        int [] sorted = new int[9];

        sorted[0] = unsorted[0];

        for (int i = 1;i<unsorted.length;i++){
            int iter = i-1;
            int chosen = unsorted[i];
            while (iter>=0){
                if (chosen<unsorted[iter]){
                    unsorted[iter+1] = unsorted[iter];
                    unsorted[iter] = chosen;
                }
                iter--;

            }
        }
        System.out.println();
        assertArrayEquals(new int[]{1,2,4,7,12,18,23,34,55},unsorted);

    }
}
