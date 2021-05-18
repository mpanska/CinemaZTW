package com.ztw.cinema.service;

import com.ztw.cinema.dto.UserDetailsImpl;
import com.ztw.cinema.entity.User;
import com.ztw.cinema.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepo userRepo;

    @Autowired
    public UserDetailsServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        User user = userRepo.findByUsernameAndFetchRolesEagerly(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));

        return new UserDetailsImpl(user);
    }

}
