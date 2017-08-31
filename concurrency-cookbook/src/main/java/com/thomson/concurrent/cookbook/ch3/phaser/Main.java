package com.thomson.concurrent.cookbook.ch3.phaser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Phaser;

/**
 * 类说明
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
