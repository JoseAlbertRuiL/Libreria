
package libreria;
import java.util.ArrayList;

public class Repository<T> {
    private ArrayList<T> items;

    public Repository() {
        this.items = new ArrayList<>();
    }

    public void addItem(T item) {
        items.add(item);
    }

    public ArrayList<T> getAllItems() {
        return new ArrayList<>(items);
    }
}

