package com.thomson.jcip.ch8.threadpool;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 使用Semaphore来控制任务的提交速率
 *
 * @author Thomson Tang
 * @version Created: 06/09/2017.
 */
public class BoundedExecutor {
    private static final Logger LOGGER = LoggerFactory.getLogger(BoundedExecutor.class);
    private final Executor executor;
    private final Semaphore semaphore;

    public BoundedExecutor(Executor executor, int bound) {
        this.executor = executor;
        this.semaphore = new Semaphore(bound);
    }

    public void submitTask(final Runnable command) throws InterruptedException {
        semaphore.acquire();
        try {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        command.run();
                    } finally {
                        semaphore.release();
                    }
                }
            });
        } catch (RejectedExecutionException e) {
            semaphore.release();
        }
    }

    public static void main(String[] args) {
        int threads = 2;
        int capacity = 5;
        ThreadPoolExecutor executor = new ThreadPoolExecutor(threads, threads, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>(capacity));
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());

        BoundedExecutor boundedExecutor = new BoundedExecutor(executor, 5);
        // 模拟任务的执行过程
        try {
            for (int i = 0; i < 5; i++) {
                boundedExecutor.submitTask(new Task("task" + i));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        LOGGER.info("Main: finished.");
    }
}
