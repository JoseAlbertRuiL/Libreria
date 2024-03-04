package libreria;
import java.util.ArrayList;

public class AuthorRepository {
    private static ArrayList<Author> authors = new ArrayList<>();

    public static void addAuthor(Author author) {
        authors.add(author);
    }

    public static ArrayList<Author> getAllAuthors() {
        return new ArrayList<>(authors);
    }
}

