package generics.wildcards;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * includes some test cases about wildcards.
 *
 * @author Thomson Tang
 * @version Created ：2016-06/10/2016-12:20
 */
public class CovariantArraysTest {

    @Test(expected = ArrayStoreException.class)
    public void testCovariantArrays() {
        Fruit[] fruit = new Apple[10];
        fruit[0] = new Apple();
        fruit[1] = new Jonathan();

        // Runtime type is Apple[], not Fruit[] or Orange[]:
        fruit[0] = new Fruit(); //compiler allows you to add Fruit
        fruit[1] = new Orange(); //compiler allows you to add Oranges
    }

    @Test
    //CompileTimeError, won't compile:
    public void testNonCovariantGenerics() {
        //Compile Error: incompatiable types:
//        List<Fruit> fruit = new ArrayList<Apple>();
    }

    @Test
    public void testGenericsAndCovariance() {
        //Wildcards allow covariance:
        List<? extends Fruit> flist = new ArrayList<Apple>();

        //Compile Error: can't add any type of object:
//        flist.add(new Apple());
//        flist.add(new Fruit());
//        flist.add(new Object());
        flist.add(null); //Legal but uninteresting

        //we know that it returns at least Fruit:
        Fruit fruit = flist.get(0);
    }

    @Test
    public void testCompilerIntelligence() {
        List<? extends Fruit> flist = Arrays.asList(new Apple());
        Apple apple = (Apple)flist.get(0); //No warning
        flist.contains(new Apple()); // Argument is 'Object'
        flist.indexOf(new Apple()); // Argument is 'Object'
    }
}