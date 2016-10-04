package generics.myster_of_erasure;

import java.util.ArrayList;
import java.util.List;

/**
 * <h1>the action of the boundaries</h1>
 *
 * make a list of array with generics
 *
 * @author Thomson Tang
 * @version Created ：2016-03/10/2016-19:30
 */
public class ListMaker<T> {

    List<T> create() {
        return new ArrayList<>();
    }

    List<T> create(T t, int n) {
        List<T> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            result.add(t);
        }
        return result;
    }
}
