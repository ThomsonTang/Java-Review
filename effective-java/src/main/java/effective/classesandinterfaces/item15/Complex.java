package effective.classesandinterfaces.item15;

import java.math.BigInteger;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Thomson Tang
 * @version 8/1/13
 */
public class Complex {
    private final double re;
    private final double im;

    private Complex(double re, double im) {
        this.re = re;
        this.im = im;
    }

    public static Complex valueOf(double re, double im) {
        return new Complex(re, im);
    }

    public static Complex valueOfPolar(double r, double theta) {
        return new Complex(r * Math.cos(theta), r * Math.sin(theta));
    }

    public static BigInteger safeInstance(BigInteger val) {
        if (val.getClass() != BigInteger.class) {
            return new BigInteger(val.toByteArray());
        }
        return val;
    }
}
