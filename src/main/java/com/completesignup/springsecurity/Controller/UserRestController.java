package com.completesignup.springsecurity.Controller;


import com.completesignup.springsecurity.Model.User;
import com.completesignup.springsecurity.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRestController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String welcomeEverybody(){
        return "Everybody is welcome";
    }

    @GetMapping("/register")
    public String registerPage(Model model){
        User user = new User();
        model.addAttribute("user", user);
        return "Welcome to the registration page";
    }

    @GetMapping("/login")
    public String loginPage(Model model){
        User user = new User();
        model.addAttribute("user", user);
        return "Welcome to login page";
    }

//    ----------------POSTING INTO THE DATABASE/INTERACTING WITH DATABASE------------

    @PostMapping("/registerUser")
    public String saveUser(@ModelAttribute User user){
        userService.saveUser(user);
        return "redirect:/web/";
    }
}
