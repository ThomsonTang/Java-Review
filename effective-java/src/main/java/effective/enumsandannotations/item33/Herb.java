package effective.enumsandannotations.item33;

import java.util.EnumMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Use EnumMap instead of ordinal indexing
 *
 * @author Thomson Tang
 * @version 1.0-SNAPSHOT
 * @date 8/29/13
 */
public class Herb {
    public enum Type {ANNUAL, PERENNIAL, BIENNIAL}

    public final String name;
    public final Type type;

    Herb(String name, Type type) {
        this.name = name;
        this.type = type;
    }

    @Override
    public String toString() {
        return name;
    }

    public static void main(String[] args) {
        /**********************************************************************
         * Using ordinal() to index an array --- Don't do this!
         *
         * Because arrays are not compatible with generics, the problem requires
         * an unchecked cast and will not compile cleanly. Because the array does
         * not know what its index represents, you have to label the output manually.
         *
         * The most serious problem with this technique is that when you access an
         * array that is indexed by an enum's ordinal, it is your responsibility to
         * use the correct int value, ints does not provide the type safety of enums.
         ***********************************************************************/
        Herb[] garden = {new Herb("tomato", Type.ANNUAL), new Herb("tree", Type.PERENNIAL), new Herb("other", Type.BIENNIAL)};
//
//        Set<Herb>[] herbsByType = new Set[Type.values().length];
//        for (int i = 0; i < herbsByType.length; i++) {
//            herbsByType[i] = new HashSet<Herb>();
//        }
//
//        for (Herb h : garden) {
//            herbsByType[h.type.ordinal()].add(h);
//        }
//
//        for (int i = 0; i < herbsByType.length; i++) {
//            System.out.printf("%s: %s%n", Herb.Type.values()[i], herbsByType[i]);
//        }


        /***************************************************************************
         * Using an EnumMap to associate data with an enum.
         *
         * Luckily, there is a much better way to achieve the same effect. The array is
         * effectively serving as a map from the enum to a value, so you might as well
         * use a Mpa. There is a very fast Map implementation designed for use with enum
         * keys, knows as java.util.EnumMap.
         ***************************************************************************/
        Map<Type, Set<Herb>> herbsByType = new EnumMap<Type, Set<Herb>>(Herb.Type.class);
        for (Herb.Type t : Herb.Type.values())
            herbsByType.put(t, new HashSet<Herb>());
        for (Herb h : garden)
            herbsByType.get(h.type).add(h);
        System.out.println(herbsByType);

    }
}
