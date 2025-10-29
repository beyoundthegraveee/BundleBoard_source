package com.pjatk.platform.services;

import com.pjatk.platform.models.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

   List<User> getAllUsers();

   User createUser(User user);

   Optional<User> getUserByUsername(String username);

}
