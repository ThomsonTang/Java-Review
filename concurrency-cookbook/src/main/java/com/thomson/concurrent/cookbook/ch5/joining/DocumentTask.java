package com.thomson.concurrent.cookbook.ch5.joining;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.RecursiveTask;

/**
 * 任务类。
 *
 * @author Thomson Tang
 */
public class DocumentTask extends RecursiveTask<Integer> {
    private static final Logger LOGGER = LoggerFactory.getLogger(DocumentTask.class);

    private String document[][];
    private int start, end;
    private String word;

    public DocumentTask(String[][] document, int start, int end, String word) {
        this.document = document;
        this.start = start;
        this.end = end;
        this.word = word;
    }

    @Override
    protected Integer compute() {
        int result;
        if (end - start < 10) {
            result = processLines(document, start, end, word);
        } else {
            int mid = (start + end) / 2;
            DocumentTask documentTask1 = new DocumentTask(document, start, mid, word);
            DocumentTask documentTask2 = new DocumentTask(document, mid, end, word);
            invokeAll(documentTask1, documentTask2);

            try {
                groupResults(documentTask1.get(), documentTask2.get());
            } catch () {

            }
        }
        return result;
    }
}
