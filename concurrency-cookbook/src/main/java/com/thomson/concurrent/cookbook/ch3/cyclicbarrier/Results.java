package com.thomson.concurrent.cookbook.ch3.cyclicbarrier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This class will store, in an array, the number of occurrences of the searched number in each row of the matrix.
 *
 * @author Thomson Tang
 * @version Created: 28/08/2017.
 */
public class Results {
    private static final Logger LOGGER = LoggerFactory.getLogger(Results.class);

    private int[] data;

    public Results(int size) {
        this.data = new int[size];
    }

    public int[] getData() {
        return data;
    }

    public void setData(int position, int value) {
        this.data[position] = value;
    }
}
