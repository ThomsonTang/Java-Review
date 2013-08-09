package algorithmanalysis;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Thomson Tang
 * @version 1.0-SNAPSHOT
 * @date 8/8/13
 */
public class MaxSubsequenceSum {

    public static int maxSubSum1(int[] a) {
        int maxSum = 0;

        for (int i = 0; i < a.length; i++) {
            for (int j = i; j < a.length; j++) {
                int thisSum = 0;
                for (int k = i; k <= j; k++) {
                    thisSum += a[k];
                }

                if (thisSum > maxSum)
                    maxSum = thisSum;
            }
        }
        return maxSum;
    }

    public static int maxSubSum2(int[] a) {
        int maxSum = 0;

        for (int i = 0; i < a.length; i++) {
            int thisSum = 0;
            for (int j = i; j < a.length; j++) {
                thisSum += a[j];
                if (thisSum > maxSum)
                    maxSum = thisSum;
            }
        }
        return maxSum;
    }

    /**
     * Recursive maximum  contiguous subsequence sum algorithm.
     * Find maximum sum in subarray spanning a[left..right]
     * Does not attempt to maintain actual best sequence.
     *
     * @param a
     * @param left
     * @param right
     * @return
     */
    public static int maxSumRec(int[] a, int left, int right) {
        if (left == right) {//Base case
            if (a[left] > 0)
                return a[left];
            else
                return 0;
        }

        int center = (left + right) / 2;
        int maxLeftSum = maxSumRec(a, left, center);
        int maxRightSum = maxSumRec(a, center + 1, right);

        int maxLeftBorderSum = 0, leftBorderSum = 0;
        for (int i = center; i >= left; i--) {
            leftBorderSum += a[i];
            if (leftBorderSum > maxLeftBorderSum)
                maxLeftBorderSum = leftBorderSum;
        }

        int maxRightBorderSum = 0, rightBorderSum = 0;
        for (int i = center + 1; i <= right; i++) {
            rightBorderSum += a[i];
            if (rightBorderSum > maxRightBorderSum)
                maxRightBorderSum = rightBorderSum;
        }

        return max(maxLeftSum, maxRightSum, maxLeftBorderSum + maxRightBorderSum);
    }

    private static int max(int maxLeftSum, int maxRightSum, int i) {
        int max = maxLeftSum;
        if (maxRightSum > max)
            max = maxRightSum;
        if (i > max)
            max = i;
        return max;
    }

    /**
     * Driver for divide-and-conquer maximum contiguous subsequence sum algorithms.
     *
     * @param a
     * @return
     */
    public static int maxSubSum3(int[] a) {
        return maxSumRec(a, 0, a.length - 1);
    }

    /**
     * Linear-time maximum contiguous subsequence sum alg
     * @param a
     * @return
     */
    public static int maxSubSum4(int[] a) {
        int maxSum = 0, thisSum = 0;

        for (int i = 0; i < a.length; i++) {
            thisSum += a[i];
            if (thisSum > maxSum)
                maxSum = thisSum;
            else if (thisSum < 0)
                thisSum = 0;
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, -3, 4, 6, -2, 5, -4, 6, 8, 11, -5, 9, -1, 0, 3};

        System.out.println("the result: " + maxSubSum1(a));
        System.out.println("the result: " + maxSubSum2(a));
        System.out.println("the result: " + maxSubSum3(a));
        System.out.println("the result: " + maxSubSum4(a));

    }
}
