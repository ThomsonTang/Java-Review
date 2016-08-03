package effective.generic.item23;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Don't use raw type.
 * It'll lose type safety if use raw type like List, but not if use a parameterized type like List<Object>.
 *
 * @author Thomson Tang
 * @version 1.0-SNAPSHOT
 * @version 7/25/13
 */
public class RawTypeAndGenericType {

    public static void main(String[] args) {
        List<String> strings = new ArrayList<String>();
        unsafeAdd(strings, new Integer(32));
        String result = strings.get(0); //Compile-generated cast
    }

    //    private static void unsafeAdd(List list, Object obj) {
//        list.add(obj);
//    }

//    private static void unsafeAdd(List<Object> list, Object obj) {
//        list.add(obj);
//    }

    private static void unsafeAdd(List<String> list, Integer obj) {
        list.add(obj.toString());
    }

    // Unbounded wildcard type - type safe and flexible.
    //if you want use generic type but you don't know or care the actual type parameter is, you can use question
    //mark instead.
    static int numElementsInCommon(Set<?> s1, Set<?> s2) {
        int result = 0;
        for (Object o1 : s1)
            if (s2.contains(o1))
                result++;
        return result;
    }
}
