package libreria;

public class LibraryManagementSystem {

    public static void run() {
        int opcion;
        do {
            displayMainMenu();
            opcion= ConsoleReader.readInt("Seleccione una opcion: ");

            switch (opcion) {
                case 1 ->
                    LibraryController.borrowBook();
                case 2 ->
                    LibraryController.returnBook();
                case 3 ->
                    LibraryController.displayAllBooks();
                case 4 ->
                    LibraryController.displayAllAuthors();
                case 5 ->
                    LibraryController.displayAllClients();
                case 6 ->
                    LibraryController.displayAllTransactions();
                case 7 ->
                    System.out.println("Saliendo del programa");
                default ->
                    System.out.println("Opcion no valida");
            }
        } while (opcion != 7);
    }



    public static void displayMainMenu() {
        System.out.println("1. Prestar libro");
        System.out.println("2. Devolver libro");
        System.out.println("3. Mostrar libros");
        System.out.println("4. Mostrar autores");
        System.out.println("5. Mostrar clientes");
         System.out.println("6. Mostrar movimientos");
        System.out.println("7. Salir");
    }
}
