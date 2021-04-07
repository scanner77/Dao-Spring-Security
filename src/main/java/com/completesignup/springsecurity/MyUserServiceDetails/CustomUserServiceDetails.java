package com.completesignup.springsecurity.MyUserServiceDetails;

import com.completesignup.springsecurity.Model.User;
import com.completesignup.springsecurity.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserServiceDetails implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if(user == null){
        throw new UsernameNotFoundException("Username not found");
        }else{
            return new CustomUserDetails(user);
        }
    }
}
