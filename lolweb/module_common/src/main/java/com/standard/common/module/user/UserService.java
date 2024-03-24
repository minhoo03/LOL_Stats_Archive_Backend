package com.standard.common.module.user;

import com.standard.common.model.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public User getUser(String userId) {
        System.out.println(userId);
        return userRepo.getUser(userId);
    }
    public User getUserTest() {
        return userRepo.getUserTest();
    }
}
