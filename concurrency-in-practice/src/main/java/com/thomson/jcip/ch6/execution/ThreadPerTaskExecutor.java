package com.thomson.jcip.ch6.execution;

import java.util.concurrent.Executor;

/**
 * <h2>Executor that Start a New Thread for Each Task.</h2>
 *
 * 这是Executor的一种实现，它可以为每个请求启动一个新的线程。是对{@link ThreadPerTaskWebServer} 功能的模仿。
 *
 * @author Thomson Tang
 * @version Created: 24/08/2017.
 */
public class ThreadPerTaskExecutor implements Executor {
    @Override
    public void execute(Runnable command) {
        new Thread(command).start();
    }
}
