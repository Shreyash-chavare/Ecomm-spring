package com.project.Ecomm.controller;

import com.project.Ecomm.model.User;
import com.project.Ecomm.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class usercontroller {

    @Autowired
    private userService userservice;


    @PostMapping("/register")
    public User registeruser(@RequestBody User user){

        return userservice.registerUser(user);
    }

    @PostMapping("/login")
    public User loginuser(@RequestBody User user){
        return userservice.loginUser(user.getEmail(),user.getPassword());
    }

    @GetMapping("/allUsers")
    public List<User>allUser(){
        return userservice.findAllusers();
    }


}
