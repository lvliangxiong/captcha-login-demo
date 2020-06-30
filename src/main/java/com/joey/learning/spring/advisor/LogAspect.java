package com.joey.learning.spring.advisor;

import com.joey.learning.spring.pojo.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author Joey
 * @version 1.0
 * @date 6/19/2020 7:36 PM
 */
@Aspect
@Component
public class LogAspect {
    Logger logger = LogManager.getLogger(LogAspect.class);

    @Before(value = "execution(* com.joey.learning.spring.service.impl.UserServiceImpl.login(..)) && args(user)")
    public void beforeLogin(User user) {
        logger.debug(user + " is trying to login at " + new Date().toString());
    }

    @AfterReturning(value = "execution(* com.joey.learning.spring.service.impl.UserServiceImpl.login(..)) && args(user)",
            returning = "returnValue")
    public void afterLogin(Object returnValue, User user) {
        if (returnValue != null) {
            logger.debug(user + " login successfully at " + new Date().toString());
        } else {
            logger.debug(user + " login failed at " + new Date().toString());
        }
    }
}
