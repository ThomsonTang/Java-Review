package com.thomson.concurrent.cookbook.ch2.multiconditions;

/**
 * <h2>Using multiple conditions in a Lock</h2>
 *
 * @author Thomson Tang
 * @version Created: 22/08/2017.
 */
public class Main {
    public static void main(String[] args) {
        FileMock fileMock = new FileMock(100, 10);
        Buffer buffer = new Buffer(20);

        Producer producer = new Producer(fileMock, buffer);
        Thread producerThread = new Thread(producer, "Producer");

        Consumer[] consumers = new Consumer[3];
        Thread[] consumerThread = new Thread[3];
        for (int i = 0; i < 3; i++) {
            consumers[i] = new Consumer(buffer);
            consumerThread[i] = new Thread(consumers[i], "Consumer-" + i);
        }

        producerThread.start();
        for (int i = 0; i < 3; i++) {
            consumerThread[i].start();
        }
    }
}
