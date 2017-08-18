package com.thomson.concurrent.cookbook.ch2.conditions;

/**
 * This class implement the producer of the example.
 *
 * @author Thomson Tang
 * @version Created ：2016-8/16/16-18:09
 */
public class Producer implements Runnable {
    private EventStorage<String> storage;

    public Producer(EventStorage<String> storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            storage.set(String.valueOf(i));
        }
    }
}
