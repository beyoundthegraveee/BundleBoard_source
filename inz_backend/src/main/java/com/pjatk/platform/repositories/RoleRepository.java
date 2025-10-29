package com.pjatk.platform.repositories;

import com.pjatk.platform.enums.UserRole;
import com.pjatk.platform.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {

    Optional<Role> findByName(UserRole name);

}
