package com.example.login.app.models.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
    // step 1 is on UserService
    // #2 extend from spring security
    // #3 inject userDatailServices
    @Autowired
    private UserDetailsService userDetailsService;

    // #6 Create a bean of this method
    @Bean
    public static BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    // #7 -> go to Auth server config class

    @Override
    @Autowired
    // #4 overide AUMB method
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    // #10 overide AuthenticationManager method as BEAN
    @Override
    @Bean()
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    // #11 -> ResourceServConfig class

    // #13 -> add rules and cofigurate in spring side
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests().anyRequest().authenticated().and().csrf().disable().sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

}
