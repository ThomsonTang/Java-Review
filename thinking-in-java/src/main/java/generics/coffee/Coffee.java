package generics.coffee;

/**
 * The Coffee class.
 *
 * @author Thomson Tang
 */
public class Coffee {
    private static long counter = 0;
    private final long id = counter++;

    public String toString() {
        return String.format("%s %s", getClass().getSimpleName(), id);
    }
}
