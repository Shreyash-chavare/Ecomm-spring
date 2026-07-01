package com.project.Ecomm.repo;

import com.project.Ecomm.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Long> {

    public User findByEmail(String email);
}
