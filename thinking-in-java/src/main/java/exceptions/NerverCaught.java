package exceptions;

/**
 * Ignoring RuntimeExceptions.
 *  {ThrowsException}
 *
 * @author Thomson Tang
 */
public class NerverCaught {
    static void f() {
        throw new RuntimeException("From f()");
    }

    static void g() {
        f();
    }

    public static void main(String[] args) {
        g();
    }
}
