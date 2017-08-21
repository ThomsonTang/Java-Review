package com.thomson.jcip.ch5.cache;

/**
 * Indicate an operation can be computed.
 *
 * @author Thomson Tang
 * @version Created: 21/08/2017.
 */
public interface Computable<K, V> {
    V compute(K arg) throws InterruptedException;
}
