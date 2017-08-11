package com.thomson.effective.ch2;

import com.thomson.effective.creatingdestroyingobjs.item1.StaticFactoryMethod;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Thomson Tang
 * @since 12-8-31
 */
public class ObjectTest {
    private StaticFactoryMethod obj1;
    private StaticFactoryMethod obj2;
    private StaticFactoryMethod obj3;

    @Before
    public void prepareObject() {
        obj1 = StaticFactoryMethod.newInstance("1", "first");
        obj2 = StaticFactoryMethod.newInstance("2", "second");
        obj3 = StaticFactoryMethod.newInstance("1", "first");
        /*
         * type inference
         * if not use static factory method:
         *  Map<String, List<String>> m = new HashMap<String, List<String>>();
         */
        Map<String, List<String>> map = StaticFactoryMethod.newMapInstance();
    }

    @Test
    public void testEquals() {
        Assert.assertNotSame(obj1, obj2);
        //Assert.assertEquals(obj1, obj3);
//        Assert.assertSame(obj1, obj2);
    }
}
