package basicthreadsynchronized.usingConditions;

/**
 * This class implement the producer of the example.
 *
 * @author Thomson Tang
 * @version Created ：2016-8/16/16-18:09
 */
public class Producer implements Runnable {
    private EventStorage storage;

    public Producer(EventStorage storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            storage.set();
        }
    }
}
