package com.thomson.jcip.ch5.cache;

import java.math.BigInteger;

/**
 * 类说明
 *
 * @author Thomson Tang
 * @version Created: 21/08/2017.
 */
public class ExpensiveFunction implements Computable<String, BigInteger> {
    @Override
    public BigInteger compute(String arg) throws InterruptedException {
        //after deep thought...经过长时间计算后
        return new BigInteger(arg);
    }
}
