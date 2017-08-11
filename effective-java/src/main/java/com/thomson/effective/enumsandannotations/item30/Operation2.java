package com.thomson.effective.enumsandannotations.item30;

/**
 * Enum type with constant-specific method implementations
 *
 * There is a better way to associate a different behavior with each enum constant:
 *  declare an abstract apply method in the enum type, and override it with a concrete method for each constant in a
 *  constant-specific class body. Such methods are knows as constant-specific method implementation.
 *
 * @author Thomson Tang
 * @version 1.0-SNAPSHOT
 * @version 8/23/13
 */
public enum Operation2 {
    PLUS {
        double apply(double x, double y) {
            return x + y;
        }
    },

    MINUS {
        double apply(double x, double y) {
            return x - y;
        }
    },

    TIMES {
        @Override
        double apply(double x, double y) {
            return x * y;
        }
    },

    DIVIDE {
        @Override
        double apply(double x, double y) {
            return x / y;
        }
    };

    abstract double apply(double x, double y);
}
