package generics.wildcards;

import java.util.ArrayList;
import java.util.List;

/**
 * In {@link GenericWriting#writeWithWildcard(List, Object)}, the argument is now a {@code List&lt;? super T&gt;}, so the
 * {@code List} holds a specific type that is derived from {@code T}; thus it is safe to pass a {@code T} or anything
 * derived from {@code T} as an argument to {@code List} methods.
 *
 * @author Thomson Tang
 * @version Created ：2016-06/10/2016-21:22
 */
public class GenericWriting {
    static List<Apple> apples = new ArrayList<Apple>();
    static List<Fruit> fruit = new ArrayList<Fruit>();
    static List<Orange> oranges = new ArrayList<>();

    static <T> void writeExact(List<T> list, T item) {
        list.add(item);
    }

    static <T> void writeWithWildcard(List<? super T> list, T item) {
        list.add(item);
    }

    static void f1() {
        writeExact(apples, new Apple());
        writeExact(fruit, new Fruit());
        writeExact(apples, new Jonathan());
    }

    static void f2() {
        writeWithWildcard(apples, new Apple());
        writeWithWildcard(fruit, new Apple());
    }

    static class Writer<T> {
        void writeExact(List<T> list, T item) {
            list.add(item);
        }
    }

    static void f3() {
        Writer<Fruit> fruitWriter = new Writer<>();
        fruitWriter.writeExact(fruit, new Apple());
        fruitWriter.writeExact(fruit, new Fruit());
//        fruitWriter.writeExact(apples, new Apple()); // Compile Error

        Writer<Apple> appleWriter = new Writer<>();
        appleWriter.writeExact(apples, new Apple());
//        appleWriter.writeExact(fruit, new Apple()); // Compile Error
    }

    public static void main(String[] args) {
        f1();
        f2();
    }
}
