package operators;

import static net.mindview.util.Print.print;

/**
 * Created by IntelliJ IDEA.
 * User: tangguike
 * Date: 8/11/12
 * Time: 9:27 PM
 * To change this template use File | Settings | File Templates.
 */
class Letter {
    char c;
    float fl = 11.11f;
     String str = "tgk";
}

public class PassObject {
    static void f(Letter y, String str) {
        y.c = 'z';
        y.fl = 21.21f;
        y.str = "newstr";
        str = "newtest";
    }
    public static void main(String[] args) {
        Letter x = new Letter();
        x.c = 'a';
        x.fl = 12.12f;
        x.str = "str";
        String str = "test";
        print("x.c ==== " + x.c);
        print("x.fl ==== " + x.fl);
        print("x.str ==== " + x.str);
        print("str ==== " + str);
        f(x, str);
        print("x.c ==== " + x.c);
        print("x.fl ==== " + x.fl);
        print("x.str ==== " + x.str);
        print("str ==== " + str);
    }
}
