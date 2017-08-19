package com.thomson.jcip.ch5.desktop.search;

import java.io.File;
import java.io.FileFilter;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * the main class for desktop searching application.
 *
 * @author Thomson Tang
 * @version Created: 19/08/2017.
 */
public class DesktopSearcher {
    public static final int CONSUMER_AMOUNT = 2;
    public static final int BOUND_CAPACITY = 2;

    public static void main(String[] args) {
        File[] roots = new File[3];
        roots[0] = new File("/opt/usp");
        roots[1] = new File("/opt/web/");
        roots[2] = new File("/opt/wf");

        startingIndexing(roots);
    }

    public static void startingIndexing(File[] roots) {
        BlockingQueue<File> queue = new LinkedBlockingDeque<>(BOUND_CAPACITY);
        FileFilter fileFilter = new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return true;
            }
        };

        for (File root : roots) {
            new Thread(new FileCrawler(queue, fileFilter, root)).start();
        }

        for (int i = 0; i < CONSUMER_AMOUNT; i++) {
            new Thread(new Indexer(queue)).start();
        }
    }
}
