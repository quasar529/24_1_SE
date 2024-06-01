import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BookTest {
    private Book book;

    @BeforeEach
    void setUp() {
        book = new Book("0", "Default", "Default", 0);
        book.clearBookCollection();
    }

    @Test
    void testAddBook() {
        System.out.println("도서 추가 테스트 시작");
        Book book1 = new Book("1", "자바 기초", "Jane", 2021);
        String add_result = book.addBook(book1);
        assertEquals("Book{id: '1', 제목: '자바 기초', 저자: 'Jane', 출판년도: 2021}도서가 추가되었습니다.", add_result);
        System.out.println(add_result);

        String add_result2 = book.addBook(book1);
        assertEquals("해당 ID(1) 는 이미 존재합니다.", book.addBook(book1));
        System.out.println(add_result2);

        
        System.out.println("도서 추가 테스트 통과");
    }

    @Test
    void testSearchBook() {
    	System.out.println("도서 검색 테스트 시작");

        Book book1 = new Book("1", "자바 기초", "Jane", 2021);
        System.out.println(book.addBook(book1));

        Book book2 = new Book("2", "소프트웨어 공학", "Tom", 2014);
        System.out.println(book.addBook(book2));

        Book book3 = new Book("3", "분산 컴퓨팅", "Yoon", 2024);
        System.out.println(book.addBook(book3));

        String search_result = book.searchBook("1");
        assertEquals("검색 결과:\nBook{id: '1', 제목: '자바 기초', 저자: 'Jane', 출판년도: 2021}", search_result);
        System.out.println(search_result);

        String search_result2 = book.searchBook("2");
        assertEquals("검색 결과:\nBook{id: '2', 제목: '소프트웨어 공학', 저자: 'Tom', 출판년도: 2014}", search_result2);
        System.out.println(search_result2);

        String search_result3 = book.searchBook("3");
        assertEquals("검색 결과:\nBook{id: '3', 제목: '분산 컴퓨팅', 저자: 'Yoon', 출판년도: 2024}", search_result3);
        System.out.println(search_result3);

        String search_result5 = book.searchBook("4");
        assertEquals("검색된 도서가 없습니다.", book.searchBook("4"));
        System.out.println(search_result5);

        System.out.println("도서 검색 테스트 통과");
    }

    @Test
    void testRemoveBook() {
    	System.out.println("도서 삭제 테스트 시작");
        Book book1 = new Book("1", "자바 기초", "Jane", 2021);
        String add_result = book.addBook(book1);
        System.out.println(add_result);

        Book book2 = new Book("2", "소프트웨어 공학", "Tom", 2014);
        String add_result2 = book.addBook(book2);
        System.out.println(add_result2);


        String remove_result = book.removeBook("1");
        assertEquals("Book{id: '1', 제목: '자바 기초', 저자: 'Jane', 출판년도: 2021}도서를 삭제하였습니다.", remove_result);
        System.out.println(remove_result);
        
        String remove_result2 = book.removeBook("1");
        assertEquals("해당 ID(1)의 도서를 찾을 수 없습니다.", book.removeBook("1"));
        System.out.println(remove_result2);
        
        System.out.println(book.searchBook(book1.getId()));
        System.out.println("도서 삭제 테스트 통과");

    }
}
