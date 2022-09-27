package com.example.login.app.models.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
@EnableResourceServer
// #11 this class set the enpoints rules bye outh side
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Override
    // #12 add all the publics endpoints
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/user", "/api/user/{username}","/api/role").permitAll()
                .anyRequest().authenticated();
    }

}
