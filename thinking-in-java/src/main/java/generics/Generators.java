package generics;

import generics.coffee.Coffee;
import generics.coffee.CoffeeGenerator;
import utils.Generator;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Intellij idea.
 *
 * @author Thomson Tang
 */
public class Generators {
    public static <T> Collection<T> fill(Collection<T> collection, Generator<T> generator, int n) {
        for (int i = 0; i < n; i++) {
            collection.add(generator.next());
        }
        return collection;
    }

    public static void main(String[] args) {
        Collection<Coffee> coffees = fill(new ArrayList<>(), new CoffeeGenerator(), 3);
        for (Coffee coffee : coffees) {
            System.out.println(coffee);
        }

        Collection<Integer> fnumbers = fill(new ArrayList<>(), new Fibonacci(), 5);
        for (Integer number : fnumbers) {
            System.out.println(number);
        }
    }
}
