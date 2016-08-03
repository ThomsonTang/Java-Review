package holding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Arrays.asList() makes its best guess about type.
 *
 * @author ThomsonTang
 * @version 12/27/11
 */
class Snow{}
class Powder extends Snow {}
class Heavily extends Powder {}
class Light extends Powder {}
class Crusty extends Snow {}
class Slush extends Snow {}

public class AsListInference {

    public static void main(String[] args) {
        List<Snow> snow1 = Arrays.asList(new Powder(), new Crusty(), new Slush());

        //Won't compile
        // found: java.util.List<Powder>, required: java.util.List<Snow>
        //List<Snow> snow2 = Arrays.asList(new Heavily(), new Light());

        // Collections.addAll() doesn't get confused.
        List<Snow> snow3 = new ArrayList<>();
        Collections.addAll(snow3, new Light(), new Heavily());

        // Give a hint using an explicit type argument specification.
        List<Snow> snow4 = Arrays.<Snow>asList(new Light(), new Heavily());
    }
}
