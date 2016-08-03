package annotations;

/**
 * This class provides a public method which can become part of
 * useful interface.
 *
 * APT-based annotation processing.
 *
 * @author Thomson Tang
 * @version 1.0-SNAPSHOT
 * @version 9/4/13
 */
@ExtractInterface("IMultiplier") // given the name of the interface to create.
public class Multiplier {
    public int multiply(int x, int y) {
        int total = 0;
        for (int i = 0; i < x; i++) {
            total = add(total, y);
        }
        return total;
    }

    //this method is not public, so it is not part of the interface.
    private int add(int x, int y) {
        return x + y;
    }

    public static void main(String[] args) {
        Multiplier m = new Multiplier();
        System.out.println("11 * 6 = " + m.multiply(11, 16));
    }
}
