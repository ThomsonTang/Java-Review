package holding;

import java.util.*;

/**
 * Adding groups of elements to Collection objects.
 *
 * @author ThomsonTang
 * @date 12/27/11
 */
public class AddingGroups {
    public static void main(String[] args) {
        // use another Collection to initialize a Collection
        Collection<Integer> collection = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        Integer[] moreInts = {6, 7, 8, 9, 10};

        // Collections.addAll() method is much faster and flexible than collection.addAll() method,
        // the former is just easy to construct the Collection with no elements and use the variable
        // argument lists, however, the latter only take an argument of another Collection object.
        collection.addAll(Arrays.asList(moreInts));
        Collections.addAll(collection, 11, 12, 13, 14, 15);
        Collections.addAll(collection, moreInts);

        //It's possible to use the output of Arrays.asList() directly, as a List, but the underlying
        //representation in this case is the array, which cannot be resized.
        List<Integer> list = Arrays.asList(16, 17, 18, 19, 20);
        list.set(1, 99);
        //list.add(21); //can't use add() or delete()

        for (Integer i : list) {
            System.out.print(i + ", ");
        }
        System.out.println();
    }
}
