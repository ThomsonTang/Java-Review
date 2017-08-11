package com.thomson.concurrent.cookbook.ch4.periodic;

import java.util.Date;
import java.util.concurrent.Callable;

/**
 * A task class which implements the {@link Runnable} interface.
 *
 * @author Thomson Tang
 * @version Created: 05/08/2017.
 */
public class Task implements Runnable {
    private String name;

    public Task(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.printf("%s: starting at: %s\n", name, new Date());
    }
}
