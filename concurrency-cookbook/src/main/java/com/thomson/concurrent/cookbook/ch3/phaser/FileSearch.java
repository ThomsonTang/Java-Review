package com.thomson.concurrent.cookbook.ch3.phaser;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Phaser;

/**
 * This class implements the operation of searching for files with a determined execution modified
 * in the last 24 hours in a folder and its subfolders.
 *
 * @author Thomson Tang
 * @version Created: 30/08/2017.
 */
public class FileSearch implements Runnable {
    private String initPath;
    private String end;
    private List<String> results;
    private Phaser phaser;

    public FileSearch(String initPath, String end, Phaser phaser) {
        this.initPath = initPath;
        this.end = end;
        this.phaser = phaser;
        this.results = new ArrayList<>();
    }

    @Override
    public void run() {

    }

    private void directoryProcess(File file) {
        File[] files = file.listFiles();
        if (null != files) {
            for (int i = 0; i < files.length; i++) {
                if (files[i].isDirectory()) {
                    directoryProcess(files[i]);
                } else {
                    fileProcess(files[i]);
                }
            }
        }
    }

    private void fileProcess(File file) {
        if (file.getName().endsWith(end)) {
            results.add(file.getAbsolutePath());
        }
    }
}
