package sorting;

/**********************************************************************
 * sorting/Quick.java
 *
 * QuickSort is a divide-and-conquer method for sorting. It works by 
 * partitioning an array into two parts, then sorting the parts in-
 * dependently.
 * The crux of the method is the partitioning process, which rearranges
 * the array to make the following three conditions hold:
 *  * The entry a[j] is in its final position in the array, for some j.
 *  * No entry in a[low] through a[j-1] is greater than a[j].
 *  * No entry in a[j+1] through a[high] is less than a[j].
 *
 * ********************************************************************/

public class Quick {

    public static void sort(Comparable[] a, int low, int high) {
        if (low >= high) return;
        int j = partition(a, low, high);
        sort(a, low, j - 1);
        sort(a, j + 1, high);
    }

    private static int partition(Comparable[] a, int low, int high) {
        int i = low;
        int j = high + 1;
        Comparable v = a[low];

        while (true) {

            while (less(a[++i], v)) {
                if (i == high) break;
            }

            while (less(v, a[--j])) {
                if (j == low) break;
            }

            if (i >= j) {
                break;
            }

            exchange(a, i, j);
        }
        exchange(a, low, j);
        return j;
    }

    private static boolean less(Comparable a, Comparable b) {
        return (a.compareTo(b) < 0);
    }

    private static void exchange(Object[] a, int i, int j) {
        Object temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        Integer[] a = {1, 2, 5, 8, 3, 0, 9, 7, 4, 6};
        Quick.sort(a, 0, a.length - 1);

        for (int i = 0; i < a.length - 1; i++) {
            System.out.println(a[i]);
        }
    }
}
