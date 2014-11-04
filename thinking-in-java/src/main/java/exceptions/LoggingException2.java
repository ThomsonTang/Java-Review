package exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * Logging caught exception.
 *
 * @author Thomson Tang
 */
public class LoggingException2 {
    private static final Logger logger = LoggerFactory.getLogger(LoggingException2.class);

    static void logException(Exception e) {
        StringWriter trace = new StringWriter();
        e.printStackTrace(new PrintWriter(trace));
        logger.error(trace.toString());
    }

    public static void main(String[] args) {
        try {
            throw new NullPointerException();
        } catch (NullPointerException e) {
            logException(e);
            logger.error("the exception message: {}", e);
        }
    }
}
