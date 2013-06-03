package enumerated;

/**
 * Created with IntelliJ IDEA.
 * User: tangguike
 * Date: 5/30/13
 * Time: 10:45 PM
 * To change this template use File | Settings | File Templates.
 */
import static net.mindview.util.Print.*;

enum Shrubbery {GROUD,CARWLING, HANGING}

public class EnumClass {
   public static void main(String[] args) {
       for (Shrubbery s : Shrubbery.values()) {
           print(s + " ordinal: " + s.ordinal());
           printnb(s.compareTo(Shrubbery.CARWLING) + " ");
           printnb(s.equals(Shrubbery.CARWLING) + " ");
           print(s == Shrubbery.CARWLING);
           print(s.getDeclaringClass());
           print(s.name());
           print("-----------------------");
       }
   }
}
