/**************************************************************************
 * Compilation: javac In.java
 * Execution:   java In
 *
 * Reads in data of various types from standard input, file, url and so on.
 *
 **************************************************************************/
package standardlib;

import java.util.Locale;
import java.util.Scanner;

/**
 * <i>Input</i>. This class provides methods for reading strings and numbers
 * from standard input, file input, URL and socket.
 * <p>
 *     The locale used is: language = English, country = US. This is consistent
 *     with the formatting conventions with Java floating-point literals,
 *     command-line arguments and standard output. It ensures that standard
 *     input works the numbers formatting used in the textbook.
 * </p>
 *
 * @author Thomson Tang
 * @since 1.0-SNAPSHOT
 */
public final class In {
    private Scanner scanner;

    private String charsetName = "UTF-8";

    private Locale usLocale = new Locale("en", "US");
}
