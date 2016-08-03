package containerdepth;

import net.mindview.util.CollectionData;
import net.mindview.util.RandomGenerator;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Thomson Tang
 * @version 1.0-SNAPSHOT
 * @version 9/5/13
 */
public class CollectionDataGeneration {
    public static void main(String[] args) {
        System.out.println(new ArrayList<String>(
                CollectionData.list(new RandomGenerator.String(9), 10)
        ));

        System.out.println(new HashSet<Integer>(
                new CollectionData<Integer>(
                        new RandomGenerator.Integer(), 10)
        ));
    }
}
