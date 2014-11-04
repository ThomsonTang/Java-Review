package generics.coffee;

import utils.Generator;

import java.util.Iterator;
import java.util.Random;

/**
 * Created by Intellij idea.
 *
 * @author Thomson Tang
 */
public class CoffeeGenerator implements Generator<Coffee>, Iterable<Coffee> {
    private Class[] types = {Latte.class, Mocha.class, Cappuccino.class};
    private static Random random = new Random(47);

    private int size;

    public CoffeeGenerator() {
    }

    public CoffeeGenerator(int size) {
        this.size = size;
    }

    @Override public Coffee next() {
        try {
            return (Coffee) types[random.nextInt(types.length)].newInstance();
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    @Override public Iterator<Coffee> iterator() {
        return new CoffeeIterator();
    }

    class CoffeeIterator implements Iterator<Coffee> {
        int count = size;

        @Override public boolean hasNext() {
            return count > 0;
        }

        @Override public Coffee next() {
            count--;
            return CoffeeGenerator.this.next();
        }
    }

    public static void main(String[] args) {
        CoffeeGenerator gen = new CoffeeGenerator();
        for (int i = 0; i < 5; i++) {
            System.out.println(gen.next());
        }

        for (Coffee c : new CoffeeGenerator(5)) {
            System.out.println(c);
        }
    }
}
