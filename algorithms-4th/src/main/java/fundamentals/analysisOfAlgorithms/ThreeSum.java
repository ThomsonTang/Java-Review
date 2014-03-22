package fundamentals.analysisOfAlgorithms;

/**
 * Count the number of triples in a file of N integers that sum to 0.
 *
 * @author ThomsonTang
 * @version ${VERSION}
 * @date 12/20/13
 */
public class ThreeSum {
    public static int count(int[] a) {
        int N = a.length;
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                for (int k = j + 1; k < N; k++) {
                    if (a[i] + a[j] + a[k] == 0) {
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        int N = 10;
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                for (int k = j + 1; k < N; k++) {
                        cnt++;
                }
            }
        }
        System.out.println("the result: " + cnt);
    }
}
