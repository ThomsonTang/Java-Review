package threadExecutors.multipleTaskAndAllResults;

import com.google.common.collect.Lists;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * 类说明
 *
 * @author Thomson Tang
 * @version Created ：2016-8/24/16-11:06
 */
public class MultipleTasksTest {
    private static final Logger logger = LoggerFactory.getLogger(MultipleTasksTest.class);

    private ExecutorService taskPool;
    private CountDownLatch countDownLatch;

    @Before
    public void prepare() {
        taskPool = Executors.newFixedThreadPool(10);
        countDownLatch = new CountDownLatch(3);
        logger.info("the task pool init success...");
    }

    @Test
    public void testUseForLoop() {
        long start = System.currentTimeMillis();
        List<Future<Result>> futures = Lists.newArrayList();
        for (int i = 0; i < 3; i++) {
            Future<Result> future = taskPool.submit(new Task(i + "", countDownLatch));
            logger.info("submit the task " + i + " success.");
            futures.add(future);
        }

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            logger.error(e.getMessage(), e);
        }

        logger.info("Before Futures -> show the results:");
        for (Future<Result> future : futures) {
            try {
                logger.info("Before Future.get() -> show the results:");
                Result result = future.get(2, TimeUnit.SECONDS);
                logger.info("After Future.get() -> {}: {}", result.getName(), result.getValue());
            } catch (InterruptedException | ExecutionException | TimeoutException e) {
                logger.error(e.getMessage(), e);
            }
        }
        logger.info("After Futures -> OK.[{}]", System.currentTimeMillis() - start);
    }

    @Test
    public void testTheErrorInForLoop() {
        List<Result> results = Lists.newArrayList();
        try {
            for (int i = 0; i < 3; i++) {
                Future<Result> future = taskPool.submit(new Task(i + "", countDownLatch));
                logger.info("submit the task " + i + " success.");
                results.add(future.get());
            }
        } catch (InterruptedException | ExecutionException e) {
            logger.error(e.getMessage(), e);
        }

        for (Result result : results) {
            logger.info("the result: [{}: {}]", result.getName(), result.getValue());
        }
    }
}
