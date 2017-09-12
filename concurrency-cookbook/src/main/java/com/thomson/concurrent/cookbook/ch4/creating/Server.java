package com.thomson.concurrent.cookbook.ch4.creating;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
        executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
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
