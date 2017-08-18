package com.thomson.concurrent.cookbook.ch2.arranging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <h1>The Main Test Class</h1>
 *
 * <h2>How it works...</h2>
 * <p>When you use the {@code synchronized} keyword to protect a block of code, you use an object as
 * a parameter. JVM guarantees that only one thread can have access to <strong>all the blocks of code protected
 * with that object</strong>(note that we always talk about objects, not about classes.).</p>
 *
 * <p>In this example, we have an object that controls access to the {@code vacanciesCinema1} attribute,
 * so only one thread can modify this attribute each time, and another object controls access to the
 * {@code vacanciesCinema2} attribute, so only one thread can modify this attribute each time. But
 * there may be two threads running simultaneously, one modifying the {@code vacanciesCinema1} attribute
 * and the other one modifying the {@code vacanciesCinema2} attribute.</p>
 *
 * @author Thomson Tang
 * @version Created ：2016-8/11/16-16:41
 */
public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        Cinema cinema = new Cinema();

        TicketOffice1 office1 = new TicketOffice1(cinema);
        Thread thread1 = new Thread(office1, "TicketOfficeOne");

        TicketOffice2 office2 = new TicketOffice2(cinema);
        Thread thread2 = new Thread(office2, "TicketOfficeTwo");

        //start the threads
        thread1.start();
        thread2.start();

        //wait for the completion of the threads.
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            logger.error("the error occurred.", e);
        }

        logger.info("Room 1 Vacancies: {}", cinema.getVacanciesCinema1());
        logger.info("Room 2 Vacancies: {}", cinema.getVacanciesCinema2());
    }
}
