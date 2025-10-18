package com.pjatk.platform.services;

import com.pjatk.platform.models.User;
import com.pjatk.platform.repositories.UserRepo;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;

    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }


    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }
}
