package com.honda.atlas.controllers;

import com.honda.atlas.models.Roles;
import com.honda.atlas.models.Users;
import com.honda.atlas.repo.RolesRepo;
import com.honda.atlas.security.service.UserDetailsServiceImpl;
import com.honda.atlas.security.service.UserServiceImpl;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
public class CreateUser {

    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private RolesRepo rolesRepo;

    @PostMapping("/signup")
    public void signup(@RequestParam(value = "username") String username,
                       @RequestParam(value = "password") String password,
                       @RequestParam String role) {

        Users user = new Users();

        Set<Roles> roles = new HashSet<>();
        Roles roles1 = new Roles();

        roles1.setRole(role);
        roles.add(roles1);

        user.setRoles(roles);
        user.setUsername(username);
        user.setPassword(password);

        userService.save(user);
    }
}
