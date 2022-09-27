package com.example.login.app.models.repo;

import org.springframework.data.repository.CrudRepository;

import com.example.login.app.models.entity.User;

public interface UserRepo extends CrudRepository<User,Long> {
 
    //esto es un query
    public User findByUsername(String username);

    // @Query("select u from User u where u.user")
    // public User getUser(String username);

}
