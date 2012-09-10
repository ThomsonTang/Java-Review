package operators;

/**
 * Created by IntelliJ IDEA.
 * User: tangguike
 * Date: 8/3/12
 * Time: 4:22 PM
 * To change this template use File | Settings | File Templates.
 */
public class AutoInc {
    int i;
    public float getNum() {
        return 3.0f;
    }
    
    public static void main(String[] args) {
        String str = new String("string");
        StringBuffer strBuf= new StringBuffer("stringbuffer");
        strMethod(str);
        bufMethod(strBuf);
        System.out.println(str);
        System.out.println(strBuf);
        System.out.println(3|4);
    }
    
    public static void strMethod(String s){
        s = new String("new String");
    }
    
    public static void bufMethod(StringBuffer strBuf) {
        strBuf = new StringBuffer("new StringBuffer");
    }
}
