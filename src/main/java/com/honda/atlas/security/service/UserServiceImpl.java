package com.honda.atlas.security.service;

import com.honda.atlas.models.Users;
import com.honda.atlas.repo.RolesRepo;
import com.honda.atlas.repo.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.HashSet;

@Component
public class UserServiceImpl implements UserService {

    private final UsersRepo usersRepo;
    private final PasswordEncoder passwordEncoder;
    private final RolesRepo rolesRepo;

    @Autowired
    public UserServiceImpl(UsersRepo usersRepo, PasswordEncoder passwordEncoder, RolesRepo rolesRepo) {
        this.usersRepo = usersRepo;
        this.passwordEncoder = passwordEncoder;
        this.rolesRepo = rolesRepo;
    }

    @Override
    public void save(Users user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
//        user.setRoles(new HashSet<>(rolesRepo.findAll()));
        usersRepo.save(user);
    }

    @Override
    public Users findByUsername(String username) {
        return usersRepo.findByUsername(username);
    }
}
