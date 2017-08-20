package com.thomson.jcip.ch5.cache;

import java.util.HashMap;
import java.util.Map;

/**
 * Initial Cache Attempt Using {@link HashMap} and {@code synchronization}.
 *
 * 此处是通过使用{@link HashMap}来作为计算结果的缓存，由于HashMap不是线程安全的，所以在{@code compute()} 方法上使用了同步，这样来确保线程安全性。
 * 但是很明显的，这种方法不具备良好的可伸缩性，因为当一个线程执行{@code compute()}方法时，其他调用此方法的线程可能被阻塞很长时间，这样会导致多个线
 * 一直处于排队等待计算结果的状态。
 *
 * @author Thomson Tang
 * @version Created: 21/08/2017.
 */
public class Memoizer1<K, V> implements Computable<K, V> {
    private final Map<K, V> cache = new HashMap<>();
    private final Computable<K, V> c;

    public Memoizer1(Computable<K, V> c) {
        this.c = c;
    }

    @Override
    public synchronized V compute(K arg) throws InterruptedException {
        V result = cache.get(arg);
        if (result == null) {
            result = c.compute(arg);
            cache.put(arg, result);
        }
        return result;
    }
}
