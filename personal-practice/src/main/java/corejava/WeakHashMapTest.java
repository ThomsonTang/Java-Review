package corejava;

import java.util.Map;
import java.util.HashMap;
import java.util.WeakHashMap;
import java.util.Iterator;

public class WeakHashMapTest {
    public static void main(String[] args) throws Exception {
        String a = new String("a");
        String b = new String("b");

        Map map = new HashMap();
        map.put(a, "aaa");
        map.put(b, "bbb");

        Map weakMap = new WeakHashMap();
        weakMap.put(a, "aaa");
        weakMap.put(b, "bbb");

        map.remove(a);

//        a = null;
//        b = null;

        System.gc();

        Iterator i = map.entrySet().iterator();
        while (i.hasNext()) {
            Map.Entry en = (Map.Entry)i.next();
            System.out.println("map: " + en.getKey() + ":" + en.getValue());
        }

        Iterator it = weakMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry en = (Map.Entry)it.next();
            System.out.println("weakmap: " + en.getKey() + ":" + en.getValue());
        }
    }
}
