package effective.enumsandannotations.item30;

import java.util.HashMap;
import java.util.Map;

/**
 * Enum type with constant-specific class bodies and data.
 *
 *  Constant-specific method implementations can be combined with constant-specific data.
 *
 * @author Thomson Tang
 * @version 1.0-SNAPSHOT
 * @version 8/23/13
 */
public enum Operation3 {
    PLUS("+") {
        @Override
        double apply(double x, double y) {
            return x + y;
        }
    },

    MINUS("-") {
        @Override
        double apply(double x, double y) {
            return x - y;
        }
    },

    TIMES("*") {
        @Override
        double apply(double x, double y) {
            return x * y;
        }
    },

    DIVIDE("/") {
        @Override
        double apply(double x, double y) {
            return x / y;
        }
    };

    private final String symbol;

    Operation3(String symbol) {
        this.symbol = symbol;
    }

    //In some cases, overriding toString in an enum is very useful.
    @Override
    public String toString() {
        return symbol;
    }

    abstract double apply(double x, double y);

    private static final Map<String, Operation3> stringToEnum = new HashMap<String, Operation3>();

    // Initialize map from constant name to enum constant
    static {
        for (Operation3 op : values()) {
            stringToEnum.put(op.toString(), op);
        }
    }

    public static Operation3 fromString(String symbol) {
        return stringToEnum.get(symbol);
    }

    public static void main(String[] args) {
        double x = 2;
        double y = 4;
        for (Operation3 op : Operation3.values()) {
           System.out.printf("%f %s %f = %f%n", x, op, y, op.apply(x, y));
        }
    }
}
