package algorithms;

import java.util.Arrays;

/**
 * 求数组的子数组之和的最大值
 *
 * @author ThomsonTang
 * @version 1/5/14
 */
public class SubArrayMaxSum {
    public static int maxSum(int[] array) {
        int max = 0;
        int sum;

        int n = array.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                sum = 0;
                for (int k = i; k <= j; k++) {
                    sum += array[k];
                }
                if (sum > max)
                    max = sum;
            }
        }
        return max;
    }

    public static int maxSum2(int[] array) {
        int max = 0;
        int sum;
        int n = array.length;

        for (int i = 0; i < n; i++){
            sum = 0;
            for (int j = i; j < n; j++) {
                sum += array[j];
                if (sum > max)
                    max = sum;
            }
        }
        return max;
    }

    private static Long getRouteSize(int n) {
        Long[][] a = new Long[n + 1][n + 1];// 注意int长度不够
        for (int i = 0; i <= n; i++) {
            Arrays.fill(a[i], 0L);
        }
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if (i == 0 && j != 0) {
                    a[i][j] = a[i][j - 1];
                } else if (i != 0 && j == 0) {
                    a[i][j] = a[i - 1][j];
                } else if (i == 0 && j == 0) {
                    a[i][j] = 1L;
                } else {
                    a[i][j] = a[i - 1][j] + a[i][j - 1];
                }
            }
        }
        return a[n][n];
    }

    public static void main(String[] args) {
        int[] a = {1, -2, 3, 5, -3, 2};
        int[] b = {0, -2, 3, 5, -1, 2};

//        System.out.println("result of a: " + maxSum(a));
//        System.out.println("result of b: " + maxSum(b));
//        System.out.println("result of a: " + maxSum2(a));
//        System.out.println("result of b: " + maxSum2(b));
        System.out.println("result: " + getRouteSize(4));
    }
}
