package com.thomson.concurrent.cookbook.ch1.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * We define an own <i>thread group</i> class which extend the {@link ThreadGroup}. We have to
 * declare a constructor with one parameter and override the {@code uncaughtException} method which
 * will write in the console information about the exception.
 *
 * @author Thomson Tang
 * @version Created ：2016-7/2/16-17:18
 * @see ThreadGroup
 */
public class MyThreadGroup extends ThreadGroup {
    private static final Logger logger = LoggerFactory.getLogger(MyThreadGroup.class);

    public MyThreadGroup(String name) {
        super(name);
    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        logger.info("The thread {} has thrown  an exception.", t.getId());
        logger.error("the error: {}", e);
        logger.info("Terminating the rest of the Threads.");
        interrupt();
    }
}
