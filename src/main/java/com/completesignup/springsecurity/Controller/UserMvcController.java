package com.completesignup.springsecurity.Controller;


import com.completesignup.springsecurity.Model.User;
import com.completesignup.springsecurity.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/web")
public class UserMvcController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String welcomeEverybody(){
        return "index";
    }

    @GetMapping("/register")
    public String registerPage(Model model){
        User user = new User();
        model.addAttribute("user", user);
        return "register";
    }
    @GetMapping("/foradmins")
    public String adminsonly(){

        return "adminsonly";
    }

    @GetMapping("/login")
    public String loginPage(Model model){
        User user = new User();
        model.addAttribute("user", user);
        return "login";
    }

//    ----------------POSTING INTO THE DATABASE/INTERACTING WITH DATABASE------------

    @PostMapping("/registerUser")
    public String saveUser(@ModelAttribute User user){
        userService.saveUser(user);
        return "redirect:/web/";
    }
}
