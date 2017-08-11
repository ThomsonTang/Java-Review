/**
 * <h2>Synchronizing a block of code with a Local</h2>
 *
 * Java provides another mechanism for the synchronization of blocks of code. It's a more powerful
 * and flexible mechanism than the {@code synchronized} keyword. It's based on the {@link java.util.concurrent.locks.Lock}
 * interface and classes that implement it(as {@link java.util.concurrent.locks.ReentrantLock}). This
 * mechanism presents some advantages, which as follows:
 * <ul>
 * <li>It allows the structuring of synchronized blocks in a more flexible way. The {@code Lock}
 * interfaces allow you to get more complex structures to implement your critical section.</li>
 * <li>The {@code Lock} interfaces provide additional functionalities over the {@code synchronized}
 * keyword. One of the new functionalities is implemented by the {@code tryLock()} method. This
 * method tries to get the control of the lock and if it can't, because it's used by other thread,
 * it returns the lock. With locks, you can execute the {@code tryLock()} method. This method
 * returns a {@code Boolean} value indicating if there is anther thread running the code protected
 * by this lock.</li>
 * <li>The {@code Lock} interfaces allow a separation of read and write operations having multiple
 * readers and only one modifier.</li>
 * <li>The {@code Lock} interfaces offer better performance than the {@code synchronized} keyword.</li>
 * </ul>
 *
 * @author Thomson Tang
 * @version Created ：2016-8/17/16-18:00
 */
package com.thomson.concurrent.cookbook.ch2.lock;