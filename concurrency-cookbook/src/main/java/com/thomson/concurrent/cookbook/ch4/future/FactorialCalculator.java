package com.thomson.concurrent.cookbook.ch4.future;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * 计算任务类。
 *
 * @author Thomson Tang
 * @version Created: 14/09/2017.
 */
public class FactorialCalculator implements Callable<Integer> {
    private static final Logger LOGGER = LoggerFactory.getLogger(FactorialCalculator.class);
    private Integer number;

    public FactorialCalculator(Integer number) {
        this.number = number;
    }

    @Override
    public Integer call() throws Exception {
        int result = 1;
        if (number == 0 || number == 1) {
            result = 1;
        } else {
            for (int i = 2; i <= number; i++) {
                result *= i;
                TimeUnit.MILLISECONDS.sleep(20);
            }
        }
        LOGGER.info("{}: {}", Thread.currentThread().getName(), result);
        return result;
    }
}
