package com.thomson.concurrent.cookbook.ch4.first;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * 用户验证的流程处理。
 *
 * 在随机的一段时间内随机模拟验证过程，返回结果为true或false，代表验证通过与否。
 *
 * @author Thomson Tang
 * @version Created: 18/09/2017.
 */
public class UserValidator {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserValidator.class);
    private String name;

    public UserValidator(String name) {
        this.name = name;
    }

    public boolean validate(String name, String password) {
        Random random = new Random();
        try {
        long duration = (long) (Math.random() * 10);
        LOGGER.info("Validator {}: Validating a user during {} seconds.", this.name, duration);
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            return false;
        }
        return random.nextBoolean();
    }

    public String getName() {
        return name;
    }
}
