package com.thomson.effective.creatingdestroyingobjs;

import com.thomson.effective.creatingdestroyingobjs.item1.StaticFactoryMethod;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Thomson Tang
 * @version 1.0-SNAPSHOT
 * @version 8/1/13
 */
public class StaticFactoryMethodTest {
    private StaticFactoryMethod staticFactoryMethod1 = null;
    private StaticFactoryMethod staticFactoryMethod2 = null;

    @Before
    public void prepare() {
        staticFactoryMethod1 = StaticFactoryMethod.newInstance("001", "method1");
        staticFactoryMethod2 = StaticFactoryMethod.newInstance("001", "method1");
    }

    @Test
    public void testEqualsInstance() {
        assertEquals(staticFactoryMethod1, staticFactoryMethod2);
    }

    @Test
    public void testSameInstance() {
        assertNotSame(staticFactoryMethod1, staticFactoryMethod2);
    }


}
