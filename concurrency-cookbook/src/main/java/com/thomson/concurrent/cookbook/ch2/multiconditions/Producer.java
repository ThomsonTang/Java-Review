package com.thomson.concurrent.cookbook.ch2.multiconditions;

/**
 * A Producer that save data in the buffer.
 *
 * @author Thomson Tang
 * @version Created: 22/08/2017.
 */
public class Producer implements Runnable {
    private FileMock fileMock;
    private Buffer buffer;

    public Producer(FileMock fileMock, Buffer buffer) {
        this.fileMock = fileMock;
        this.buffer = buffer;
    }

    @Override
    public void run() {
        buffer.setPendingLines(true);
        while (fileMock.hasMoreLines()) {
            String line = fileMock.getLine();
            buffer.insert(line);
        }
        buffer.setPendingLines(false);
    }
}
