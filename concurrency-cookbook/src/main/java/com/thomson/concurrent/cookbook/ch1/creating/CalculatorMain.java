package com.thomson.concurrent.cookbook.ch1.creating;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * <h1>This sample includes two partials about thread management. One is about creating and running a thread, the other
 * is for getting and setting thread information.</h1>
 *
 * <ul> <li>1. create 10 threads which use a class that implements Runnable interface. </li> <li> 2. set the
 * priority(max or min) and name for each thread. </li> </ul>
 *
 * @author Thomson Tang
 * @version created: 11/11/13
 */
public class CalculatorMain {
    public CalculatorMain() {
    }

    public static void main(String[] args) throws IOException {
        Thread[] threads = new Thread[10];
        Thread.State status[] = new Thread.State[10];

        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(new Calculator(i));
            if (i % 2 == 0) {
                threads[i].setPriority(Thread.MAX_PRIORITY);
            } else {
                threads[i].setPriority(Thread.MIN_PRIORITY);
            }
            threads[i].setName("Thread " + i);
        }

        FileWriter file = new FileWriter("data-log.txt");
        PrintWriter printWriter = new PrintWriter(file);
        for (int i = 0; i < 10; i++) {
            printWriter.println("Main: Status of Thread " + i + " : " + threads[i].getState());
            status[i] = threads[i].getState();
        }

        for (int i = 0; i < 10; i++) {
            threads[i].start();
        }

        boolean finish = false;
        while (!finish) {
            for (int i = 0; i < 10; i++) {
                if (threads[i].getState() != status[i]) {
                    writeThreadInfo(printWriter, threads[i], status[i]);
                    status[i] = threads[i].getState();
                }
            }
            finish = true;
            for (int i = 0; i < 10; i++) {
                finish = finish && (threads[i].getState() == Thread.State.TERMINATED);
            }
        }
    }

    private static void writeThreadInfo(PrintWriter printWriter, Thread thread, Thread.State state) {
        printWriter.printf("Main: ID %d - %s\n", thread.getId(), thread.getName());
        printWriter.printf("Main: Priority: %d\n", thread.getPriority());
        printWriter.printf("Main: Old state: %s\n", state);
        printWriter.printf("Main: New state: %s\n", thread.getState());
        printWriter.printf("Main: *****************************************************\n");
        printWriter.flush();
    }
}
