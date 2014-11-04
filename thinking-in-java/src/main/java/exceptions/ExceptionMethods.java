package exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Demonstrating the exception methods.
 *
 * @author Thomson Tang
 */
public class ExceptionMethods {
    private static final Logger logger = LoggerFactory.getLogger(ExceptionMethods.class);

    public static void main(String[] args) {
        try {
            throw new Exception("my exception");
        } catch (Exception e) {
            logger.error("Caught Exception");
            logger.error("getMessage(): {}", e.getMessage());
            logger.error("getLocalizedMessage(): {}", e.getLocalizedMessage());
            logger.error("toString():", e);
            logger.error("printStackTrace(): ");
            e.printStackTrace(System.out);
        }
    }
}
