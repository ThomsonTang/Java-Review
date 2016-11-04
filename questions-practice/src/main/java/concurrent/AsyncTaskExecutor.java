package concurrent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 异步调用方法实例
 *
 * @author Thomson Tang
 * @version Created ：2016-03/11/2016-11:12
 */
public class AsyncTaskExecutor {
    private static final Logger logger = LoggerFactory.getLogger(AsyncTaskExecutor.class);
    private static ExecutorService taskPool = Executors.newCachedThreadPool(); //create a cached thread pool

    public static final AsyncTaskExecutor INSTANCE = new AsyncTaskExecutor();

    private AsyncTaskExecutor() {
    }

    /**
     * 异步调用
     *
     * @param name 如果是JDK是7或者以前的版本，需要申明该参数为{@code final}的。JDK8中则可以不需要
     */
    public void asyncExecute(final String name) {
        taskPool.submit(new Runnable() {
            @Override
            public void run() {
                doSomething(name);
            }
        });
    }

    public void doSomething(String name) {
        logger.info("start doing something......");
        try {
            for (int i = 0; i < 5; i++) {
                logger.info("{}-{}: working...", name, i);
                TimeUnit.SECONDS.sleep(5);
            }
        } catch (InterruptedException e) {
            logger.error("error occurred: ", e);
            e.printStackTrace();
        }
        logger.info("...end");
    }
}
