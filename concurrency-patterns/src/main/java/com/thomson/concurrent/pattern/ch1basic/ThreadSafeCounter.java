package com.thomson.concurrent.pattern.ch1basic;

/**
 * 线程安全的计数器
 *
 * @author Thomson Tang
 * @version Created: 10/06/2017.
 */
public class ThreadSafeCounter {
    private int counter = 0;

    public void increment() {
        synchronized (this) {
            counter++;
        }
    }

    public int get() {
        synchronized (this) {
            return counter;
        }
    }
}
