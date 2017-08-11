package com.thomson.effective.concurrency.item66;

import java.util.concurrent.TimeUnit;

/**
 * Synchronized access to share mutable data
 * <p/>
 * This is a broken program that consider a task of stopping one thread from another.
 * we know that there is a method called Thread.stop in the libraries, but because it
 * is inherently unsafe, we do not ues the method which was deprecated long ago.
 * <p/>
 * A recommended way to stop one thread from another is to have the first thread poll
 * a boolean field that is initially false but can be set to true by the second thread
 * to indicate that first thread is to stop itself. Because reading and writing a boolean
 * field is atomic, some programmers dispense with synchronization when accessing the field.
 * <p/>
 * The problem is that in the absence of synchronization, there is no guarantee as to when,
 * if ever, the background thread will see the change in the value of stopRequested that was
 * made by the main thread. In the absence of synchronization, it's quite acceptable for the
 * JVM to transform this code:
 * <p/>
 * while (!stopRequested) {
 * i++;
 * }
 * <p/>
 * into this code:
 * <p/>
 * if (!stopRequested) {
 * while(true) {
 * i++
 * }
 * }
 * <p/>
 * Because the background thread can't see the change in the value of stopRequested field that
 * was made by the main thread, it think the evaluation is true and the program loops forever.
 * <p/>
 * One way to fix this problem is to synchronize access to the stopRequested field.
 * The StopThreadWithSynchronized class give the solution for it.
 *
 * @author ThomsonTang
 * @version 7/16/14
 */
public class StopThread {
	private static boolean stopRequested;

	// how long would you expect this program run?
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

/****************************************
 * the result:
 * the program never terminates,
 * the background thread loops forever.
 ***************************************/
