package object;

import java.util.Stack;

/**
 * Created by IntelliJ IDEA.
 * User: ThomsonTang
 * Date: 8/3/12
 * Time: 10:27 AM
 */
public class ShowProperties {
    public static void main(String[] args) {
        System.getProperties().list(System.out);
        System.out.println(System.getProperty("user.name"));
        System.out.println(
                System.getProperty("java.library.path")
        );
    }
}
