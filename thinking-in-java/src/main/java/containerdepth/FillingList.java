package containerdepth;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This example shows two ways to fill a Collection with references to a single object.
 * The first, <code>Collections.nCopies()</code>, creates a <class>List</class> which is
 * passed to the constructor; this fills the <class>ArrayList</class>.
 * <p/>
 * The second, <code>Collections.fill()</code>. The fill() method is made even less useful
 * by the fact that it can only replace elements that are already in the <class>List</class>
 * and will not add new elements.
 *
 * @author Thomson Tang
 * @version 1.0-SNAPSHOT
 * @version 9/4/13
 */
class StringAddress {
    private String s;

    public StringAddress(String s) {
        this.s = s;
    }

    public String toString() {
        return super.toString() + " " + s;
    }
}

public class FillingList {
    public static void main(String[] args) {
        List<StringAddress> list = new ArrayList<StringAddress>(
                Collections.nCopies(4, new StringAddress("Hello"))
        );
        System.out.println(list);

        Collections.fill(list, new StringAddress("World!"));
        System.out.println(list);
    }
}
