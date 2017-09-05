package com.thomson.jcip.ch8.threadpool;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程饥饿死锁
 *
 * @author Thomson Tang
 * @version Created: 05/09/2017.
 */
public class ThreadDeadLock {
    ExecutorService executor = Executors.newSingleThreadExecutor();

    public class RenderPageTask implements Callable<String> {

        @Override
        public String call() throws Exception {
            return null;
        }
    }
}
