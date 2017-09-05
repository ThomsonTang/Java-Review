package com.thomson.concurrent.cookbook.ch3.phaser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Phaser;

/**
 * <h2>Running concurrent phased tasks.</h2>
 *
 * The {@code Phaser} mechanism is useful when we have some concurrent tasks divided into steps.
 * The {@link Phaser} class provides us with the mechanism to synchronize the threads at the end
 * of each step, so no thread starts its second until all the threads have finished the first one.
 *
 * 和其他的同步工具类似，我们需要用参与同步操作的任务的个数来初始化Phaser类，不过我们可以动态地增加或减少这个数。
 * 这个数表明了Phaser在即将进入到下一个阶段并唤醒正在休眠的线程前必须要执行{@code arriveAndAwaitAdvance()}
 * 方法的线程数。
 *
 * @author Thomson Tang
 * @version Created: 31/08/2017.
 */
public class Main {
    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        Phaser phaser = new Phaser(3);
        FileSearch wf = new FileSearch("/opt/wf", "xml", phaser);
        FileSearch agent = new FileSearch("/opt/usp", "xml", phaser);
        FileSearch usp = new FileSearch("/Users/thomsontang/workspace/58.com/zeus/usp_4-0-0_BRANCH", "xml", phaser);

        Thread wfThread = new Thread(wf, "WF");
        wfThread.start();
        Thread agentThread = new Thread(agent, "AGENT");
        agentThread.start();
        Thread uspThread = new Thread(usp, "USP");
        uspThread.start();

        try {
            wfThread.join();
            agentThread.join();
            uspThread.join();
        } catch (InterruptedException e) {
            LOGGER.error("{}", e);
        }

        LOGGER.info("Terminated: {}", phaser.isTerminated());
    }
}
