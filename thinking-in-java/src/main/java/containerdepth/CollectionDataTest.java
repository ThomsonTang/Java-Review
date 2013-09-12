package containerdepth;

import net.mindview.util.CollectionData;
import net.mindview.util.Generator;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Thomson Tang
 * @version 1.0-SNAPSHOT
 * @date 9/5/13
 */
class Government implements Generator<String> {
    String[] foundation = ("strange women lying in pounds distributing swords is no basis for a system of government").split(" ");
    private int index;

    public String next() {
        return foundation[index++];
    }
}

public class CollectionDataTest {
    public static void main(String[] args) {
        Set<String> set = new LinkedHashSet<String>(
                new CollectionData<String>(new Government(), 15)
        );

        set.addAll(CollectionData.list(new Government(), 15));
        System.out.println(set);
    }
}
