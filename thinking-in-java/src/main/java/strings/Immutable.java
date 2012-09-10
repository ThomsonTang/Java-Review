package strings;

import static net.mindview.util.Print.*;

/**
 * 1.All string literals are implemented as a instance of <code>String</code> class, such as "abc".
 * 2.Objects of the <code>String</code> class are immutable.
 *   Strings are constant, their values can't be changed after they are created.
 * 3.Every method that appears to modify a String actually creates and returns a brand
 *   new String object containing the modification. The original String is left untouched.
 * 4.Because String objects are immutable, they can be shared.
 * 5.A String has an arrays of characters. For example:
 * <p><blockquote><pre>
 *     String str = "abc";
 * </pre></blockquote><p>
 * is equivalent to:
 * <p><blockquote><pre>
 *     char data[] = {'a', 'b', 'c'};
 *     String str = new String(data);
 * </pre></blockquote><p>
 *
 * User: tangguike
 * Date: 8/11/12
 */
public class Immutable {
    public static String upCase(String s) {
        return s.toUpperCase();
    }
    
    public static void main(String[] args) {
        String q = "hello";
        print(q);
        String qq = upCase(q);
        print(qq);
        print(q);
    }
}
