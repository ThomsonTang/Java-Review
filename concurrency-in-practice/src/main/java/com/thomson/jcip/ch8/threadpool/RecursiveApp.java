package com.thomson.jcip.ch8.threadpool;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 递归算法的并行化
 *
 * @author Thomson Tang
 * @version Created: 10/09/2017.
 */
public class RecursiveApp {
    private static final Logger LOGGER = LoggerFactory.getLogger(RecursiveApp.class);

    public void processSequentially(List<String> elements) {
        for (String element : elements) {
            process(element);
        }
    }

    public void processInParallel(Executor executor, List<String> elements) {
        for (String element : elements) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    process(element);
                }
            });
        }
    }

    public <T> void sequentialRecursive(List<Node<T>> nodes, Collection<T> results) {
        for (Node<T> node : nodes) {
            results.add(node.compute());
            sequentialRecursive(node.getChildren(), results);
        }
    }

    public <T> void parallelRecursive(final Executor executor, List<Node<T>> nodes, final Collection<T> results) {
        for (final Node<T> node : nodes) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    results.add(node.compute());
                }
            });
            parallelRecursive(executor, node.getChildren(), results);
        }
    }

    /**
     * 等待通过并行方式计算的结果
     *
     * @param nodes 元素节点
     * @param <T>   元素类型
     * @return 包含计算结果的集合
     * @throws InterruptedException 等待终止时出现异常
     */
    public <T> Collection<T> getParallelResults(List<Node<T>> nodes) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Queue<T> resultQueue = new ConcurrentLinkedQueue<>();
        parallelRecursive(executorService, nodes, resultQueue);
        executorService.shutdown();
        executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.SECONDS);
        return resultQueue;
    }

    private void process(String element) {
        // process the element
    }

    private class Node<T> {
        public T compute() {
            return null;
        }

        public List<Node<T>> getChildren() {
            return null;
        }
    }
}
