package generics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Intellij idea.
 *
 * @author Thomson Tang
 */
public class GenericVarargs {
    @SafeVarargs public static <T> List<T> makeList(T ... args) {
        List<T> result = new ArrayList<T>();
        Collections.addAll(result, args);
        return result;
    }

    public static void main(String[] args) {
        List<String> list = makeList("A");
        System.out.println(list);
        list = makeList("A", "B", "C");
        System.out.println(list);
    }
}
