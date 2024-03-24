package com.standard.common.module.user;

import com.standard.common.model.user.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.security.Principal;

@Service
public class UserService {
    @Value("${global.api.key}") //키
    private String securityLogServerHost;

    @Autowired
    private static Logger logger = LoggerFactory.getLogger("sql-logging");

    @Autowired
    private UserRepo userRepo;

    public User getUser(String userId) {
        System.out.println(userId);
        return userRepo.getUser(userId);
    }
    public User getUserTest() {
        logger.info(securityLogServerHost);
        return userRepo.getUserTest();
    }
}
