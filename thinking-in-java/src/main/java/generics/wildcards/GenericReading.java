package generics.wildcards;

import java.util.Arrays;
import java.util.List;

/**
 * As before, the first method {@link #readExact(List)} uses the precise type. So if you use the precise type with no
 * wildcards, you can both write and read that precise type into and out of a {@code List}. In addition, for the
 * return value, the {@code static} generic method {@link #readExact(List)} effectively "adapts" to each method call,
 * and returns an {@code Apple} from a {@code List&lt;Apple&gt;} and a {@code Fruit} from a {@code List&lt;Fruit&gt;
 * }, as you can see in {@link #f1()}. Thus, if you can get away with a {@code static} generic method, you don't
 * necessarily need covariance if you're just reading.
 *
 * @author Thomson Tang
 * @version Created ：2016-06/10/2016-22:44
 */
public class GenericReading {
    static List<Apple> apples = Arrays.asList(new Apple());
    static List<Fruit> fruit = Arrays.asList(new Fruit());

    static <T> T readExact(List<T> list) {
        return list.get(0);
    }

    // A static method adapts to each call:
    static void f1() {
        Apple a = readExact(apples);
        Fruit f = readExact(fruit);
        f = readExact(apples);
    }

    // If, however, you have a class, then its type is established when the class is instantiated:
    static class Reader<T> {
        T readExact(List<T> list) {
            return list.get(0);
        }
    }

    static void f2() {
        Reader<Fruit> fruitReader = new Reader<>();
        Fruit f = fruitReader.readExact(fruit);
//        Fruit a = fruitReader.readExact(apples); // Error: readExact(List<Fruit>) cannot be applied to (List<Apple>).
    }

    static class CovariantReader<T> {
        T readCovariant(List<? extends T> list) {
            return list.get(0);
        }
    }

    static void f3() {
        CovariantReader<Fruit> fruitCovariantReader = new CovariantReader<>();
        Fruit f = fruitCovariantReader.readCovariant(GenericReading.fruit);
        Fruit a = fruitCovariantReader.readCovariant(apples);
    }

    public static void main(String[] args) {
        f1();
        f2();
        f3();
    }
}
