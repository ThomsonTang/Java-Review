package utils;

import java.lang.reflect.Method;
import java.util.*;

/**
 * Created by Intellij idea.
 *
 * @author Thomson Tang
 */
public class ContainerMethodDifferences {
    static Set<String> methodSet(Class<?> type) {
        Set<String> result = new TreeSet<>();
        for (Method method : type.getMethods()) {
            result.add(method.getName());
        }
        return result;
    }

    static void interfaces(Class<?> type) {
        System.out.println(String.format("Interfaces in %s:", type.getSimpleName()));
        List<String> result = new ArrayList<>();
        for (Class<?> c : type.getInterfaces()) {
            result.add(c.getSimpleName());
        }
        System.out.println(result);
    }

    static Set<String> object = methodSet(Object.class);

    static {
        object.add("clone");
    }

    static void difference(Class<?> subset, Class<?> superset) {
        System.out.println(String.format("%s extends %s, adds: ", subset.getSimpleName(), superset.getSimpleName()));
        Set<String> comp = Sets.difference(methodSet(superset), methodSet(subset));
        comp.removeAll(object);
        System.out.println(comp);
        interfaces(superset);
    }

    public static void main(String[] args) {
        System.out.println(String.format("Collection: %s", methodSet(Collection.class)));
        interfaces(Collection.class);

        difference(Set.class, Collection.class);
        difference(HashSet.class, Set.class);
        difference(LinkedHashSet.class, HashSet.class);
    }
}
