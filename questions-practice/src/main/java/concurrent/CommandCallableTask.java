package concurrent;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * 类说明
 *
 * @author Thomson Tang
 * @version Created ：2016-8/18/16-15:52
 */
public class CommandCallableTask {
    private static final Logger logger = LoggerFactory.getLogger(CommandCallableTask.class);
    private static final ExecutorService executor = Executors.newFixedThreadPool(10);

    public static final CommandCallableTask INSTANCE = new CommandCallableTask();

    private CommandCallableTask() {
    }

    public Map<String, String> runTask(List<String> ips) throws ExecutionException, InterruptedException {
        Map<String, String> map = Maps.newConcurrentMap();
        for (String ip : ips) {
            Future<Map<String, String>> future = executor.submit(new Callable<Map<String, String>>() {
                @Override
                public Map<String, String> call() throws Exception {
                    return ImmutableMap.of(ip, runCmd(ip));
                }
            });
            map.putAll(future.get());
        }
        executor.shutdown();
        return map;
    }

    private String runCmd(String ip) {
        logger.info("==== rum cmd for {}", ip);
        int count = 100;
        while (count > 0) {
            String result = doWork(ip);
            if ("OK".equals(result)) {
                return "SUCCESS";
            }

            try {
                count--;
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                logger.error(e.getMessage(), e);
            }
        }
        return "FAIL";
    }

    private String doWork(String ip) {
        logger.info("the work of target {}: doing....", ip);
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            logger.error(e.getMessage(), e);
            return "ERROR";
        }
        logger.info("the work of target {}: done", ip);
        return "OK";
    }
}
