package generics.wildcards;

import static org.junit.Assert.assertEquals;

/**
 * 泛型类方法的参数类型决定了对泛型方法的调用是否安全。
 *
 * This means that it's up to the generic class designer to decide which calls are "safe", and to use {@link Object}
 * types for their arguments. To disallow a call when the type is used with wildcards, use the type parameter in the
 * argument list.
 * <p/>
 * the {@link Holder#set(Object)} method won't work with either an {@link Apple} or a {@link Fruit}, because the
 * {@code set()} argument is also {@code "? extends Fruit"}, which means it can be anything and the compiler can't
 * verify type safety or "anything".
 * <p/>
 * However, the {@link Holder#equals(Object)} method works fine because it takes an {@code Object} instead of a
 * {@code T} as an argument. Thus, the compiler is only paying attention to the types of objects that passed and
 * returned. It is not analyzing the code to see if you preform any actual writes or reads.
 *
 * @author Thomson Tang
 * @version Created ：2016-06/10/2016-17:40
 */
public class HolderTest {

    @org.junit.Test(expected = ClassCastException.class)
    public void testGetSet() {
        Holder<Apple> appleHolder = new Holder<>(new Apple());
        Apple apple = appleHolder.get();
        appleHolder.set(apple);

//        Holder<Fruit> fruitHolder = appleHolder; //cannot upcast
        Holder<? extends Fruit> fruitHolder = appleHolder; //OK

        Fruit fruit = fruitHolder.get();
        apple = (Apple) fruitHolder.get(); //Returns 'Object'

        Orange orange = (Orange) fruitHolder.get(); // No warning

//        fruitHolder.set(new Apple()); //Cannot call set()
//        fruitHolder.set(new Fruit()); //Cannot call set()

        assertEquals(fruit, apple); //OK
    }
}