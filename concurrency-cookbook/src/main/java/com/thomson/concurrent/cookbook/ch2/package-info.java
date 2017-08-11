/**
 * <h1>Basic Thread Synchronization</h1>
 *
 * <p>In a concurrent application, it is normal that multiple threads read or write the same data or
 * have access to the same file or database connection. These shared resources can provoke error
 * situations or data inconsistency and we have to implement mechanisms to avoid these errors.</p>
 *
 * <p>The solution for these problems comes with the concept of <strong>critical section</strong>. A
 * critical section is a block of code that accesses a shared resource and can't be executed by more
 * than one thread at the same time.</p>
 *
 * <p>To help programmers to implement critical sections, Java offers <strong>synchronization</strong>
 * mechanisms. When a thread wants to access to a critical section, it uses one of those synchronization
 * mechanisms to find out if there is any other thread executing the critical section. If not, the
 * thread enters the critical section. Otherwise, the thread is suspended by the synchronization
 * mechanism until the thread that is executing the critical section ends it. When more than one
 * thread is waiting for a thread to finish the execution of a critical section, the JVM chooses one
 * of them, and the rest wait for their turn.</p>
 *
 * <p>There are two basic synchronization mechanisms offered by the Java language:
 *
 * <ul>
 * <li>The keyword <strong>synchronized</strong></li>
 * <li>The <strong>Lock</strong> interface and its implementations</li>
 * </ul>
 *
 * @author Thomson Tang
 * @version Created ：2016-8/4/16-17:48
 */
package com.thomson.concurrent.cookbook.ch2;