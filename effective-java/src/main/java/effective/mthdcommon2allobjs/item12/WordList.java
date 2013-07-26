package effective.mthdcommon2allobjs.item12;

import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

/**
 * Consider implementing Comparable
 *
 * @author Thomson Tang
 * @version 1.0-SNAPSHOT
 * @date 7/25/13
 */
public class WordList {

    public static void main(String[] args) {
        String[] arr = {"I", "want", "what", "I", "want", "when", "I", "wanted"};
        Set<String> s = new TreeSet<String>();
        Collections.addAll(s, arr);
        System.out.println(s);
    }
}
