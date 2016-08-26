import basicthreadsynchronized.synchronizingWithLock.Job
import basicthreadsynchronized.synchronizingWithLock.PrintQueue
import spock.lang.Specification

import java.util.concurrent.CountDownLatch

/**
 * 类说明
 *
 * @author Thomson Tang
 * @version Created ：2016-8/26/16-15:16
 */

class PrintJobSpec extends Specification {
    def printQueue = new PrintQueue()
    def countDownLatch = new CountDownLatch(10)
    def jobs = []

    def setup() {
        (0..10).each {
            jobs << new Thread(new Job(printQueue, countDownLatch))
        }
    }

    def "print"() {
        when:
        jobs.each {
            it.start()
        }
        countDownLatch.await()

        then:
        println "OK"
    }
}