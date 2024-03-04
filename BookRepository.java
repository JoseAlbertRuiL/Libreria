
package libreria;

import java.util.ArrayList;

public class BookRepository {
    private static ArrayList<Book> books = new ArrayList<>();

    public static void addBook(Book book) {
        books.add(book);
    }

    public static Book getBookByISBN(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                return book;
            }
        }
        return null;
    }

    public static ArrayList<Book> getAllBooks() {
        return new ArrayList<>(books);
    }
}
