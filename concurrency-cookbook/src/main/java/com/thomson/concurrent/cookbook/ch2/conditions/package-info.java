/**
 * <h2>Using conditions in synchronized code</h2>
 *
 * A classic problem in concurrent programming is the <strong>producer-consumer</strong> problem.
 *
 * <p>For these types of situations, Java provides the {@link java.lang.Object#wait()}, {@link
 * java.lang.Object#notify()}, {@link java.lang.Object#notifyAll()}</p> methods implemented in the
 * {@link java.lang.Object} class. A thread can call the {@code wait()}  method inside a {@code
 * synchronized} block of code. If it call the {@code wait()} method outside a {@code synchronized}
 * block of code, the JVM throws an {@link java.lang.IllegalMonitorStateException} exception. When
 * the thread call the {@code wait()} method, the JVM puts the thread to sleep and releases the object
 * that controls the {@code synchronized} block of code that it's executing and allows the other threads
 * to execute other blocks of {@code synchronized} code protected by that object. To wake up the thread,
 * you must call the {@code notify()} or {@code notifyAll()} method inside a block of code protected
 * by the same object.
 *
 * @author Thomson Tang
 * @version Created ：2016-8/11/16-17:39
 */
package com.thomson.concurrent.cookbook.ch2.conditions;