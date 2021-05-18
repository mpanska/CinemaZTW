package com.ztw.cinema.service;

import com.ztw.cinema.entity.User;
import com.ztw.cinema.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;

    @Autowired
    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public User findByUsername(String username) {
        return userRepo.findUserByUsername(username)
                .orElseThrow(() -> new RuntimeException("Username not found " + username));
    }
}
