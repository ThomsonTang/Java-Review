package com.thomson.jcip.ch8.threadpool;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * 线程饥饿死锁——在单线程Executor中任务发生死锁
 *
 * 在线程池中，如果任务依赖于其他任务，那么可能产生死锁。在单线程的Executor中，如果一个任务将另一个任务提交到同一个Executor，
 * 并且等待这个被提交的任务的结果，那么通常会引发死锁。
 *
 * @author Thomson Tang
 * @version Created: 05/09/2017.
 */
public class ThreadDeadLock {
    private static final Logger LOGGER = LoggerFactory.getLogger(ThreadDeadLock.class);
    private ExecutorService executor = Executors.newSingleThreadExecutor();

    public String renderPage() throws ExecutionException, InterruptedException {
        Future<String> render = executor.submit(new RenderPageTask());
        return render.get();
    }

    public class RenderPageTask implements Callable<String> {
        private final Logger LOGGER = LoggerFactory.getLogger(RenderPageTask.class);

        @Override
        public String call() throws Exception {
            LOGGER.info("start loading page...");
            Future<String> header = executor.submit(new LoadFileTask("header.html"));
            Future<String> footer = executor.submit(new LoadFileTask("footer.html"));
            String page = renderBody();
            //将发生死锁，因为任务在等待子任务的结果
            return header.get() + page + footer.get();
        }

        private String renderBody() {
            return "<body>the body content</body>";
        }
    }


    public class LoadFileTask implements Callable<String> {
        private final Logger LOGGER = LoggerFactory.getLogger(LoadFileTask.class);
        private String filePath;

        public LoadFileTask(String filePath) {
            this.filePath = filePath;
        }

        @Override
        public String call() throws Exception {
            LOGGER.info("{}: start loading...", filePath);
            TimeUnit.SECONDS.sleep(10);
            LOGGER.info("{}: loaded.", filePath);
            return String.format("file content of %s", filePath);
        }
    }

    public static void main(String[] args) {
        try {
            ThreadDeadLock deadLock = new ThreadDeadLock();
            LOGGER.info("the page: {}", deadLock.renderPage());
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
