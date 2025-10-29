package com.pjatk.platform.controllers;

import com.pjatk.platform.models.User;
import com.pjatk.platform.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping(value = "/secured")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/info")
    public String getUser(Principal principal) {
        if (principal != null) {
            return principal.getName();
        }
        return null;
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return userService.getAllUsers();
    }






}
