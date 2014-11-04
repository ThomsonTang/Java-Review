package exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Intellij idea.
 *
 * @author Thomson Tang
 */
public class OnOffSwitch {
    private static final Logger logger = LoggerFactory.getLogger(OnOffSwitch.class);
    private static Switch sw = new Switch();

    public static void f() throws OnOffException1, OnOffException2 {

    }

    public static void main(String[] args) {
        try {
            sw.on();
            f();
            sw.off();
        } catch (OnOffException1 onOffException1) {
            logger.error("OnOffException1");
            sw.off();
        } catch (OnOffException2 onOffException2) {
            logger.error("OnOffException2");
            sw.off();
        }
    }
}
