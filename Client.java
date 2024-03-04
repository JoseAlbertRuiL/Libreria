
package libreria;
import java.util.ArrayList;

public class Client {
    private Profile profile;
    private ArrayList<Book> borrowedBooks;

    public Client(Profile profile) {
        this.profile = profile;
        this.borrowedBooks = new ArrayList<>();
    }

    public Profile getProfile() {
        return profile;
    }

    public ArrayList<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void borrowBook(Book book) {
        borrowedBooks.add(book);
    }

    public void returnBook(Book book) {
        borrowedBooks.remove(book);
    }
}





