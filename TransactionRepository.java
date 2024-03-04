package libreria;
import java.util.ArrayList;

public class TransactionRepository {
    private static ArrayList<Transaction> transactions = new ArrayList<>();

    public static void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    public static ArrayList<Transaction> getAllTransactions() {
        return new ArrayList<>(transactions);
    }
}


