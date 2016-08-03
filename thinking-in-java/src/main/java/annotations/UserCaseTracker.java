package annotations;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Thomson Tang
 * @version 1.0-SNAPSHOT
 * @version 9/2/13
 */
public class UserCaseTracker {
    public static void trackUserCases(List<Integer> userCases, Class<?> cl) {
        for (Method m : cl.getDeclaredMethods()) {
            UserCase userCase = m.getAnnotation(UserCase.class);
            if (userCase != null) {
                System.out.println("Found user case: " + userCase.id() + " " + userCase.description());
                userCases.remove(new Integer(userCase.id()));
            }
        }

        for (int i : userCases) {
            System.out.println("Warning: miss user case-" + i);
        }
    }

    public static void main(String[] args) {
        List<Integer> useCases = new ArrayList<Integer>();
        Collections.addAll(useCases, 47, 48, 49, 50);
        trackUserCases(useCases, PasswordUtil.class);
    }
}
