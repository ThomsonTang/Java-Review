package com.thomson.jcip.ch5.cache;

import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * Memorizing Wrapper Using {@link java.util.concurrent.FutureTask}
 *
 * 这种方案的实现几乎是完美的，它很好的处理了前面两种方案存在的问题，不但具有非常好的并发性，
 * 而且结果一旦计算出来就立即返回，如果结果没有出来，新来的线程只需等待计算结果即可。但是它
 * 仍然存在一个缺陷，那就是有两个线程计算出相同值的漏洞，只是这个漏洞发生的概率比起{@link Memoizer2}
 * 中的要小的多，这个漏洞便是由于{@code if}代码块中的的"先检查再执行"操作会导致两个线程都
 * 没有在缓存中找到期望的值而开始计算。
 *
 * 导致这个问题的根本原因是，复合操作（"若没有则添加"）是在底层的Map对象上执行的，而这个对
 * 象无法通过加锁来确保原子性。好在{@code ConcurrentHashMap}本身提供了一些具有相同功能的
 * 原子方法可以直接使用。
 *
 * @author Thomson Tang
 * @version Created: 21/08/2017.
 */
public class Memoizer3<K, V> implements Computable<K, V> {
    private final Map<K, Future<V>> cache = new ConcurrentHashMap<>();
    private final Computable<K, V> computable;

    public Memoizer3(Computable<K, V> computable) {
        this.computable = computable;
    }

    @Override
    public V compute(K arg) throws InterruptedException {
        Future<V> future = cache.get(arg);
        if (future == null) {
            Callable<V> callable = new Callable<V>() {
                @Override
                public V call() throws Exception {
                    return computable.compute(arg);
                }
            };
            FutureTask<V> task = new FutureTask<V>(callable);
            future = task;
            cache.put(arg, task);
            task.run(); //在这里将调用computable.compute
        }
        try {
            return future.get();
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}
