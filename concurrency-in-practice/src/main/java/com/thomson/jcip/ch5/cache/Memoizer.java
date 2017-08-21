package com.thomson.jcip.ch5.cache;

import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * Final implementation of {@code Memorizer}.
 *
 * 该方案中使用了{@link ConcurrentHashMap} 中的原子方法 {@code putIfAbsent} 方法，避免了{@link Memoizer3}中的漏洞。
 * 当我们缓存的是Future而不是具体的值时，将会导致缓存污染的问题：也就是说如果某个计算被取消或者失败了，那么试图计算结果的
 * future也将被标记为取消或失败。为了避免这种情况，如果Memoizer发现计算被取消了，那么它将会从缓存中删除这个Future。如果
 * 有{@code RuntimeException}抛出，那么也应该将其从缓存中删除，这样将来的计算才有可能成功。
 *
 * @author Thomson Tang
 * @version Created: 22/08/2017.
 */
public class Memoizer<K, V> implements Computable<K, V> {
    private final Map<K, Future<V>> cache = new ConcurrentHashMap<>();
    private final Computable<K, V> computable;

    public Memoizer(Computable<K, V> computable) {
        this.computable = computable;
    }

    @Override
    public V compute(K arg) throws InterruptedException {
        while (true) {
            Future<V> future = cache.get(arg);
            if (future == null) {
                Callable<V> callable = new Callable<V>() {
                    @Override
                    public V call() throws Exception {
                        return computable.compute(arg);
                    }
                };
                FutureTask<V> task = new FutureTask<V>(callable);
                future = cache.putIfAbsent(arg, task);
                if (future == null) {
                    future = task;
                    task.run();
                }
            }
            try {
                return future.get();
            } catch (CancellationException e) {
                cache.remove(arg, future);
            } catch (ExecutionException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
