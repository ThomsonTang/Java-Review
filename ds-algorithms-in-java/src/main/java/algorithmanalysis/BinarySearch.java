package algorithmanalysis;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Thomson Tang
 * @version 1.0-SNAPSHOT
 * @date 8/12/13
 */
public class BinarySearch {

    private static final int NOT_FOUND = -1;

    /**
     * Perform the standard binary search.
     * @param a
     * @param x
     * @param <AnyType>
     * @return
     */
    public static <AnyType extends Comparable<? super AnyType>> int binarySearch(AnyType[] a, AnyType x) {
        int low = 0;
        int high = a.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (a[mid].compareTo(x) < 0) {
                low = mid + 1;
            } else if (a[mid].compareTo(x) > 0) {
                high = mid - 1;
            } else {
                return mid; // Found
            }
        }
        return NOT_FOUND;
    }
}
