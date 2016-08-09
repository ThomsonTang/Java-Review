package basicthreadsynchronized.synchronizingmethod;

/**
 * This class simulates an ATM. It will use the {@link Account#subtractAmount(double)} method to
 * decrement the balance of an account. This class must implement the {@link Runnable} interface to
 * be executed as a thread.
 *
 * @author Thomson Tang
 * @version Created ：2016-8/9/16-15:24
 */
public class Bank implements Runnable {
    private Account account;

    public Bank(Account account) {
        this.account = account;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            account.subtractAmount(1000);
        }
    }
}
