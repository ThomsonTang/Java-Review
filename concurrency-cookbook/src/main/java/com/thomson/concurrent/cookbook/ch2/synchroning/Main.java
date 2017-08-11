package com.thomson.concurrent.cookbook.ch2.synchroning;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <h2>Synchronizing A Method</h2>
 *
 * <p> We have developed an application that increments and decrements tha balance of a class that simulates a bank
 * account.
 *
 * <p> If you want to see the problems of concurrent access to shared data, delete the {@code synchronized} keyword of
 * the {@link Account#addAmount(double)} and {@link Account#subtractAmount(double)} methods and run the program. Without
 * the {@code synchronized} keyword, while a thread is sleeping after reading the value of the account's balance,
 * another method will read the account's balance, so both the methods will modify the same balance and one of the
 * operations won't be reflected in the final result.
 *
 * <p>Only a thread can access the methods of an object that use the {@code synchronized} keyword in their declaration.
 * If a thread (A) is executing a {@code synchronized} method and another thread (B) wants to execute other {@code
 * synchronized} methods of the same object, it will be blocked util the thread (A) ends. But if thread (B) has access
 * to different objects of the same class, none of them will be blocked.</p>
 *
 * @author Thomson Tang
 * @version Created ：2016-8/9/16-15:34
 */
public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        Account account = new Account();
        account.setBalance(1000);

        Company company = new Company(account);
        Thread companyThread = new Thread(company);

        Bank bank = new Bank(account);
        Thread bankThread = new Thread(bank);

        logger.info("Account: Initial Balance: {}", account.getBalance());

        companyThread.start();
        bankThread.start();

        try {
            companyThread.join();
            bankThread.join();
            logger.info("Account: Final Balance: {}", account.getBalance());
        } catch (InterruptedException e) {
            logger.error("The error occurred.", e);
        }
    }
}
