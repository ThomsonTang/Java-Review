package com.thomson.concurrent.cookbook.ch4.first;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * <h2>Running multiple tasks and processing the first result.</h2>
 *
 * 并发编程中有一种常见的使用场景是，当多个任务并发处理解决某个问题时，我们只关心这些任务中返回的第一个结果。
 * 举例来说，你用多种算法对一个数组进行排序，你可以同时执行它们，但是只有第一个将数组排完序的算法才是我们想要
 * 的最快的排序算法。
 *
 * <p>
 *     这个示例模拟的是用户校验的场景。通过两个校验器来校验用户的合法性，只要有一个验证通过，就返回对应的结果即可。
 * </p>
 *
 * @author Thomson Tang
 * @version Created: 18/09/2017.
 */
public class Main {
    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        String userName = "test";
        String password = "test";

        //创建两个不同的验证器
        UserValidator ldapValidator = new UserValidator("LDAP");
        UserValidator dbValidator = new UserValidator("DataBase");

        //根据上面定义的验证器创建两个校验任务
        TaskValidator ldapTask = new TaskValidator(ldapValidator, userName, password);
        TaskValidator dbTask = new TaskValidator(dbValidator, userName, password);

        //将校验任务添加到任务列表中
        List<TaskValidator> taskList = new ArrayList<>();
        taskList.add(ldapTask);
        taskList.add(dbTask);

        ExecutorService executor = Executors.newCachedThreadPool();
        String result;

        try {
            //关键点就在这里，该方法接受一个任务列表，然后执行这些任务，返回第一个执行完成且没有抛出异常的任务的结果。
            result = executor.invokeAny(taskList);
            LOGGER.info("Main: Result: {}.", result);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        executor.shutdown();
        LOGGER.info("Main: End of the execution.");
    }
}
