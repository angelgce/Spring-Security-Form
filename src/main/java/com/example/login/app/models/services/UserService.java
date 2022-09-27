package com.example.login.app.models.services;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.login.app.AppApplication;
import com.example.login.app.models.entity.User;
import com.example.login.app.models.repo.UserRepo;

@SuppressWarnings("unchecked")

@Service
@Transactional
public class UserService implements IMainServices, UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    // --> security
    // #1 implements userdatailservices
    // UserDetailsService method
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepo.findByUsername(username);
        if (user == null) {
            AppApplication.log.error("Error, user not found {}", username);
        }

        List<GrantedAuthority> authorities = user.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getRole())).collect(Collectors.toList());

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                authorities);
    }

    // --> service

    @Override
    public List<?> findAll() {
        AppApplication.log.info("Getting all users");
        return (List<User>) userRepo.findAll();
    }

    @Override
    public <T, V> T findBy(V data) {
        AppApplication.log.info("Getting Username {} ", data);
        return (T) userRepo.findByUsername((String) data);
    }

    @Override
    public <T> T save(T data) {
        AppApplication.log.error("saving data {} in to db", data);
        return (T) userRepo.save((User) data);
    }

    @Override
    public <T> void delete(T data) {
        AppApplication.log.info("data {} deleted ", data);
        userRepo.delete((User) data);
    }

}
