package com.example.login.app.models.services;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.login.app.AppApplication;
import com.example.login.app.models.entity.Role;
import com.example.login.app.models.entity.User;
import com.example.login.app.models.repo.RoleRepo;
import com.example.login.app.models.repo.UserRepo;

@Service
@Transactional
@SuppressWarnings("unchecked")

public class RoleService implements IMainServices {

    @Autowired
    private RoleRepo roleRepo;
    @Autowired
    private UserRepo userRepo;

    @Override
    public List<?> findAll() {
        AppApplication.log.info("Getting all roles");
        return (List<Role>) roleRepo.findAll();
    }

    @Override
    public <T, V> T findBy(V data) {
        AppApplication.log.info("Getting role {}", data);
        return (T) roleRepo.findByRole((String) data);
    }

    @Override
    public <T> T save(T data) {
        return (T) roleRepo.save((Role) data);
    }

    @Override
    public <T> void delete(T data) {
        Role role = (Role) data;
        List<User> users = getUsersByRole(role.getRole());
        users.forEach(user -> user.getRoles().removeIf(filter -> filter.getRole().equals(role.getRole())));
        roleRepo.delete((Role) data);
    }

    public List<User> getUsersByRole(String data) {
        List<User> users = (List<User>) userRepo.findAll();
        List<User> filter = users.stream()
                .filter(role -> role.getRoles().stream().anyMatch(match -> match.getRole().equals(data)))
                .collect(Collectors.toList());
        return filter;
    }

    public User addRoleToUser(String username, Role role) {
        User newUser = userRepo.findByUsername(username);
        newUser.getRoles().add(role);
        return newUser;

    }

    public User deletRoleFromUser(String username, Role role) {
        User newUser = userRepo.findByUsername(username);
        newUser.getRoles().removeIf(filter -> filter.getRole().equals(role.getRole()));
        return newUser;
    }

}
