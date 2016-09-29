package generic;

import generics.ThreeTuple;
import generics.TwoTuple;

/**
 * 元组的使用
 *
 * 通过使用元组可以在某个方法里返回多个元素
 *
 * @author Thomson Tang
 * @version Created ：2016-28/09/2016-08:44
 */
class Spurs {
}

public class TupleTest {
    static TwoTuple<String, Integer> f() {
        return new TwoTuple<>("tim duncan", 21);
    }

    static ThreeTuple<Spurs, String, Integer> g() {
        return new ThreeTuple<>(new Spurs(), "tim duncan", 21);
    }

    public static void main(String[] args) {
        TwoTuple<String, Integer> f = f();
        System.out.print(f);
    }
}
