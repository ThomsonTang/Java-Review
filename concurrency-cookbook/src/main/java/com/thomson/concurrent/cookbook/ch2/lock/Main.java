package com.thomson.concurrent.cookbook.ch2.lock;

import java.util.concurrent.locks.Lock;

/**
 * <h2>Synchronizing a block of code with a Lock</h2>
 *
 * <p>When we want to implement a critical section using locks and guarantee that only one execution thread runs a
 * block of code, we have to create a {@link java.util.concurrent.locks.ReentrantLock} object. At the beginning of the
 * critical section, we have to get the control of the lock using the {@link Lock#lock()} method. At the end of the
 * critical section, we have to use the {@link Lock#unlock()} method to free the control of the lock and allow the
 * other threads to run this critical section.</p>
 *
 * @author Thomson Tang
 * @version Created ：2016-8/26/16-16:19
 * @see PrintQueue
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        int threadCount = 10;
        PrintQueue printQueue = new PrintQueue();
        Thread jobs[] = new Thread[threadCount];

        for (int i = 0; i < threadCount; i++) {
            jobs[i] = new Thread(new Job(printQueue), "Thread-" + i);
        }

        for (int i = 0; i < threadCount; i++) {
            jobs[i].start();
        }
    }
}
