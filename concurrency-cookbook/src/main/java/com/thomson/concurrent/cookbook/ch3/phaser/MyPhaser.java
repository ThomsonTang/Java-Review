package com.thomson.concurrent.cookbook.ch3.phaser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Phaser;

/**
 * A simulation of exam.
 *
 * @author Thomson Tang
 * @version Created: 05/09/2017.
 */
public class MyPhaser extends Phaser {
    private static final Logger LOGGER = LoggerFactory.getLogger(MyPhaser.class);

    @Override
    protected boolean onAdvance(int phase, int registeredParties) {
        switch (phase) {
            case 0:
                return studentArrived();
            case 1:
                return finishFirstExercise();
            case 2:
                return finishSecondExercise();
            case 3:
                return finishExam();
            default:
                return true;
        }
    }

    private boolean finishExam() {
        LOGGER.info("Phaser: All the students have finished the exam.");
        LOGGER.info("Phaser: Thank you for your time.");
        return true;
    }

    private boolean finishSecondExercise() {
        LOGGER.info("Phaser: All the students have finished the second exercise.");
        LOGGER.info("Phaser: It's time for the third one.");
        return false;
    }

    private boolean finishFirstExercise() {
        LOGGER.info("Phaser: All the students have finished the first exercise.");
        LOGGER.info("Phaser: It's time for the second one.");
        return false;
    }

    // return false to indicate that the phaser continue with its execution.
    private boolean studentArrived() {
        LOGGER.info("Phaser: the exam are going to start. The student are ready.");
        LOGGER.info("Phaser: we have {} students.", getRegisteredParties());
        return false;
    }
}
