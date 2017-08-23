package com.thomson.jcip.ch6.execution;

import java.util.concurrent.Executor;

/**
 * <h2>Executor that Executes Tasks Synchronously in the Calling Thread.</h2>
 *
 * Executor的又一种实现，实现了在调用线程中以同步的方式来执行所有任务。
 *
 * @author Thomson Tang
 * @version Created: 24/08/2017.
 */
public class WithinThreadExecutor implements Executor {
    @Override
    public void execute(Runnable command) {
        command.run(); //不同新建线程，直接在当前线程中执行run()方法即可。
    }
}
