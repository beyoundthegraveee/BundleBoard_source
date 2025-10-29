package com.pjatk.platform.services;

import com.pjatk.platform.models.Role;

import java.util.Optional;

public interface RoleService {

    Optional<Role> findByName(String name);


}
