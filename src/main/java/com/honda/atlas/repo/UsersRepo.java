package com.honda.atlas.repo;

import com.honda.atlas.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepo extends JpaRepository<Users, Long> {
    Users findByUsername(String username);
}
