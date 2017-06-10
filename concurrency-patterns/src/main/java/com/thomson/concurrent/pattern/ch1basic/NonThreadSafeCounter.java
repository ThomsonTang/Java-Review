package com.thomson.concurrent.pattern.ch1basic;

/**
 * 非线程安全的计数器
 *
 * @author Thomson Tang
 * @version Created: 10/06/2017.
 */
public class NonThreadSafeCounter {
    private int counter = 0;

    public void increment() {
        counter++;
    }

    public int get() {
        return counter;
    }
}
