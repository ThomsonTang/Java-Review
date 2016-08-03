package threadmanagement;

import java.io.File;

/**
 * Search a file with a determined name in a folder and in all its subfolders.
 *
 * @author ThomsonTang
 * @version 6/20/14
 */
public class FileSearch implements Runnable {
    private String initPath;
    private String fileName;

    public FileSearch(String initPath, String fileName) {
        this.initPath = initPath;
        this.fileName = fileName;
    }

    @Override
    public void run() {
        File file = new File(initPath);
        if (file.isDirectory()) {
            try {
                directoryProcess(file);
            } catch (InterruptedException e) {
                System.out.printf("%s: the search has been interrupted.", Thread.currentThread().getName());
            }
        }
    }

    private void directoryProcess(File dir) throws InterruptedException{
        File[] files = dir.listFiles();
        if (null != files) {
            for (File file : files) {
                if (file.isDirectory()) {
                    directoryProcess(file);
                } else {
                    fileProcess(file);
                }
            }
        }
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
    }

    private void fileProcess(File file) throws InterruptedException {
        if (file.getName().equals(fileName)) {
            System.out.printf("%s: %s\n", Thread.currentThread().getName(), file.getAbsolutePath());
        }
        if (Thread.interrupted())
            throw new InterruptedException();
    }

}
