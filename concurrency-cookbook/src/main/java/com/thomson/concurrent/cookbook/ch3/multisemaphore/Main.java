package com.thomson.concurrent.cookbook.ch3.multisemaphore;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

/**
 * <h1>Controlling concurrent access to multiple copies of a resource</h1>
 *
 * Semaphores can also be used when you need to protect various copies of a shared resources, or when you have a
 * critical section that can be executed by more than one thread at the same time.
 *
 * <h2>how it works:</h2>
 *
 * The {@link java.util.concurrent.Semaphore} object is created using 3 as the parameter of the constructor. The first
 * three threads that call the {@link Semaphore#acquire()} method will get the access to the critical section, while
 * the rest will be blocked. When a thread finished the critical section and releases the semaphore, another thread
 * will acquire it.
 *
 * @author Thomson Tang
 * @version Created ：2016-21/10/2016-16:50
 */
public class Main {
    public static void main(String[] args) {
        PrintQueueWithSemaphores printQueue = new PrintQueueWithSemaphores();

        List<Thread> threadList = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            threadList.add(i, new Thread(new Job<>("TEXT-" + i, printQueue), "THREAD-" + i));
        }

        threadList.forEach(Thread::start);

//        Thread[] threads = new Thread[10];
//        for (int i = 0; i < 10; i++) {
//            threads[i] = new Thread(new Job<>("text_" + i, printQueue), "THREAD-" + i);
//        }
//
//        for (int i = 0; i < 10; i++) {
//            threads[i].start();
//        }

    }
}
