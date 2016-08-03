package effective.enumsandannotations.item34;

import java.util.Arrays;
import java.util.Collection;

/**
 * In summary, while you cannot write an extensible enum type, you can emulate it by writing an interface to go with
 * a basic enum type that implements the interface.
 *
 * @author Thomson Tang
 * @version 1.0-SNAPSHOT
 * @version 8/30/13
 */
public enum ExtendedOperation implements Operation {
    EXP("^") {
        public double apply(double x, double y) {
            return Math.pow(x, y);
        }
    },
    REMINDER("%") {
        public double apply(double x, double y) {
            return x % y;
        }
    };

    private final String symbol;

    ExtendedOperation(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return symbol;
    }

    public static void main(String[] args) {
        double d1 = 3.0;
        double d2 = 2.0;

        test(ExtendedOperation.class, d1, d2);
        test2(Arrays.asList(ExtendedOperation.values()), d1, d2);
    }

    // Use bounded type token
    public static <T extends Enum<T> & Operation> void test(Class<T> opSet, double x, double y) {
        for (Operation operation : opSet.getEnumConstants())
            System.out.printf("%f %s %f = %f%n", x, operation, y, operation.apply(x, y));
    }

    // Use Collection<? extends Operation>, which is a bounded wildcard type
    public static void test2(Collection<? extends Operation> operations, double x, double y) {
        for (Operation operation : operations) {
            System.out.printf("%f %s %f = %f%n", x, operation, y, operation.apply(x, y));
        }
    }
}
