package com.thomson.jcip.ch8.threadpool.factory;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Logger;

/**
 * 定制Thread基类
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
    }
}
