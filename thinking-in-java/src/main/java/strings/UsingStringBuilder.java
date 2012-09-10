package strings;

import java.util.Random;

/**
 * Created by IntelliJ IDEA.
 * User: tangguike
 * Date: 8/11/12
 * Time: 7:28 PM
 * To change this template use File | Settings | File Templates.
 */
public class UsingStringBuilder {
    public static Random random = new Random(47);

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        for(int i = 0; i < 25; i++) {
            result.append(random.nextInt(100));
            result.append(", ");
        }
        result.delete(result.length()-2, result.length());
        result.append("]");
        return result.toString();
    }
    
    public static void main(String[] args) {
        UsingStringBuilder usb = new UsingStringBuilder();
        System.out.println(usb);
    }
}
