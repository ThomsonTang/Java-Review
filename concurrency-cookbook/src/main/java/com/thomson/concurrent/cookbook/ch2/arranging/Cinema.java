package com.thomson.concurrent.cookbook.ch2.arranging;

/**
 * This class simulates a cinema with two screens and two ticket offices. When a ticker office sells
 * tickets, they are for one of the two cinemas, but not for both, so the numbers of free seats in
 * each cinema are independent attributes.
 *
 * @author Thomson Tang
 * @version Created ：2016-8/9/16-17:36
 */
public class Cinema {
    private long vacanciesCinema1;
    private long vacanciesCinema2;

    private final Object controlCinema1, controlCinema2;

    public Cinema() {
        vacanciesCinema1 = 20;
        vacanciesCinema2 = 20;
        controlCinema1 = new Object();
        controlCinema2 = new Object();
    }

    public boolean sellTickets1(int number) {
        synchronized (controlCinema1) {
            if (number < vacanciesCinema1) {
                vacanciesCinema1 -= number;
                return true;
            } else {
                return false;
            }
        }
    }

    public boolean sellTickets2(int number) {
        synchronized (controlCinema2) {
            if (number < vacanciesCinema2) {
                vacanciesCinema2 -= number;
                return true;
            } else {
                return false;
            }
        }
    }

    public boolean returnTickets1(int number) {
        synchronized (controlCinema1) {
            vacanciesCinema1 += number;
            return true;
        }
    }

    public boolean returnTickets2(int number) {
        synchronized (controlCinema2) {
            vacanciesCinema2 += number;
            return true;
        }
    }

    public long getVacanciesCinema1() {
        return vacanciesCinema1;
    }

    public long getVacanciesCinema2() {
        return vacanciesCinema2;
    }
}
