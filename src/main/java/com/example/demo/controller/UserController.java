package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Denis Iaichnikov
 * @since 7/12/2018
 */
@RestController
public class UserController {

    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/create/table")
    public void createTable() {
        userRepository.createTable();
    }

    @PostMapping("/add/user")
    public void addUser(@RequestBody User user) {
        userRepository.addUser(user);
    }

    @GetMapping("find")
    public List<User> findAllUsers() {
        return userRepository.getAllUsers();
    }
}
