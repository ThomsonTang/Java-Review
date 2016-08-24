package threadExecutors.multipleTaskAndAllResults;

import com.google.common.collect.Lists;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 类说明
 *
 * @author Thomson Tang
 * @version Created ：2016-8/18/16-17:07
 */
public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();

        List<Task> taskList = Lists.newArrayList();
        for (int i = 0; i < 3; i++) {
            Task task = new Task(i + "");
            taskList.add(task);
        }

        List<Future<Result>> resultList = null;
        try {
            resultList = executor.invokeAll(taskList);
        } catch (InterruptedException e) {
            logger.error(e.getMessage(), e);
        }
        executor.shutdown();

        logger.info("Main: Printing the results...");
        for (int i = 0; i < resultList.size(); i++) {
            Future<Result> future = resultList.get(i);
            try {
                Result result = future.get();
                logger.info("{}: {}", result.getName(), result.getValue());
            } catch (InterruptedException | ExecutionException e) {
                logger.error(e.getMessage(), e);
            }
        }
    }
}
