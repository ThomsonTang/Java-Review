package com.thomson.concurrent.cookbook.ch3.multisemaphore;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * A print queue that use more than one semaphore to implement protecting multiple copies of a resource.
 *
 * @author Thomson Tang
 * @version Created ：2016-21/10/2016-16:20
 */
public class PrintQueueWithSemaphores {
    private final Semaphore semaphore;
    private boolean[] freePrinters;
    private Lock lockPrinters;

    public PrintQueueWithSemaphores() {
        this.semaphore = new Semaphore(3);
        lockPrinters = new ReentrantLock();
        initFreePrinters();
    }

    private void initFreePrinters() {
        this.freePrinters = new boolean[3];
        for (int i = 0; i < 3; i++) {
            freePrinters[i] = true;
        }
    }

    public <T> void printJob(T document) {
        try {
            semaphore.acquire();
            int assignedPrinter = getPrinter();

            long duration = (long) (Math.random() * 10);
            System.out.printf("%s: %s\n", Thread.currentThread().getName(), document.toString());
            System.out.printf("%s: PrintQueue: Printing a Job in Printer %d during %d seconds\n", Thread
                    .currentThread().getName(), assignedPrinter, duration);
            TimeUnit.SECONDS.sleep(duration);

            freePrinters[assignedPrinter] = true;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
    }

    private int getPrinter() {
        int ret = -1;
        try {
            lockPrinters.lock();
            for (int i = 0; i < freePrinters.length; i++) {
                if (freePrinters[i]) {
                    ret = i;
                    freePrinters[i] = false;
                    break;
                }
            }
        } finally {
            lockPrinters.unlock();
        }
        return ret;
    }
}
