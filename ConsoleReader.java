package libreria;
import java.util.Scanner;

public class ConsoleReader {
    private static Scanner scanner = new Scanner(System.in);

    public static String readString(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    public static int readInt(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextInt()) {
            System.out.print("Por favor, ingrese un número válido: ");
            scanner.next();
        }
        return scanner.nextInt();
    }

  
    public static String[] readNameAndLastName(String prompt) {
        System.out.print(prompt);
        String[] nameAndLastName = scanner.nextLine().split("\\s+");
        if (nameAndLastName.length != 2) {
            System.out.println("Ingrese el nombre y el apellido por separado.");
            return readNameAndLastName(prompt);
        }
        return nameAndLastName;
    }
}



