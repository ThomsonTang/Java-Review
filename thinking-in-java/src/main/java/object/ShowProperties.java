package object;

/**
 * Created by IntelliJ IDEA.
 * User: tangguike
 * Date: 8/3/12
 * Time: 10:27 AM
 * To change this template use File | Settings | File Templates.
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
