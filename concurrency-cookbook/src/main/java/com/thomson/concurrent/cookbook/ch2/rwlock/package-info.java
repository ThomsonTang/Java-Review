/**
 * <h1>Synchronizing data access with read/write locks</h1>
 *
 * <p>One of the most significant improvements offered by locks is the
 * {@link java.util.concurrent.locks.ReadWriteLock} interface and the
 * {@link java.util.concurrent.locks.ReentrantReadWriteLock} class, the unique one that implements it. This class has
 * two locks, one for read operations and one for write operations. There can be more than oen thread using read
 * operations simultaneously, but only one thread can be using write operations. When a thread is doing a write
 * operation, there can't be any thread doing read operation.</p>
 *
 * @author Thomson Tang
 * @version Created ：2016-8/26/16-17:41
 */
package com.thomson.concurrent.cookbook.ch2.rwlock;