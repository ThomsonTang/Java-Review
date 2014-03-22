package threadmanagement;

/**
 * Interrupting a thread.
 *
 * Java provides the interruption mechanism to indicate to a thread that we want to finish it.
 * The Thread class has an attribute that store a boolean value indicating whether the thread
 * has been interrupted or not. When you call the interrupt() method of a thread, you set that
 * attribute to true. The isInterrupted() method only returns the value of that attribute.
 *
 * User: ThomsonTang
 * Date: 11/13/13
 */
public class PrimeGenerator extends Thread {

    @Override
    public void run() {
        long number = 1L;
        while (true) {
            if (isPrime(number)) {
                System.out.printf("Number %d is Prime\n", number);
            }

            if (isInterrupted()) {
                System.out.println("the Prime Generator has been interrupted");
                return;
            }
            number++;
        }
    }

    private boolean isPrime(long number) {
        if (number <= 2) {
            return true;
        }

        for (long i = 2; i < number; i++) {
            if ((number % i) == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Thread task = new PrimeGenerator();
        task.start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        task.interrupt();
    }
}
