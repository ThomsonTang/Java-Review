package effective.mthdcommon2allobjs.item9;

import java.util.HashMap;
import java.util.Map;

/**
 * Always override hashCode when you override equals
 *
 * @author Thomson Tang
 * @version 1.0-SNAPSHOT
 * @date 7/5/13
 */
public final class PhoneNumber implements Comparable<PhoneNumber> {
    private final short areaCode;
    private final short prefix;
    private final short lineNumber;

    private volatile int hashCode;

    public PhoneNumber(int areaCode, int prefix, int lineNumber) {
        rangeCheck(areaCode, 999, "area code");
        rangeCheck(prefix, 999, "prefix");
        rangeCheck(lineNumber, 9999, "lineNumber");
        this.areaCode = (short) areaCode;
        this.prefix = (short) prefix;
        this.lineNumber = (short) lineNumber;
    }

    public static void rangeCheck(int arg, int max, String name) {
        if (arg < 0 || arg > max) {
            throw new IllegalArgumentException(name + ": " + arg);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PhoneNumber)) return false;

        PhoneNumber that = (PhoneNumber) o;
        return that.lineNumber == lineNumber
                && that.prefix == prefix
                && that.areaCode == areaCode;
    }

//    @Override
//    public int hashCode() {
//        return 42;
//    }

    @Override
    public int hashCode() {
        int result = hashCode;
        if (result == 0) {
            result = 17;
            result = 31 * result + areaCode;
            result = 31 * result + prefix;
            result = 31 * result + lineNumber;
            hashCode = result;
        }
        return result;
    }

    public static void main(String[] args) {
        Map<PhoneNumber, String> map = new HashMap<PhoneNumber, String>();
        map.put(new PhoneNumber(707, 867, 5309), "tim");

        System.out.println("Get person: " + map.get(new PhoneNumber(707, 867, 5309)));
    }

    @Override
    public int compareTo(PhoneNumber o) {
        //compare areaCode
        int areaCodeDiff = areaCode - o.areaCode;
        if (areaCodeDiff != 0)
            return areaCodeDiff;

        //areaCode area equal, compare prefix
        int prefixDiff = prefix - o.prefix;
        if (prefixDiff != 0)
            return prefixDiff;

        //areaCode and prefix are equal, compare line number
        return lineNumber - o.lineNumber;
    }
}
