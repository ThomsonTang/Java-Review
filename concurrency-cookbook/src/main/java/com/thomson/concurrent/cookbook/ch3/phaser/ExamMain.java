package com.thomson.concurrent.cookbook.ch3.phaser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * <h2>Controlling phase change in concurrent phased tasks.</h2>
 *
 * This example is going to implement a simulation of an exam, where there will be some
 * students who have to do three exercises. All the students have to finish one exercise
 * before they can proceed with the next one.
 *
 * @author Thomson Tang
 * @version Created: 06/09/2017.
 */
public class ExamMain {
    private static final Logger LOGGER = LoggerFactory.getLogger(ExamMain.class);

    public static void main(String[] args) {
        MyPhaser phaser = new MyPhaser();
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Student student = new Student(phaser);
            students.add(student);
            phaser.register();
        }

        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < students.size(); i++) {
            Thread thread = new Thread(students.get(i), "Student-" + i);
            threads.add(thread);
            thread.start();
        }

        // Wait for the finalization of the five threads.
        for (int i = 0; i < threads.size(); i++) {
            try {
                threads.get(i).join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        LOGGER.info("Main: The phaser has finished: {}", phaser.isTerminated());
    }
}
