package com.thomson.concurrent.cookbook.ch4.first;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Callable;

/**
 * 验证任务类
 *
 * 创建一个可以并发执行的任务，用来验证对应用户的合法性。该任务是具有返回结果的，如果验证通过，
 * 则直接返回用户的用户名，否则将抛出异常，告知用户不存在。
 *
 * @author Thomson Tang
 * @version Created: 18/09/2017.
 */
public class TaskValidator implements Callable<String> {
    private static final Logger LOGGER = LoggerFactory.getLogger(TaskValidator.class);
    private UserValidator userValidator;

    private String user;
    private String password;

    public TaskValidator(UserValidator userValidator, String user, String password) {
        this.userValidator = userValidator;
        this.user = user;
        this.password = password;
    }

    @Override
    public String call() throws Exception {
        if (!userValidator.validate(user, password)) {
            LOGGER.info("{}: The user has not been found.", userValidator.getName());
            throw new Exception("Error validating user.");
        }
        LOGGER.info("{}: The user has been found.", userValidator.getName());
        return userValidator.getName();
    }
}
