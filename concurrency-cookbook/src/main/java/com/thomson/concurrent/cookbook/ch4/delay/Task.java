package com.thomson.concurrent.cookbook.ch4.delay;

import java.util.Date;
import java.util.concurrent.Callable;

/**
 * the task simulator.
 *
 * @author Thomson Tang
 * @version Created: 05/08/2017.
 */
public class Task implements Callable<String> {
    private String name;

    public Task(String name) {
        this.name = name;
    }

    @Override
    public String call() throws Exception {
        System.out.printf("%s: starting at: %s\n", name, new Date());
        return "Hello, world";
    }
}
