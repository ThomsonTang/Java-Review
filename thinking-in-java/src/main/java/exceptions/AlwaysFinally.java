package exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Finally ia always executed.
 *
 * @author Thomson Tang
 */

class FourException extends Exception {
}


public class AlwaysFinally {
    private static final Logger logger = LoggerFactory.getLogger(AlwaysFinally.class);

    public static void main(String[] args) {
        logger.info("Enter first try block.");
        try {
            logger.info("Enter second try block.");
            try {
                throw new FourException();
            } finally {
                logger.info("finally in 2nd try block.");
            }
        } catch (FourException e) {
            logger.error("Caught FourException in 1st try block.");
        } finally {
            logger.info("finally in 1st try block.");
        }
    }
}
