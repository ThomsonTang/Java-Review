package com.thomson.concurrent.cookbook.ch5.creating;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.concurrent.RecursiveAction;

/**
 * 任务类。
 *
 * @author Thomson Tang
 * @version Created: 19/09/2017.
 */
public class Task extends RecursiveAction {
    private static final Logger LOGGER = LoggerFactory.getLogger(Task.class);

    private List<Product> products;
    private int first;
    private int last;
    private double increment;

    public Task(List<Product> products, int first, int last, double increment) {
        this.products = products;
        this.first = first;
        this.last = last;
        this.increment = increment;
    }

    @Override
    protected void compute() {
        if (last - first < 10) {
            updatePrices();
        } else {
            int middle = (last - first) / 2;
            LOGGER.info("Task: Pending tasks: {}", getQueuedTaskCount());
            Task task1 = new Task(products, first, middle + 1, increment);
            Task task2 = new Task(products, middle + 1, last, increment);
            invokeAll(task1, task2);
        }
    }

    private void updatePrices() {
        for (int i = first; i < last; i++) {
            Product product = products.get(i);
            product.setPrice(product.getPrice() * (1 + increment));
        }
    }
}
