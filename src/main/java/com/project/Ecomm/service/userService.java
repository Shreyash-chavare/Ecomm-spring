package com.project.Ecomm.service;

import com.project.Ecomm.model.User;
import com.project.Ecomm.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class userService{

    @Autowired
    private UserRepo userrepo;

    public User registerUser(User user){
       return userrepo.save(user);
    }

    public User loginUser(String email,String pass){
        User existuser=userrepo.findByEmail(email);

        if(existuser!=null && existuser.getPassword().equals(pass)){
            return existuser;
        }
        return null;
    }

    public List<User> findAllusers(){
        List<User>allUser=userrepo.findAll();
        return allUser;
    }
}
