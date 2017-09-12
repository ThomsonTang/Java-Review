package com.thomson.concurrent.cookbook.ch4.creating;

import java.io.Serializable;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 类说明
 *
 * @author Thomson Tang
 * @version Created: 12/09/2017.
 */
public class Server {
    private ThreadPoolExecutor executor;

    public Server() {
        executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
    }
}
