package effective.concurrency.item66;

import java.util.concurrent.TimeUnit;

/**
 * Synchronized access to share mutable data.
 *
 * @author ThomsonTang
 * @version 7/17/14
 */
public class StopThreadWithVolatile {
	private static volatile boolean stopRequested;

	public static void main(String[] args) throws InterruptedException {
		Thread backgroundThread = new Thread(new Runnable() {
			@Override
			public void run() {
				int i = 0;
				while (!stopRequested) {
					i++;
				}
			}
		});

		backgroundThread.start();

		TimeUnit.SECONDS.sleep(1);
		stopRequested = true;
	}
}
