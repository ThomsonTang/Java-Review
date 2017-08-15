package com.thomson.jcip.ch5.building;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 用迭代器遍历一个List
 *
 * 虽然我们创建的list是一个同步集合类对象，但使用迭代器进行遍历的时候，可能会抛出{@link java.util.ConcurrentModificationException}异常。
 * 这是因为在遍历的过程中，有可能有别的线程也在修改该集合对象。
 *
 * 相应的解决方法有两种：
 * 1. 对集合类加同步锁
 * 2. 遍历的过程中clone集合类对象，并迭代clone对象
 *
 * @author Thomson Tang
 * @version Created: 14/08/2017.
 */
public class IteratingOnSynchronizedList {
    public static void main(String[] args) {
        List<String> list = newStringList();

        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                for (String name : list) {
                    System.out.println("name = [" + name + "]");
                }
            }
        });

        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                list.remove(list.size() - 2);
            }
        });

        threadA.start();
        threadB.start();
    }

    private static List<String> newStringList() {
        List<String> list = Collections.synchronizedList(new ArrayList<>());
        for (int i = 0; i < 100000; i++) {
            list.add("widget-" + i);
        }
        return list;
    }
}
