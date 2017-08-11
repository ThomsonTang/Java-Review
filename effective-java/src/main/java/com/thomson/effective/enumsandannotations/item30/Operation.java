package com.thomson.effective.enumsandannotations.item30;

/**
 * Enum type that switches on its own value - questionable.
 *  1. it won't compile without the throw statement because the end of the method is technically reachable, even though
 *     it will never be reachable.
 *  2. the code is fragile. If you add a new enum constant but forget to add a corresponding case to the switch, the
 *     enum will still compile, but it will fail at runtime when you try to apply the new operation.
 *
 * @author Thomson Tang
 * @version 1.0-SNAPSHOT
 * @version 8/23/13
 */
public enum Operation {
    PLUS, MINUS, TIMES, DIVIDE;

    double apply(double x, double y) {
        switch (this) {
            case PLUS: return x + y;
            case MINUS: return x - y;
            case TIMES: return x * y;
            case DIVIDE: return x / y;
        }

        throw new AssertionError("unknow op:" + this);
    }

    //Switch on an enum to simulate a missing method
    //Switch on enums are good for augmenting external enum types with constant-specific behavior.
    public static Operation inverse(Operation op) {
        switch (op) {
            case PLUS: return Operation.MINUS;
            case MINUS: return Operation.PLUS;
            case TIMES: return Operation.DIVIDE;
            case DIVIDE: return Operation.TIMES;
            default: throw new AssertionError("unknow op: " + op);
        }
    }
}
