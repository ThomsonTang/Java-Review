package enumerated;

import net.mindview.util.OSExecute;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Set;
import java.util.TreeSet;

import static net.mindview.util.Print.print;
import static net.mindview.util.Print.printnb;

/**
 * Analyzing enums using reflection.
 *
 * All enum classes are created for you by the compiler and extend the {@code Enum} class. But there is no
 * {@code values()} method in it.
 *
 * the {@code values()} is a static method that is added by the compiler, and the {@code valueOf()} is also
 * added in the process of creating the enum. Be careful, there is also a {@code valueOf()} that is part of
 * the {@code Enum} class, but that method has two arguments and the added method only has one. They are different.
 * However, the use of the {@code Set} method is only looking at method names, and not signatures, so it treated
 * them as same.
 *
 * In the output, you can see that {@code Explore} has been made {@code final} by the compiler, so you cannot
 * inherit from an {@code enum}.
 *
 * @author Thomson Tang
 * @date 6/3/13
 */
enum Explore {HERE, THERE}

public class Reflection {
    public static Set<String> analyze(Class<?> enumClass) {
        print("---------Analyzing " + enumClass + "---------");

        print("Interfaces: ");
        for (Type type : enumClass.getGenericInterfaces())
            print(type);

        print("Base: " + enumClass.getSuperclass());

        print("Methods: ");
        Set<String> methods = new TreeSet<String>();
        for (Method method : enumClass.getMethods())
            methods.add(method.getName());
        print(methods);

        return methods;
    }

    public static void main(String[] args) {
        Set<String> exploreMethods = analyze(Explore.class);
        Set<String> enumMethods = analyze(Enum.class);

        print("Explore.containsAll(Enum)? " + exploreMethods.containsAll(enumMethods));

        printnb("Explore.removeAll(Enum): ");
        exploreMethods.removeAll(enumMethods);
        print(exploreMethods);

        // Decompile the code for the enum:
        OSExecute.command("javap enumerated.Explore");
    }
}
/* Output:
---------Analyzing class enumerated.Explore---------
Interfaces:
Base: class java.lang.Enum
Methods:
[compareTo, equals, getClass, getDeclaringClass, hashCode, name, notify, notifyAll, ordinal, toString, valueOf, values, wait]
---------Analyzing class java.lang.Enum---------
Interfaces:
java.lang.Comparable<E>
interface java.io.Serializable
Base: class java.lang.Object
Methods:
[compareTo, equals, getClass, getDeclaringClass, hashCode, name, notify, notifyAll, ordinal, toString, valueOf, wait]
Explore.containsAll(Enum)? true
Explore.removeAll(Enum): [values]
Compiled from "Reflection.java"
final class enumerated.Explore extends java.lang.Enum<enumerated.Explore> {
  public static final enumerated.Explore HERE;
  public static final enumerated.Explore THERE;
  public static enumerated.Explore[] values();
  public static enumerated.Explore valueOf(java.lang.String);
  static {};
}
 */
