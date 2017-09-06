package com.thomson.concurrent.cookbook.ch3.phaser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

/**
 * A student class.
 *
 * @author Thomson Tang
 * @version Created: 06/09/2017.
 */
public class Student implements Runnable {
    private static final Logger LOGGER = LoggerFactory.getLogger(Student.class);
    private Phaser phaser;

    public Student(Phaser phaser) {
        this.phaser = phaser;
    }

    @Override
    public void run() {
        // 1. Write a message in the console to indicate that this student has arrived to the exam and calls
        // the arriveAndAwaitAdvance() method of the phaser to wait for the rest of the threads.
        LOGGER.info("{}: Has arrived to do the exam. {}", Thread.currentThread().getName(), new Date());
        phaser.arriveAndAwaitAdvance();

        // 2. Wait for the rest of the students to finish the first exercise.
        LOGGER.info("{}: Is going to do the first exercise.{}", Thread.currentThread().getName(), new Date());
        doExercise1();
        LOGGER.info("{}: Has done the first exercise. {}", Thread.currentThread().getName(), new Date());
        phaser.arriveAndAwaitAdvance();

        // 3. Wait for the rest of the students to finish the second exercise.
        LOGGER.info("{}: Is going to do the second exercise. {}", Thread.currentThread().getName(), new Date());
        doExercise2();
        LOGGER.info("{}: Has done the second exercise. {}", Thread.currentThread().getName(), new Date());
        phaser.arriveAndAwaitAdvance();

        // 4. Wait for the rest of the students to finish the second exercise.
        LOGGER.info("{}: Is going to do the third exercise. {}", Thread.currentThread().getName(), new Date());
        doExercise3();
        LOGGER.info("{}: Has finished the exam. {}", Thread.currentThread().getName(), new Date());
        phaser.arriveAndAwaitAdvance();
    }

    private void doExercise1() {
        try {
            long duration = (long) (Math.random() * 10);
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void doExercise2() {
        try {
            long duration = (long) (Math.random() * 10);
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void doExercise3() {
        try {
            long duration = (long) (Math.random() * 10);
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
