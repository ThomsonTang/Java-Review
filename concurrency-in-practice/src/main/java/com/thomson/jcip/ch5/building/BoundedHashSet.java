package com.thomson.jcip.ch5.building;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Semaphore;

/**
 * 类说明
 *
 * @author Thomson Tang
 * @version Created: 20/08/2017.
 */
public class BoundedHashSet<T> {
    private final Set<T> set;
    private final Semaphore semaphore;

    public BoundedHashSet(int bounded) {
        this.set = Collections.synchronizedSet(new HashSet<>());
        this.semaphore = new Semaphore(bounded);
    }

    public boolean add(T o) throws InterruptedException {
        semaphore.acquire();
        boolean wasAdded = false;
        try {
            wasAdded = set.add(o);
            return wasAdded;
        } finally {
            if (!wasAdded) {
                semaphore.release();
            }
        }
    }

    public int size() {
        return set.size();
    }

    public boolean remove(Object o) {
        boolean wasRemoved = set.remove(o);
        if (wasRemoved) {
            semaphore.release();
        }
        return wasRemoved;
    }

    public static void main(String[] args) {
        Set<String> set = new HashSet<>(10);

        for (int i = 0; i < 50; i++) {
            set.add("info-" + i);
        }
        System.out.println("set size = [" + set.size() + "]");

        try {
            BoundedHashSet<String> boundedHashSet = new BoundedHashSet<>(10);
            for (int i = 0; i < 10; i++) { //如果添加的元素多于10个，将会导致当前线程阻塞，因为信号量的acquire()会因为没有许可可以获取到，所以会阻塞直到有许可可用
                boundedHashSet.add("info-" + i);
            }
            System.out.println("bounded set size = [" + boundedHashSet.size() + "]");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
