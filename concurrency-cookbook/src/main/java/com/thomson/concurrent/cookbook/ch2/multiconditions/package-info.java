/**
 * <h1>Using Multiple Conditions in a Lock</h1>
 *
 * <p>A Lock may be associated with one or more conditions. These conditions are declared in the
 * {@link java.util.concurrent.locks.Condition} interface. The purpose of these conditions is to allow threads to
 * have control of a lock and check whether a condition is {@code true} or not and, if it's {@code false}, be
 * suspended until the other thread wakes them up. The {@link java.util.concurrent.locks.Condition} interface
 * provides the mechanisms to suspend a thread and to wake up a suspended thread.</p>
 *
 * @author Thomson Tang
 * @version Created ：2016-9/6/16-13:53
 */
package com.thomson.concurrent.cookbook.ch2.multiconditions;