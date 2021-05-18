package com.ztw.cinema.service;

import com.ztw.cinema.dto.SignupRequest;
import com.ztw.cinema.entity.Role;
import com.ztw.cinema.entity.User;
import com.ztw.cinema.repo.RoleRepo;
import com.ztw.cinema.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class SignupServiceImpl implements SignupService {
    private final UserRepo userRepo;
    private final RoleRepo roleRepo;
    private final PasswordEncoder passwordEncoder;

    private final String userRoleName = "ROLE_USER";

    @Autowired
    public SignupServiceImpl(UserRepo userRepo, RoleRepo roleRepo, PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.roleRepo = roleRepo;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void register(SignupRequest request) {

        String username = request.getUsername();
        if (userRepo.existsByUsername(username))
            throw new RuntimeException("Username already taken " + username);

        String email = request.getEmail();
        if (userRepo.existsByEmail(email))
            throw new RuntimeException("Email already taken " + email);

        User user = new User();
        user.setId(0L);
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setEmail(request.getEmail());
        Role userRole = roleRepo.findRoleByName(userRoleName)
                .orElseThrow(() -> new RuntimeException("Role already taken " + userRoleName));
        user.setRoles(Collections.singleton(userRole));

        userRepo.save(user);
    }
}
