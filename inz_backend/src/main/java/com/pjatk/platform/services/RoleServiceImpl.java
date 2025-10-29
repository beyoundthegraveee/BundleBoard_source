package com.pjatk.platform.services;

import com.pjatk.platform.models.Role;
import com.pjatk.platform.repositories.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;


    @Override
    public Optional<Role> findByName(String name) {
        return Optional.empty();
    }
}
