package com.thomson.jcip.ch5.building;

import java.util.Vector;

/**
 * 验证同步集合类存在的问题：在同步集合类上执行复合操作有可能出现问题
 *
 * comes from the chapter5 of JCIP
 *
 * 同步集合类本身是线程安全的，所以将对象的状态委托给这些同步集合类来管理，就能保证线程安全性。但是还存在一种例外，如果在同一个集合类上执行复合操作，那么就会产生一些不符合预期的问题。
 * 因此需要在客户端进行加锁操作，这样就能起到保护复合操作的作用。
 *
 * 如果取消同步，{@code getLast()} 方法不一定能获取到真正的最后一个元素，有可能{@code deleteLast()}方法已经将最后一个元素删除了
 *
 * @author Thomson Tang
 * @version Created: 11/08/2017.
 */
public class VectorMain {

    /**
     * 获取最后一个元素
     */
    public static Object getLast(Vector list) {
        //通过给集合对象加锁，起到保护复合操作的作用
        synchronized (list) {
            int lastIndex = list.size() - 1;
            return list.get(lastIndex);
        }
    }

    /**
     * 删除最后一个元素
     */
    public static void deleteLast(Vector list) {
        //通过给集合对象加锁，起到保护复合操作的作用
        synchronized (list) {
            int lastIndex = list.size() - 1;
            list.remove(lastIndex);
        }
    }

    public static void main(String[] args) {
        Vector vector = newVector();

        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("the last: " + getLast(vector));
            }
        });

        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                deleteLast(vector);
            }
        });
        threadA.start();
        threadB.start();
    }

    private static Vector newVector() {
        Vector vector = new Vector();
        for (int i = 0; i < 1000000; i++) {
            vector.add("element-" + i);
        }
        return vector;
    }
}
