package effective.creatingdestroyingobjs.item6;

import java.util.EmptyStackException;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Thomson Tang
 * @version 1.0-SNAPSHOT
 * @version 7/23/13
 */
public class ObsoleteObjRefEliminated {
    private Object[] elements = new Object[5];
    private int size = elements.length;

    public ObsoleteObjRefEliminated() {
        this.elements = new Object[5];

        //hard coding
        elements[0] = "my";
        elements[1] = "name";
        elements[2] = "is";
        elements[3] = "thomson";
        elements[4] = "tang";

        //print
        for (int i = 0; i < elements.length; i++) {
            System.out.println(elements[i]);
        }

        System.out.println("\nElement in index 4, before pop");
        System.out.println(elements[4]);

        System.out.println("\nThe element which is popped");
        System.out.println(pop());

        System.out.println("\nElement in index 4, after null out");
        System.out.println(elements[4]);
    }

    public void push(Object o) {
        elements[size++] = o;
    }

    public Object pop() {
        if (size == 0)
            throw new EmptyStackException();
        Object result = elements[--size];
        //Eliminating obsolete object reference.
//        elements[size] = null;
        return result;
    }

    public static void main(String[] args) {
        new ObsoleteObjRefEliminated();
    }
}
