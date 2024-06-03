import java.util.*;

public class Book {
	// Information of Book
    private String id;
    private String title;
    private String author;
    private int year;
    
    // Data Structure for arranging Book
    private static Map<String, Book> bookCollection = new HashMap<>();
    private static List<Book> sortedBookList = new ArrayList<>();
    
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

    // Add Book
    public static String addBook(Book book) {
        if (bookCollection.containsKey(book.getId())) {
            return "해당 ID(" + book.getId() + ") 는 이미 존재합니다.";
        }
        bookCollection.put(book.getId(), book);
        sortedBookList.add(book);
        return book + "도서가 추가되었습니다.";
    }
    
    // Search Book by id in HashMap
    public static String searchBook(String id) {
        Book book = bookCollection.get(id);
        if (book == null) {
            return "검색된 도서가 없습니다.";
        }
        return "검색 결과:\n" + book;
    }

    // Remove book by ID
    public static String removeBook(String id) {
        Book book = bookCollection.remove(id);
        sortedBookList.remove(book);
        
        if (book == null) {
            return "해당 ID(" + id + ")의 도서를 찾을 수 없습니다.";
        }
        return book + "도서를 삭제하였습니다.";
    }
    
    // Clear Every Book
    public static void clearBookCollection() {
        bookCollection.clear();
        sortedBookList.clear();
    }
    
    // Binary Search
    public static String search_bs(String id) {
        int left = 0;
        int right = sortedBookList.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            Book midBook = sortedBookList.get(mid);
            int cmp = midBook.getId().compareTo(id);

            if (cmp == 0) {
                return "검색 결과:\n" + midBook;
            } else if (cmp < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return "검색된 도서가 없습니다.";
    }
    
    @Override
    public String toString() {
        return "Book{id: '" + id + "', 제목: '" + title + "', 저자: '" + author + "', 출판년도: " + year + "}";
    }
}