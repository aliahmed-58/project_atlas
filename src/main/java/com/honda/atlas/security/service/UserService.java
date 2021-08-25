package com.honda.atlas.security.service;

import com.honda.atlas.models.Users;

public interface UserService {

    void save(Users user);

    Users findByUsername(String username);
}
