package libreria;

import java.util.ArrayList;

public class LibraryController {

    public static void borrowBook() {
        String[] nameAndLastName = ConsoleReader.readNameAndLastName("");
        String clientName = nameAndLastName[0];
        String clientLastName = nameAndLastName[1];
        Client client = ClientRepository.getClientByName(clientName, clientLastName);

        if (client != null) {
            String isbn = ConsoleReader.readString("Ingrese el ISBN del libro: ");
            Book book = BookRepository.getBookByISBN(isbn);

            if (book != null && book.isAvailable()) {
                client.borrowBook(book);
                book.setAvailable(false);
                TransactionRepository.addTransaction(new Transaction("Prestado", client, book));
                System.out.println("Libro prestado.");
            } else {
                System.out.println("El libro no está disponible para prestamo.");
            }
        } else {
            System.out.println("Cliente no encontrado.");
        }
    }

    public static void returnBook() {
        String[] nameAndLastName = ConsoleReader.readNameAndLastName("");
        String clientName = nameAndLastName[0];
        String clientLastName = nameAndLastName[1];
        Client client = ClientRepository.getClientByName(clientName, clientLastName);

        if (client != null && !client.getBorrowedBooks().isEmpty()) {
            String isbn = ConsoleReader.readString("Ingrese el ISBN del libro : ");
            Book book = BookRepository.getBookByISBN(isbn);

            if (book != null && client.getBorrowedBooks().contains(book)) {
                client.returnBook(book);
                book.setAvailable(true);
                TransactionRepository.addTransaction(new Transaction("Return", client, book));
                System.out.println("Libro devuelto exitosamente.");
            } else {
                System.out.println("El cliente no tiene este libro prestado.");
            }
        } else {
            System.out.println("Cliente no encontrado o no tiene libros prestados.");
        }
    }

    public static void displayAllBooks() {
        ArrayList<Book> books = BookRepository.getAllBooks();
        if (books.isEmpty()) {
            System.out.println("No hay libros disponibles.");
        } else {
            System.out.printf("%-15s%-40s%-30s%-15s%n", "ISBN", "Título", "Autor", "Disponible");
            for (Book book : books) {
                System.out.printf("%-15s%-40s%-30s%-15s%n", book.getIsbn(), book.getTitle(),
                        getAuthorName(book.getAuthor()), book.isAvailable());
            }
        }
    }

    public static void displayAllClients() {
    ArrayList<Client> clients = ClientRepository.getAllClients();
    if (clients.isEmpty()) {
        System.out.println("No hay clientes registrados.");
    } else {
        System.out.printf("%-20s%-20s%-20s%n", "Nombre", "Apellido", "Libros Prestados");
        for (Client client : clients) {
            System.out.printf("%-20s%-20s%-20s%n", client.getProfile().getName(),
                    client.getProfile().getLastName(), client.getBorrowedBooks().size());
        }
    }
}


    public static void displayAllAuthors() {
        ArrayList<Author> authors = AuthorRepository.getAllAuthors();
        if (authors.isEmpty()) {
            System.out.println("No hay autores registrados.");
        } else {
            System.out.printf("%-20s%-20s%n", "Nombre", "Apellido");
            for (Author author : authors) {
                System.out.printf("%-20s%-20s%n", author.getProfile().getName(), author.getProfile().getLastName());
            }
        }
    }

    private static String getAuthorName(Author author) {
        if (author != null && author.getProfile() != null) {
            return author.getProfile().getName() + " " + author.getProfile().getLastName();
        } else {
            return "Autor Desconocido";
        }
    }

    public static void displayAllTransactions() {
        ArrayList<Transaction> transactions = TransactionRepository.getAllTransactions();
        if (transactions.isEmpty()) {
            System.out.println("No hay transacciones registradas.");
        } else {
            System.out.printf("%-20s%-40s%-20s%-20s%n", "Cliente", "Libro", "Tipo", "Fecha");
            for (Transaction transaction : transactions) {
                System.out.printf("%-20s%-40s%-20s%-20s%n",
                        getClientName(transaction.getClient()), getBookTitle(transaction.getBook()),
                        transaction.getType(), transaction.getDate());
            }
        }
    }

    private static String getBookTitle(Book book) {
        return (book != null) ? book.getTitle() : "Libro Desconocido";
    }

    private static String getClientName(Client client) {
        return (client != null && client.getProfile() != null)
                ? client.getProfile().getName() + " " + client.getProfile().getLastName()
                : "Cliente Desconocido";
    }

}
