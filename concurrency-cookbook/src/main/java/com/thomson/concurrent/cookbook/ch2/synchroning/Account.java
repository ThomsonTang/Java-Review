package com.thomson.concurrent.cookbook.ch2.synchroning;

/**
 * This class will model our bank account.
 *
 * @author Thomson Tang
 */
public class Account {
    private double balance;

    /**
     * Increment the value of the balance in a certain amount that is passed to the method.
     * Only one thread should change the value of the balance, so use the {@code synchronized}
     * keyword to convert this method into a <strong>critical section</strong>.
     *
     * @param amount the increment amount
     */
    public synchronized void addAmount(double amount) {
        double tmp = balance;
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        tmp += amount;
        balance = tmp;
    }

    /**
     * Decrement the value of the balance in a certain amount. This also use the {@code synchronized}
     * keyword to convert this method into a <strong>critical section</strong>.
     *
     * @param amount the decrement amount
     */
    public synchronized void subtractAmount(double amount) {
        double tmp = balance;
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        tmp -= amount;
        balance = tmp;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
