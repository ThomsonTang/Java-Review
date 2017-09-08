package com.thomson.jcip.ch8.threadpool.factory;

import com.thomson.jcip.ch8.threadpool.Task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

import static com.thomson.jcip.ch8.threadpool.factory.MyAppThread.*;

/**
 * 定制化线程工厂的测试类
 *
 * @author Thomson Tang
 * @version Created: 08/09/2017.
 */
public class TestMain {
    public static final Logger LOGGER = LoggerFactory.getLogger(TestMain.class);

    public static void main(String[] args) {
        MyThreadFactory myThreadFactory = new MyThreadFactory("test-pool");
        for (int i = 0; i < 20; i++) {
            Thread thread = myThreadFactory.newThread(new Task("task" + i));
            thread.start();
        }

        for (int i = 0; i < 10; i++) {
            LOGGER.info("created thread: {}", getThreadsCreated());
            LOGGER.info("alive thread: {}", getThreadsAlive());
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
