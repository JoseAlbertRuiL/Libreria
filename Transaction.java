package libreria;

import java.util.Date;
import java.util.UUID;

public class Transaction {
    private String id;
    private String type;
    private Client client;
    private Book book;
    private Date date;

    public Transaction(String type, Client client, Book book) {
        this.id = UUID.randomUUID().toString();
        this.type = type;
        this.client = client;
        this.book = book;
        this.date = new Date();
    }

    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public Client getClient() {
        return client;
    }

    public Book getBook() {
        return book;
    }

    public Date getDate() {
        return date;
    }
}




