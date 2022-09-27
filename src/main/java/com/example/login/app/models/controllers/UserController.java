package com.example.login.app.models.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.login.app.models.entity.User;
import com.example.login.app.models.services.UserService;

import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api")
@EnableGlobalMethodSecurity(securedEnabled = true)
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user")
    public List<User> getUsers() {
        return (List<User>) userService.findAll();
    }

    @GetMapping("/user/{username}")
    public User getUser(@PathVariable String username) {
        return userService.findBy(username);
    }

    @Secured({ "ROLE_ADMIN", "ROLE_MODERATOR" })
    @PutMapping("/user")
    public User addUser(@RequestBody User user) {
        return userService.save(user);
    }

    @Secured({ "ROLE_ADMIN", "ROLE_MODERATOR" })
    @PostMapping("/user")
    public User updateUser(@RequestBody User user) {
        return userService.save(user);
    }

    @Secured("ROLE_ADMIN")
    @DeleteMapping("/user")
    public void deleteUser(@RequestBody User user) {
        userService.delete(user);
    }

}
