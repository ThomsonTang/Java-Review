package generic.mystery_of_erasure;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * 在程序运行期，我们无法获知特定泛型实例的真实的类型参数。
 *
 * @author Thomson Tang
 * @version Created ：2016-30/09/2016-20:42
 */
class Frob {
}

class Fnorkle {
}

class Quark<Q> {
}

class Particle<POSITION, MOMENTUM> {
}

public class LostInformationTest {
    List<Frob> list;
    Map<Frob, Fnorkle> map;
    Quark<Fnorkle> quark;
    Particle<Long, Double> particle;

    @Before
    public void prepare() {
        list = new ArrayList<>();
        map = new HashMap<>();
        quark = new Quark<>();
        particle = new Particle<>();
    }

    @Test
    public void testLost() {
        assertEquals("[E]", Arrays.toString(list.getClass().getTypeParameters()));
        assertEquals("[K, V]", Arrays.toString(map.getClass().getTypeParameters()));
        assertEquals("[Q]", Arrays.toString(quark.getClass().getTypeParameters()));
        assertEquals("[POSITION, MOMENTUM]", Arrays.toString(particle.getClass().getTypeParameters()));
    }
}
