package datastructure;

public class Factorial {

    public static void main(String[] args) {
        int n = 50;

        long begin = System.currentTimeMillis();
        long result = factRecusive(n);
        long end = System.currentTimeMillis();
        System.out.println("the recurion result: " + result + " and time: " + (end - begin));
        
        begin = System.currentTimeMillis();
        result = factLoop(n);
        end = System.currentTimeMillis();
        System.out.println("the loop result: " + result + " and time: " + (end - begin));
    }

    public static long factRecusive(int n) {
        if (n == 0) {
            return 1;
        } else {
            return n * factRecusive(n - 1);
        }
    }

    public static long factLoop(int n) {
        if (n == 0) {
            return 1;
        }

        long sum = 1;
        for (int i = 1; i <= n; i++) {
            sum *= i;
        }
        return sum;
    }
}
