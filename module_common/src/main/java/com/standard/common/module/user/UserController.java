package com.standard.common.module.user;

import com.standard.common.model.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/api/common/user")
    public User getUser(Principal principal) {
        return userService.getUser(principal.getName());
    }

    @GetMapping("/api/common/user/test")
    public User getUserTest() {
        return userService.getUserTest();
    }

    @GetMapping("/a")
    public String lol() {
        return "아아아악!";
    }
}
