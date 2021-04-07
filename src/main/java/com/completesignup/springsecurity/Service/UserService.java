package com.completesignup.springsecurity.Service;

import com.completesignup.springsecurity.Model.User;
import com.completesignup.springsecurity.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User saveUser(User user){
        return userRepository.save(user);
    }
}
