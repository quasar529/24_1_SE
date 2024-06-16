import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class BookPerformanceTest {
    private Book book;
    private List<Book> largeBookCollection;

    @BeforeEach
    void setUp() {
        book = new Book("0", "Default", "Default", 0);
        book.clearBookCollection();
        largeBookCollection = new ArrayList<>();
        
        // Generate Books and Add to collection to search
        for (int i = 1; i <= 100000; i++) {
            largeBookCollection.add(new Book(String.valueOf(i), "Title" + i, "Author" + i, 2000 + (i % 20)));
        }
        
        for (Book b : largeBookCollection) {
            book.addBook(b);
        }
    }
    
    // searchBook Performance Measurement
    @Test
    void testSearchPerformance() {
        System.out.println("searchBook Performance Test Start");
        long startTime = System.nanoTime();
        String searchResult = book.searchBook("50000");
        String searchResult2 = book.searchBook("75000");
        long endTime = System.nanoTime();

        long duration = endTime - startTime;
        System.out.println("searchBook Duration: " + duration + " nano sec");

        assertEquals("검색 결과:\nBook{id: '50000', 제목: 'Title50000', 저자: 'Author50000', 출판년도: 2000}", searchResult);
        assertEquals("검색 결과:\nBook{id: '75000', 제목: 'Title75000', 저자: 'Author75000', 출판년도: 2000}", searchResult2);
        System.out.println("searchBook Performance Test Passed");
    }

    // search_bs Performance Measurement
    @Test
    void testBinarySearchPerformance() {
        System.out.println("search_bs Performance Test Start");

        long startTime = System.nanoTime();
        String searchResult = book.search_bs("50000");
        String searchResult2 = book.search_bs("75000");
        long endTime = System.nanoTime();

        long duration = endTime - startTime;
        System.out.println("search_bs Duration: " + duration + " nano sec");

        assertEquals("검색 결과:\nBook{id: '50000', 제목: 'Title50000', 저자: 'Author50000', 출판년도: 2000}", searchResult);
        assertEquals("검색 결과:\nBook{id: '75000', 제목: 'Title75000', 저자: 'Author75000', 출판년도: 2000}", searchResult2);
        System.out.println("search_bs Performance Test Passed");
    }
}
