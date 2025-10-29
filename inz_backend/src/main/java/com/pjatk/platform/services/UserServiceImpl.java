package com.pjatk.platform.services;

import com.pjatk.platform.models.User;
import com.pjatk.platform.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor()
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final RoleService roleService;


    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User createUser(User user){
        return userRepository.save(user);
    }

    @Override
    public Optional<User> getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }


}
