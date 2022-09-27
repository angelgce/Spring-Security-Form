package com.example.login.app.models.repo;

import org.springframework.data.repository.CrudRepository;

import com.example.login.app.models.entity.Role;


public interface RoleRepo extends CrudRepository<Role, Long> {

    public Role findByRole(String role);
}
