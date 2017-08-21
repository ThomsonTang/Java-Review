package com.thomson.jcip.ch5.cache;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Replacing HashMap with {@link ConcurrentHashMap}
 *
 * 方案二将 HasMap 替换为 ConcurrentHashMap 来作为缓存。由于ConcurrentHashMap是线程安全的， 所以在访问底层Map时就不需要进行同步了。
 * Memoizer2 比 Memoizer1 有着更好的并发性，多线程可 以并发的使用它。但是作为缓存时，仍存在一些不足：如果一个线程在执行计算的过程中，
 * 另一个线程也来访问，发现获取的值为null，此时该线程也会去执行计算，这样就会导致同样的计算过程执行了多次，其实最好的方法是其他线程只需
 * 等待最开始的那个线程计算完成以后将结果返回即可。
 *
 * @author Thomson Tang
 * @version Created: 21/08/2017.
 */
public class Memoizer2<K, V> implements Computable<K, V> {
    private final Map<K, V> cache = new ConcurrentHashMap<K, V>();
    private final Computable<K, V> computable;

    public Memoizer2(Computable<K, V> computable) {
        this.computable = computable;
    }

    @Override
    public V compute(K arg) throws InterruptedException {
        V result = cache.get(arg);
        if (result == null) {
            result = computable.compute(arg);
            cache.put(arg, result);
        }
        return result;
    }
}
