package concurrent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

/**
 * The main class to test the executor.
 *
 * @author Thomson Tang
 * @version Created ：2016-03/11/2016-14:17
 */
public class AsyncTaskExecutorMain {
    private static final Logger logger = LoggerFactory.getLogger(AsyncTaskExecutorMain.class);

    public static void main(String[] args) {
        logger.info("start to execute the main method...");
        logger.info("to invoke async method...");
        AsyncTaskExecutor taskExecutor = AsyncTaskExecutor.INSTANCE;
        //启动5个线程
        for (int i = 0; i < 5; i++) {
            taskExecutor.asyncExecute("spurs");
        }
        try {
            for (int i = 0; i < 20; i++) {
                logger.info("{}: main doing...", i);
                TimeUnit.SECONDS.sleep(1);
            }
        } catch (Exception e) {
            logger.error("error occurred.", e);
        }
        logger.info("main end.");
    }
}
