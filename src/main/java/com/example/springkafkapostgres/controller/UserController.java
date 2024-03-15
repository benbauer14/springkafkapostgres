package com.example.springkafkapostgres.controller;

import com.example.springkafkapostgres.bean.User;
import com.example.springkafkapostgres.repo.MemberCRUD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    MemberCRUD memberCRUD;

    @GetMapping("/all")
    public List<User> getUsers() {
        return (List<User>) memberCRUD.findAll();
    }

    @PostMapping("/create")
    public User createUser(@RequestBody User user) {
        user = memberCRUD.save(user);
        return user;
    }
}
