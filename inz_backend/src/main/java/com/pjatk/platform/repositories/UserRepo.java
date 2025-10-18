package com.pjatk.platform.repositories;

import com.pjatk.platform.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.*;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {


}
