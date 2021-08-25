package com.honda.atlas.security.service;

import com.honda.atlas.models.Roles;
import com.honda.atlas.models.Users;
import com.honda.atlas.repo.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UsersRepo usersRepo;

    @Autowired
    public UserDetailsServiceImpl(UsersRepo usersRepo) {
        this.usersRepo = usersRepo;
    }

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Users users = usersRepo.findByUsername(s);
        if (users == null) throw new UsernameNotFoundException("username " + s + " not found");

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        for (Roles roles: users.getRoles()) {
            grantedAuthorities.add(new SimpleGrantedAuthority(roles.getRole()));
        }

        return new User(users.getUsername(), users.getPassword(), grantedAuthorities); // todo add authorities
    }
}
