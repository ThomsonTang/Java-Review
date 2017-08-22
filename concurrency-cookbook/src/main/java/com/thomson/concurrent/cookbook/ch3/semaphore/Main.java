package com.thomson.concurrent.cookbook.ch3.semaphore;

import java.util.concurrent.Semaphore;

/**
 * <h2>Controlling concurrent access to a resource</h2>
 *
 * The scene class to test.
 *
 * How it works:
 *
 * The key is in {@link PrintQueue#printJob(Object)} that shows the three steps you must follow when you use a
 * semaphore to implement a critical section, and protect the access to shared resources:
 *
 * <ul>
 * <li>First, acquire the semaphore the {@link Semaphore#acquire()} method.</li>
 * <li>Then, do the necessary operations with the shared resources.</li>
 * <li>Finally, release the semaphore with the {@link Semaphore#release()} method.</li>
 * </ul>
 *
 * @author Thomson Tang
 * @version Created ：2016-19/10/2016-15:24
 */
public class Main {
    public static void main(String[] args) {
        PrintQueue printQueue = new PrintQueue();

        Thread[] threads = new Thread[10];
        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(new Job(printQueue), "Thread" + i);
        }

        for (int i = 0; i < 10; i++) {
            threads[i].start();
        }
    }
}
