package effective.concurrency.item66;

import java.util.concurrent.TimeUnit;

/**
 * Synchronize access to share mutable data.
 * <p/>
 * Synchronization is required for reliable communication between threads as well as for mutual exclusion.
 * In fact, synchronization has no effect unless both read and write operations are synchronized.
 * <p/>
 * The action of the synchronized methods in this class would be atomic even without synchronized.
 * In other words, the synchronization on these methods is used solely for its communication effects, not for mutual exclusion.
 *
 * @author ThomsonTang
 * @version 7/16/14
 */
public class StopThreadWithSynchronized {
	public static boolean stopRequested;

	private static synchronized void requestStop() {
		stopRequested = true;
	}

	private static synchronized boolean stopRequested() {
		return stopRequested;
	}

	public static void main(String[] args) throws InterruptedException {
		Thread backgroudThread = new Thread(new Runnable() {
			@Override
			public void run() {
				int i = 0;
				while (!stopRequested()) {
					i++;
				}
			}
		});
		backgroudThread.start();

		TimeUnit.SECONDS.sleep(1);
		requestStop();
	}
}
/* the result:
 * the program terminates in about one second.
 */
