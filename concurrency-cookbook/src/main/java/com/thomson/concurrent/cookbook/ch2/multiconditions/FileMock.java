package com.thomson.concurrent.cookbook.ch2.multiconditions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A class simulates a text file.
 *
 * @author Thomson Tang
 * @version Created ：2016-9/6/16-14:09
 */
public class FileMock {
    private static final Logger logger = LoggerFactory.getLogger(FileMock.class);
    private String[] content;
    private int index;

    public FileMock(int size, int length) {
        content = new String[size];
        for (int i = 0; i < size; i++) {
            StringBuilder buffer = new StringBuilder(length);
            for (int j = 0; j < length; j++) {
                int indice = (int) Math.random() * 255;
                buffer.append((char) indice);
            }
            content[i] = buffer.toString();
        }
        index = 0;
    }

    public boolean hasMoreLines() {
        return index < content.length;
    }

    public String getLine() {
        if (hasMoreLines()) {
            logger.info("Mock: {}", content.length - index);
            return content[index++];
        }
        return null;
    }
}
