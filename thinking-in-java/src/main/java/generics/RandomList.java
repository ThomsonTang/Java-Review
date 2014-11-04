package generics;

import java.util.ArrayList;
import java.util.Random;

/**
 * A RandomList generates random items.
 *
 * @author Thomson Tang
 */
public class RandomList<T> {
    private ArrayList<T> storage = new ArrayList<>();
    private Random random = new Random(47);

    public void add(T item) {
        storage.add(item);
    }

    public T select() {
        return storage.get(random.nextInt(storage.size()));
    }

    public static void main(String[] args) {
        RandomList<String> randomList = new RandomList<>();
        for (String s : "this is a test!".split(" ")) {
            randomList.add(s);
        }

        for (int i = 0; i < 11; i++) {
            System.out.println(randomList.select() + " ");
        }
    }
}
