package libreria;
import java.util.Date;

public class Book {
    private String isbn;
    private String title;
    private Author author;
    private Date publishDate;
    private boolean isAvailable;

    public Book(String isbn, String title, Author author, Date publishDate, boolean isAvailable) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.publishDate = publishDate;
        this.isAvailable = isAvailable;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public Author getAuthor() {
        return author;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}








