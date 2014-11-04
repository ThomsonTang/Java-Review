package exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Intellij idea.
 *
 * @author Thomson Tang
 */
public class Switch {
    private static final Logger logger = LoggerFactory.getLogger(Switch.class);
    private boolean state = false;

    public boolean read() {
        return state;
    }

    public void on() {
        state = true;
        logger.info("{}", this);
    }

    public void off() {
        state = false;
        logger.info("{}", this);
    }

    public String toString() {
        return state ? "on" : "off";
    }
}
