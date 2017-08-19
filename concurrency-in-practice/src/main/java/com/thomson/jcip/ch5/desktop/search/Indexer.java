package com.thomson.jcip.ch5.desktop.search;

import java.io.File;
import java.util.concurrent.BlockingQueue;

/**
 * The Consumer task.
 *
 * This task is indexing the file from file queue.
 *
 * @author Thomson Tang
 * @version Created: 19/08/2017.
 */
public class Indexer implements Runnable {
    private final BlockingQueue<File> fileQueue;

    public Indexer(BlockingQueue<File> fileQueue) {
        this.fileQueue = fileQueue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                indexFile(fileQueue.take());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void indexFile(File file) {
        System.out.println("indexing file = [" + file + "]");
    }
}
