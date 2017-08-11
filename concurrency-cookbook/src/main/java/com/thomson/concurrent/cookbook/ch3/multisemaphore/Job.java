package com.thomson.concurrent.cookbook.ch3.multisemaphore;


/**
 * 类说明
 *
 * @author Thomson Tang
 * @version Created ：2016-21/10/2016-16:45
 */
public class Job<T> implements Runnable {
    private T document;
    private PrintQueueWithSemaphores printQueue;

    public Job(T document, PrintQueueWithSemaphores printQueue) {
        this.document = document;
        this.printQueue = printQueue;
    }

    @Override
    public void run() {
        System.out.printf("%s: Going to print a job:\n", Thread.currentThread().getName());
        printQueue.printJob(document);
        System.out.printf("%s: The document has been printed.\n", Thread.currentThread().getName());
    }
}
