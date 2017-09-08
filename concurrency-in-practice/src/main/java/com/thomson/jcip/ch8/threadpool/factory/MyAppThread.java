package com.thomson.jcip.ch8.threadpool.factory;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 定制Thread基类
 *
 * 可以给线程定制一些行为。包括：为线程指定名字，设置自定义UncaughtExceptionHandler向Logger中写入信息，
 * 维护一些统计信息，例如有多少个线程被创建和销毁，以及在线程被创建和终止时把调试信息写入日志。
 *
 * @author Thomson Tang
 * @version Created: 08/09/2017.
 */
public class MyAppThread extends Thread {
    private static final String DEFAULT_NAME = "MyAppThread";
    private static volatile boolean debugLifecycle = false;
    private static final AtomicInteger created = new AtomicInteger();
    private static final AtomicInteger alive = new AtomicInteger();
    private static final Logger log = Logger.getAnonymousLogger();

    public MyAppThread(Runnable runnable, String poolName) {
        super(runnable, poolName + "-" + created.incrementAndGet());
        setUncaughtExceptionHandler(
                new Thread.UncaughtExceptionHandler() {
                    @Override
                    public void uncaughtException(Thread t, Throwable e) {
                        log.log(Level.SEVERE, "UNCAUGHT in thread " + t.getName(), e);
                    }
                }
        );
    }

    @Override
    public void run() {
        //复制debug标识以确保一致的值
        boolean debug = debugLifecycle;
        if (debug) {
            log.log(Level.FINE, "Created " + getName());
        }
        try {
            alive.incrementAndGet();
            super.run();
        } finally {
            alive.decrementAndGet();
            if (debug) {
                log.log(Level.FINE, "Exiting " + getName());
            }
        }
    }

    public static int getThreadsCreated() {
        return created.get();
    }

    public static int getThreadsAlive() {
        return alive.get();
    }

    public static boolean getDebug() {
        return debugLifecycle;
    }

    public static void setDebug(boolean b) {
        debugLifecycle = b;
    }
}
