package generics;

/**
 * A Counted Object.
 *
 * @author Thomson Tang
 */
public class CountedObject {
    private static long counter = 0;
    private final long id = counter++;

    public long id() {
        return id;
    }

    public String toString() {
        return String.format("CountedObject %s", id);
    }
}
