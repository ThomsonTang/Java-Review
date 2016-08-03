package containerdepth;

import net.mindview.util.*;

import java.util.Iterator;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Thomson Tang
 * @version 1.0-SNAPSHOT
 * @version 9/5/13
 */
class Letters implements Generator<Pair<Integer, String>>, Iterable<Integer> {

    private int size = 9;
    private int number = 1;
    private char letter = 'A';

    @Override
    public Pair<Integer, String> next() {
        return new Pair<Integer, String>(number++, "" + letter++);
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return number < size;
            }

            @Override
            public Integer next() {
                return number++;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }
}

public class MapDataTest {
    public static void main(String[] args) {
        // Pair Generator:
        System.out.println(MapData.map(new Letters(), 11));

        // Two separate generator
        System.out.println(MapData.map(new CountingGenerator.Character(), new RandomGenerator.String(3), 8));

        // A key generator and a single value
        System.out.println(MapData.map(new CountingGenerator.Character(), "value", 6));

        // An Iterable and a value generator
        System.out.println(MapData.map(new Letters(), new RandomGenerator.String(3)));

        // An Iterable and a single value
        System.out.println(MapData.map(new Letters(), "Pop"));
    }

}
