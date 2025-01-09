package com.example.portfolio.controller;


import com.example.portfolio.models.UsersModel;
import com.example.portfolio.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UsersController {

    @Autowired
    private UsersService userService;

    @GetMapping("/api/users")
    public List<UsersModel> getUsers() {

        List<UsersModel> users = userService.getUsers();
        System.out.println("UsersController: Retrieved users: " + users);
        return users;
    }
}
