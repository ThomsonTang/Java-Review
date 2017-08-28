package com.thomson.concurrent.cookbook.ch3.cyclicbarrier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * This class will look for a number in determined rows of the matrix of random numbers.
 *
 * @author Thomson Tang
 * @version Created: 28/08/2017.
 */
public class Searcher implements Runnable {
    private static final Logger LOGGER = LoggerFactory.getLogger(Searcher.class);

    private int firstRow;
    private int lastRow;
    private MatrixMock matrixMock;
    private Results results;
    private int number;

    private final CyclicBarrier barrier;

    public Searcher(int firstRow, int lastRow, MatrixMock matrixMock, Results results, int number, CyclicBarrier barrier) {
        this.firstRow = firstRow;
        this.lastRow = lastRow;
        this.matrixMock = matrixMock;
        this.results = results;
        this.number = number;
        this.barrier = barrier;
    }

    @Override
    public void run() {
        int counter;
        LOGGER.info("{}: Processing lines from {} to {}", Thread.currentThread().getName(), firstRow, lastRow);
        for (int i = firstRow; i < lastRow; i++) {
            int[] row = matrixMock.getRow(i);
            counter = 0;
            for (int j = 0; j < row.length; j++) {
                if (row[j] == number) {
                    counter++;
                }
            }
            results.setData(i, counter);
        }

        LOGGER.info("{}: Lines processed.", Thread.currentThread().getName());

        try {
            barrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
