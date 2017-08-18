package com.thomson.concurrent.cookbook.ch2.conditions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedList;
import java.util.List;

/**
 * The event storage.
 *
 * @author Thomson Tang
 * @version Created ：2016-8/11/16-17:56
 */
public class EventStorage<T> {
    private static final Logger logger = LoggerFactory.getLogger(EventStorage.class);
    private int maxSize;
    private List<T> storage;

    public EventStorage() {
        this.maxSize = 10;
        this.storage = new LinkedList<>();
    }

    public synchronized void set(T element) {
        while (storage.size() == maxSize) {
            try {
                wait();
            } catch (InterruptedException e) {
                logger.error("the error occurred.", e);
            }
        }
        ((LinkedList<T>) storage).offer(element);
        logger.info("Set: {}, Size: {}", element, storage.size());
        notifyAll();
    }

    public synchronized T get() {
        while (storage.size() == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                logger.error("the error occurred.", e);
            }
        }
        T element = ((LinkedList<T>) storage).poll();
        logger.info("Get: {}, Size: {}", element, storage.size());
        notifyAll();
        return element;
    }
}
