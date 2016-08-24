package concurrent;

import com.google.common.collect.ImmutableList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.concurrent.ExecutionException;

/**
 * 类说明
 *
 * @author Thomson Tang
 * @version Created ：2016-8/18/16-15:51
 */
public class GanjiCmdService {
    private static final Logger logger = LoggerFactory.getLogger(GanjiCmdService.class);

    public static void main(String[] args) {
        logger.info("======== start...");
        try {
            CommandCallableTask task = CommandCallableTask.INSTANCE;
            Map<String, String> resultMap = task.runTask(ImmutableList.of("1", "2", "3", "4", "5"));
            logger.info("the result: \n {}", resultMap);
        } catch (ExecutionException e) {
            logger.error(e.getMessage(), e);
        } catch (InterruptedException e) {
            logger.error(e.getMessage(), e);
        }
    }
}
