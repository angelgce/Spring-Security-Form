package com.example.login.app.models.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.login.app.models.entity.Role;
import com.example.login.app.models.entity.User;
import com.example.login.app.models.services.RoleService;

import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping("/role")
    public List<Role> getRoles() {
        return (List<Role>) roleService.findAll();
    }

    @PutMapping("/role")
    public Role addRole(@RequestBody Role role) {
        roleService.save(role);
        return role;
    }

    @DeleteMapping("/role")
    public void deleteUser(@RequestBody Role role) {
        roleService.delete(role);
    }

    // Roles with usetes

    // Show the users of the role
    @GetMapping("/role/{role}")
    public List<User> getUserRole(@PathVariable String role) {
        return roleService.getUsersByRole(role);

    }

    // add a role to an user
    @PostMapping("/role/{username}")
    public User addUserRole(@PathVariable String username, @RequestBody Role role) {
        return roleService.addRoleToUser(username, role);
    }

    // delete a role from an user
    @DeleteMapping("/role/{username}")
    public User deletRoleFromUser(@PathVariable String username, @RequestBody Role role) {
        return roleService.deletRoleFromUser(username, role);
    }
}
