package effective.creatingdestroyingobjs.item1;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Consider static factory methods instead of constructors.
 *
 * @author Thomson Tang
 * @since 12-8-31
 */
public class StaticFactoryMethod {
    private String methodId;
    private String methodName;

    Map<String, List<String>> map = new HashMap<String, List<String>>();

    private StaticFactoryMethod(String id, String name) {
        this.methodId = id;
        this.methodName = name;
    }

    public static StaticFactoryMethod newInstance(String id, String name) {
        return new StaticFactoryMethod(id, name);
    }

    public static <K, V> HashMap<K, V> newMapInstance() {
        return new HashMap<K, V>();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (!(obj instanceof StaticFactoryMethod))
            return false;
        StaticFactoryMethod method = (StaticFactoryMethod) obj;
        return methodId.equals(method.methodId) && methodName.equals(method.methodName);
    }


    @Override
    public int hashCode() {
        int result = 17 + methodId.hashCode();
        result = 31 * result + methodName.hashCode();
        return result;
    }
}
