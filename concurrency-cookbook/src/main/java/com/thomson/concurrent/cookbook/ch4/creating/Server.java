package com.thomson.concurrent.cookbook.ch4.creating;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * This class will execute every task it receives using an executor.
 *
 * @author Thomson Tang
 * @version Created: 12/09/2017.
 */
public class Server {
    private static final Logger LOGGER = LoggerFactory.getLogger(Server.class);
    private ThreadPoolExecutor executor;

    public Server() {
        // 1. 默认使用的是自动扩缩容的线程池，这种线程池最大值为Integer.MAX_VALUE，最小值为0
//        executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
        // 2. 当有大量的耗时计算任务时，自动扩缩容的线程池可能会带来较差的性能，这时可以使用固定大小的线程池
        executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(5);
    }

    public void executeTask(ExecTask task) {
        LOGGER.info("Server: A new task has arrived.");
        executor.execute(task);
        LOGGER.info("Server: Pool Size: {}.", executor.getPoolSize());
        LOGGER.info("Server: Active Count: {}", executor.getActiveCount());
        LOGGER.info("Server: Completed Tasks: {}", executor.getCompletedTaskCount());
    }

    public void endServer() {
        executor.shutdown();
    }
}
