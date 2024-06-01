import java.util.HashMap;
import java.util.Map;
import java.util.*;

public class Book {
	// Information of Book
    private String id;
    private String title;
    private String author;
    private int year;
    
    // Data Structure for arranging Book
    private static Map<String, Book> bookCollection = new HashMap<>();
    
    public Book(String id, String title, String author, int year) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.year = year;
    }
    
    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    public static String addBook(Book book) {
        if (bookCollection.containsKey(book.getId())) {
            return "해당 ID(" + book.getId() + ") 는 이미 존재합니다.";
        }
        bookCollection.put(book.getId(), book);
        return book + "도서가 추가되었습니다.";
    }
    
    public static String searchBook(String id) {
        Book book = bookCollection.get(id);
        if (book == null) {
            return "검색된 도서가 없습니다.";
        }
        return "검색 결과:\n" + book;
    }

    public static String removeBook(String id) {
        Book book = bookCollection.remove(id);
        if (book == null) {
            return "해당 ID(" + id + ")의 도서를 찾을 수 없습니다.";
        }
        return book + "도서를 삭제하였습니다.";
    }
    
    public static void clearBookCollection() {
        bookCollection.clear();
    }
    
    @Override
    public String toString() {
        return "Book{id: '" + id + "', 제목: '" + title + "', 저자: '" + author + "', 출판년도: " + year + "}";
    }
}