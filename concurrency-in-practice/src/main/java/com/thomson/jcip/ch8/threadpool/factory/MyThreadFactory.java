package com.thomson.jcip.ch8.threadpool.factory;

import java.util.concurrent.ThreadFactory;

/**
 * 自定义线程工厂
 *
 * @author Thomson Tang
 * @version Created: 08/09/2017.
 */
public class MyThreadFactory implements ThreadFactory {
    private final String poolName;

    public MyThreadFactory(String poolName) {
        this.poolName = poolName;
    }

    @Override
    public Thread newThread(Runnable runnable) {
        return new MyAppThread(runnable, poolName);
    }
}
