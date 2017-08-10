package com.thomson.concurrent.cookbook.ch1.exception;

/**
 * Implement a class to treat the unchecked exception.
 *
 * In this method, we can release the system resource, when caught the exception, or close some
 * socket, connections and so on.
 *
 * @author ThomsonTang
 * @version 7/2/14
 */
public class ExceptionHandler implements Thread.UncaughtExceptionHandler {
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.printf("An exception has been captured.\n");
        System.out.printf("Thread: %s\n", t.getId());
        System.out.printf("Exceptions: %s: %s\n", e.getClass().getName(), e.getMessage());
        System.out.printf("Stack trace: \n");
        e.printStackTrace(System.out);
        System.out.printf("Thread status: %s\n", t.getState());
    }
}
