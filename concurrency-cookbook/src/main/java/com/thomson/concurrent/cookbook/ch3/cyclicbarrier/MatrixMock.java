package com.thomson.concurrent.cookbook.ch3.cyclicbarrier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

/**
 * This class will generate a random matrix of numbers between one and 10 where the threads are going to look for a number.
 *
 * @author Thomson Tang
 * @version Created: 28/08/2017.
 */
public class MatrixMock {
    private static final Logger LOGGER = LoggerFactory.getLogger(MatrixMock.class);
    private int[][] data;

    public MatrixMock(int size, int length, int number) {
        int counter = 0;
        data = new int[size][length];
        Random random = new Random();

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < length; j++) {
                data[i][j] = random.nextInt(10);
                if (data[i][j] == number) {
                    counter++;
                }
            }
        }

        LOGGER.info("Mock: There are {} occurrences of number in generated data.", counter, number);
    }

    public int[] getRow(int row) {
        if (row >= 0 && row < data.length) {
            return data[row];
        }
        return null;
    }
}
