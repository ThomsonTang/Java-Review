package com.thomson.concurrent.cookbook.ch5.creating;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

/**
 * <h2>Creating a fork/join pool.</h2>
 *
 * @author Thomson Tang
 * @version Created: 19/09/2017.
 */
public class Main {
    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        ProductListGenerator generator = new ProductListGenerator();
        List<Product> products = generator.generate(15);

        Task task = new Task(products, 0, products.size(), 0.20);
        ForkJoinPool pool = new ForkJoinPool();
        pool.execute(task);

        do {
            LOGGER.info("Main: Thread Count: {}", pool.getActiveThreadCount());
            LOGGER.info("Main: Thread Steal: {}", pool.getStealCount());
            LOGGER.info("Main: Parallelism: {}", pool.getParallelism());

            try {
                TimeUnit.MILLISECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (!task.isDone());

        pool.shutdown();

        if (task.isCompletedNormally()) {
            LOGGER.info("Main: The process has completed normally.");
        }

        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i);
            if (product.getPrice() != 12) {
                LOGGER.info("Product {}: {}", product.getName(), product.getPrice());
            }
        }

        LOGGER.info("Main: End of the program.");
    }
}
