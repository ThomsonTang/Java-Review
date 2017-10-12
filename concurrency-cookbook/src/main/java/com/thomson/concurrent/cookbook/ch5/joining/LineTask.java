package com.thomson.concurrent.cookbook.ch5.joining;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.RecursiveTask;

/**
 * 计算指定单词在单独一行中出现的次数
 *
 * @author Thomson Tang
 */
public class LineTask extends RecursiveTask<Integer> {
    private static final Logger LOGGER = LoggerFactory.getLogger(LineTask.class);
    private static final long serialVersionUID = 1L;

    private String line[];
    private int start, end;
    private String word;

    public LineTask(String[] line, int start, int end, String word) {
        this.line = line;
        this.start = start;
        this.end = end;
        this.word = word;
    }

    @Override
    protected Integer compute() {

        return null;
    }
}
