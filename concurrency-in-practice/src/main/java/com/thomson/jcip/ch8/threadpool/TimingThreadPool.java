package com.thomson.jcip.ch8.threadpool;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 类说明
 *
 * @author Thomson Tang
 * @version Created: 08/09/2017.
 */
public class TimingThreadPool extends ThreadPoolExecutor {
    private final Logger LOGGER = LoggerFactory.getLogger(TimingThreadPool.class);
    private final ThreadLocal<Long> startTime = new ThreadLocal<>();
    private final AtomicLong numTasks = new AtomicLong();
    private final AtomicLong totalTime = new AtomicLong();

    public TimingThreadPool(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }

    @Override
    protected void beforeExecute(Thread thread, Runnable runnable) {
        super.beforeExecute(thread, runnable);
        LOGGER.info("Thread {}: start {}", thread, runnable);
        startTime.set(System.nanoTime());
    }

    @Override
    protected void afterExecute(Runnable r, Throwable t) {
        try {
            long endTime = System.nanoTime();
            long taskTime = endTime - startTime.get();
            numTasks.incrementAndGet();
            totalTime.addAndGet(taskTime);
            LOGGER.info("Thread {}: end {}, time={}", t, r, taskTime);
        } finally {
            super.afterExecute(r, t);
        }
    }

    @Override
    protected void terminated() {
        try {
            LOGGER.info("Terminated: avg time={}", totalTime.get() / numTasks.get());
        } finally {
            super.terminated();
        }
    }
}
