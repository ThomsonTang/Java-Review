package holding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import static net.mindview.util.Print.print;

/**
 * Show the features of List collections.
 *
 * @author ThomsonTang
 * @version 12/27/13
 */
public class ListFeatures {
    public static void main(String[] args) {
        List<String> members = new ArrayList<>(5);
        Collections.addAll(members, "Thomson", "Clover", "Rock", "SweetLisa", "Sky");

        print("members: " + members);

//        members.add("Jeff");
//        print("members: " + members);

//        members.remove(1);
//        members.remove("Jeff");
//        print("members: " + members);

//        for (String s : members) {
////            if ("Clover".equals(s))
////                members.remove(s);
//        }

        Iterator<String> it = members.iterator();
        while (it.hasNext()) {
            String s = it.next();
            if ("Clover".equals(s)) {
//                it.remove();
//                members.remove(s);
                members.add("Flower");
            }
        }
        print("members: " + members);

    }
}
