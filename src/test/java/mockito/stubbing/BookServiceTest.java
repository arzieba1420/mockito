package mockito.stubbing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {

    @Mock
    private BookRepository bookRepositoryMock;
    @InjectMocks
    private BookService bookService;

    @Test
    public void testCalculateTotalCostOfBooks(){
        List<String> bookIds = new ArrayList<>();
        bookIds.add("1234");
        bookIds.add("1234");
        Book book1 = new Book("1234","Mockito in action",500, LocalDate.now());
        Book book2 = new Book("1235","JUnit 5 in action",400, LocalDate.now());

        //stubbing methods in mockito, multiple calling the same method with the same arguments----------------------

        when(bookRepositoryMock.findBookByBookId("1234"))
                .thenReturn(book1)
                .thenReturn(book2);
        /*when(bookRepositoryMock.findBookByBookId("1235")).thenReturn(book2);*/

        /*doReturn(book1).when(bookRepositoryMock).findBookByBookId("1234");
        doReturn(book2).when(bookRepositoryMock).findBookByBookId("1235");*/

        int actualCost = bookService.calculateTotalCost(bookIds);

        ArgumentCaptor<String> id = ArgumentCaptor.forClass(String.class);

        assertEquals(900,actualCost);
        verify(bookRepositoryMock,times(2)).findBookByBookId(id.capture());
    }

    //testing save void methods------------------------------------------------------------------------------------------

    @Test
    public void voidMethodsTest(){
        Book book1 = new Book(null,"Mockito in action",500, LocalDate.now());

        doNothing().when(bookRepositoryMock).save(book1);
        bookService.addBook(book1);
        assertNotEquals(book1,new Book(null,"Mockito in action",500, LocalDate.now()));

    }

    //problem with using equals() method by Mockito
    //need to override equals method!!!
    @Test
    public void voidMethodsTestWithBookRequest(){

        BookRequest bookRequest = new BookRequest("Mockito in action",500, LocalDate.now());
        Book book = new Book(null,"Mockito in action",500, LocalDate.now());

        doNothing().when(bookRepositoryMock).save(book);
        bookService.addBook(bookRequest);

    }

}
