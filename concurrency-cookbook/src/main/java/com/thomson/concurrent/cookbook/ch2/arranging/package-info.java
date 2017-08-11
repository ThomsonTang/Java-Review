/**
 * <h2>Arranging independent attributes in synchronized classes</h2>
 *
 * <p>When you use the {@code synchronized} keyword to protect a block of code, you must pass an
 * object reference as a parameter. Normally, you will use the {@code this} keyword to reference the
 * object that execute the method, but you can use other object references. Normally, these objects
 * will be created exclusively with this purpose. For example, if you have two independent attributes
 * in a class shared by multiple threads, you must synchronize the access to each variable, but there
 * is no problem if there is one thread accessing one of the attributes and another thread accessing
 * the other at the same time.</p>
 *
 * @author Thomson Tang
 * @version Created ：2016-8/9/16-17:30
 */
package com.thomson.concurrent.cookbook.ch2.arranging;