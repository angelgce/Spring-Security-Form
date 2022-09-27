package com.example.login.app.models.services;


import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface IMainServices {

    // get
    public List<?> findAll();

    // get
    public <T, V> T findBy(V data);

    // put - post
    public <T> T save(T data);

    // delete
    public <T> void delete(T data);

}
