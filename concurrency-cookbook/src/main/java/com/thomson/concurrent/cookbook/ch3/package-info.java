/**
 * <h1>Thread Synchronization Utilities</h1>
 *
 * Chapter2 taught us about the following basic thread synchronization mechanisms:
 * <ul>
 * <li>The <i>synchronized</i> keyword</li>
 * <li>The <i>Lock</i> interface and its implementation classes: <i>ReentrantLock</i>, <i>ReentrantReadWriteLock
 * .ReadLock</i> and <i>ReentrantReadWriteLock.WriteLock</i></li>
 * </ul>
 *
 * This chapter we will lean how to use high-level mechanisms to get the synchronization of multiple threads. These
 * high-level mechanisms are as follows:
 * <ul>
 * <li><strong>Semaphores:</strong> A semaphore is a counter that controls the access to one or more shared resources
 * . This mechanism is a basic tools of concurrent programming.</li>
 * <li><strong>CountDownLatch:</strong> The {@link java.util.concurrent.CountDownLatch} class is a mechanism provided
 * by the java language that allows a thread to wait for the finalization of multiple operations.</li>
 * <li><strong>CyclicBarrier:</strong> The {@link java.util.concurrent.CyclicBarrier} class is another mechanism
 * provided by the java language that allows the synchronization of multiple threads in a common point.
 * </li>
 * <li><strong>Phaser:</strong> The {@link java.util.concurrent.Phaser} class is another mechanism provided by the
 * Java language that controls the execution of concurrent tasks divided in phases. All the threads must finish one
 * phase before they can continue with the next one. This is a new feature in Java 7 API.</li>
 * <li><strong>Exchanger:</strong> The {@link java.util.concurrent.Exchanger} class is another mechanism provided by
 * the java language that provides a point of data interchange between two threads.</li>
 * </ul>
 *
 * @author Thomson Tang
 * @version Created ：2016-18/10/2016-18:19
 */
package com.thomson.concurrent.cookbook.ch3;