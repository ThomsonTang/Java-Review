package exceptions;

/**
 * Rethrow a different object from the one that was caught.
 *
 * @author Thomson Tang
 */

class OneException extends Exception {
    public OneException(String s) {
        super(s);
    }
}


class TwoException extends Exception {
    public TwoException(String s) {
        super(s);
    }
}


public class RethrowNew {
    public static void f() throws OneException {
        System.out.println("Originating the exception in f()");
        throw new OneException("throw from f()");
    }

    public static void main(String[] args) {
        try {
            try {
                f();
            } catch (OneException e) {
                System.out.println("Caught in inner try,  e.printStackTrace(): ");
                e.printStackTrace(System.out);
                throw new TwoException("from inner try");
            }
        } catch (TwoException e) {
            System.out.println("Caught in outer try,  e.printStackTrace(): ");
            e.printStackTrace(System.out);
        }
    }
}
