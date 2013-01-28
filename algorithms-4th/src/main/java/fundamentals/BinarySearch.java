package fundamentals;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Thomson Tang
 * @since 1.0-SNAPSHOT
 */
public class BinarySearch {

    //precondition: a[] is sorted.
    public static int rank(int key, int[] a) {
        int low = 0;
        int high = a.length - 1;
        while (low <= high) {
            // key is in [low..high] or not present.
            int middle = low + (high - low) / 2;
            if (key < a[middle])
                high = middle - 1;
            else if (key > a[middle])
                low = middle + 1;
            else
                return middle;
        }
        return -1;
    }

    public static void main(String[] args) {
    }
}
