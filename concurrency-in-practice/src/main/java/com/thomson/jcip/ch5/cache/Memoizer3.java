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
