package com.thomson.jcip.ch6.execution;

import java.util.Timer;
import java.util.TimerTask;

import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * <h2>Class Illustrating Confusing {@link Timer Timer} Behavior.</h2>
 *
 * 错误的Timer行为，Timer线程不会捕获异常，因此当TimerTask抛出未检查异常时将终止定时线程，Timer会错误的认为整个Timer都被取消了。
 *
 * @author Thomson Tang
 * @version Created: 27/08/2017.
 */
public class OutOfTime {
    public static void main(String[] args) throws InterruptedException {
        Timer timer = new Timer();
        timer.schedule(new ThrowTask(), 1);
        SECONDS.sleep(1);
        timer.schedule(new ThrowTask(), 1);
        SECONDS.sleep(5);
    }

    static class ThrowTask extends TimerTask {
        @Override
        public void run() {
            throw new RuntimeException();
        }
    }
}
