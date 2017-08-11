/**
 * <h2>Synchronizing A Method</h2>
 *
 * <p>Only one execution thread will access one of the methods of an object declared with the {@code
 * synchronized} keyword. If another thread tries to access any method declared with the {@code
 * synchronized} keyword of the same object, it will be suspended until the first thread finishes
 * the execution of the method.
 * </p>
 *
 * <p>In other words, every method declared with the {@code synchronized} keyword is a <strong>critical
 * section</strong> and Java only allows the execution of one of the critical sections of an object.
 * </p>
 *
 * <p>Static methods have a different behavior. Only one execution thread will access one of the static
 * methods declared with the {@code synchronized} keyword, but another thread can access other non-static
 * methods of an object of that class. You have to be very careful with this point, because two threads
 * can access two different {@code synchronized} methods if one is static and the other one is not.
 * If both methods change the same data, you can have data inconsistency errors.</p>
 *
 * <h3>There's more...</h3>
 * <p>The {@code synchronized} keyword penalized the performance of the application, so you must only
 * use it on methods that modify shared data in a concurrent environment. If you know that a method
 * will not be called by more than one thread, don't use the {@code synchronized} keyword.</p>
 *
 * <p>You can use recursive calls with {@code synchronized} methods. As the thread has access to the
 * {@code synchronized} methods of an object, you can call other {@code synchronized} methods of that
 * object, including the method that is executing. It won't have to get access to the {@code synchronized}
 * method again.</p>
 *
 * <p>We can use the {@code synchronized} keyword to protect the access to a block of code instead of
 * an entire method. We should use the {@code synchronized} keyword in this way to protect the access
 * to the shared data. leaving the rest of operations out of this block, obtaining a better performance
 * of the application. The objective is to have the <strong>critical section</strong>(the block of code
 * that can be accessed only by one thread at a time) be as short as possible. We have used the {@code
 * synchronized} keyword to protect the access to the instruction that updates the number fo persons
 * in the building, leaving out the long operations of this block that don't use the shared data. When
 * you use the {@code synchronized} keyword in this way, you must pass an object reference as a parameter.
 * Only once thread can access the {@code synchronized} code (blocks or methods) of that object. Normally,
 * we will use the {@code this} keyword to reference the object that is executing the method.</p>
 *
 * <blockquote>
 * synchronzied (this) {
 * // Java code
 * }
 * </blockquote>
 *
 * @author Thomson Tang
 * @version Created ：2016-8/9/16-16:57
 */
package com.thomson.concurrent.cookbook.ch2.synchroning;