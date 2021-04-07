package com.completesignup.springsecurity.Repository;

import com.completesignup.springsecurity.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    public User findByUsername(String username);
}
