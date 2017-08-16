package com.thomson.jcip.ch5.building;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * 隐藏迭代器
 *
 * @author Thomson Tang
 * @version Created: 16/08/2017.
 */
public class HiddenIterator {
    private final Set<Integer> set = new HashSet<>();

    public void add(Integer i) {
        set.add(i);
    }

    public void remove(Integer i) {
        set.remove(i);
    }

    public void addTenThings() {
        Random random = new Random();
        for (int i = 0; i < 10000000; i++) {
            add(i);
        }
        System.out.println("DEBUG: added ten elements to " + set);
    }

    public static void main(String[] args) {
        HiddenIterator iterator = new HiddenIterator();

        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                iterator.addTenThings();
            }
        });

        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100000; i++) {
                    iterator.remove(i);
                    System.out.println(i + " removed.");
                }
            }
        });

        threadA.start();
        threadB.start();

//        try {
//            TimeUnit.SECONDS.sleep(120);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }
}

// TODO: 本意是用实例测试一下「隐式迭代」引起的并发错误，但是反复测试并未成功。这儿还需要仔细研究一番。