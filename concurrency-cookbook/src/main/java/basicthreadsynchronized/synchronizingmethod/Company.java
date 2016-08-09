package basicthreadsynchronized.synchronizingmethod;

/**
 * This class simulates a company and uses the {@link Account#addAmount(double)} method of the
 * {@code Account} class to increment the balance of the account. This class must implement the
 * {@link Runnable} interface to be executed as thread.
 *
 * @author Thomson Tang
 * @version Created ：2016-8/9/16-15:29
 */
public class Company implements Runnable {
    private Account account;

    public Company(Account account) {
        this.account = account;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            account.addAmount(1000);
        }
    }
}
