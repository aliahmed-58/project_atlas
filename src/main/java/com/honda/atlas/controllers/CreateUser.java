package com.honda.atlas.controllers;

import com.honda.atlas.models.Users;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.web.bind.annotation.*;

@RestController
public class CreateUser {

    @Autowired
    private JdbcUserDetailsManager userDetailsManager;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/signup")
    public void signup(@RequestParam(value = "username") String username, @RequestParam(value = "password") String password) {

        Users user = new Users();
        user.setUsername(username);
        String newpass = passwordEncoder.encode(password);
        user.setPassword(newpass);

        userDetailsManager.createUser(user);
    }
}
