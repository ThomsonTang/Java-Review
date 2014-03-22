package corejava;

/**
 * Created with IntelliJ IDEA.
 *
 * @author ThomsonTang
 * @version ${VERSION}
 * @date 2/13/14
 */
public class TestMain {

    public static void say(String s) {
        s = s + "b";
    }

    static String inverseSentence(String in, String sep) {
       String[] ins = in.split(sep);
        StringBuilder sb = new StringBuilder();
        for (int i = ins.length-1; i >= 0; i--) {
           sb.append(ins[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String in = "I love the game";
        System.out.println(inverseSentence(in, " "));
    }
}
