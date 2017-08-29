package com.thomson.concurrent.cookbook.ch3.cyclicbarrier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CyclicBarrier;

/**
 * <h2>Synchronizing tasks in a common point</h2>
 *
 * In the example, you will look for a number in a matrix of numbers.
 * The matrix will be divided in subsets(using the divide and conquer technique),
 * so each thread will look for the number in one subset. Once all the threads
 * have finished their job, a final task will unify the result of them.
 *
 * @author Thomson Tang
 * @version Created: 28/08/2017.
 */
public class Main {
    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        final int ROWS = 10000;
        final int NUMBERS = 1000;
        final int SEARCH = 5;
        final int PARTICIPANTS = 5;
        final int LINES_PARTICIPANT = 2000;

        MatrixMock matrixMock = new MatrixMock(ROWS, NUMBERS, SEARCH);
        Results results = new Results(ROWS);
        Grouper grouper = new Grouper(results);
        CyclicBarrier barrier = new CyclicBarrier(PARTICIPANTS, grouper);

        Searcher searcher[] = new Searcher[PARTICIPANTS];
        for (int i = 0; i < PARTICIPANTS; i++) {
            searcher[i] = new Searcher(i * LINES_PARTICIPANT, (i * LINES_PARTICIPANT) + LINES_PARTICIPANT, matrixMock, results, 5, barrier);
            Thread thread = new Thread(searcher[i]);
            thread.start();
        }

        LOGGER.info("Main: The main thread has finished!");

    }
}
