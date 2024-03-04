
package libreria;
import java.util.ArrayList;

public class Author {
    private Profile profile;
    private ArrayList<Book> books;

    public Author(Profile profile) {
        this.profile = profile;
        this.books = new ArrayList<>();
    }

    public Profile getProfile() {
        return profile;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }
}



