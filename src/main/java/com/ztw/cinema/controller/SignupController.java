package com.ztw.cinema.controller;

import com.ztw.cinema.dto.SignupRequest;
import com.ztw.cinema.service.SignupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
public class SignupController {

    SignupService signupService;
    PasswordEncoder encoder;

    @Autowired
    public SignupController(SignupService signupService, PasswordEncoder encoder) {
        this.signupService = signupService;
        this.encoder = encoder;
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest request) {
        signupService.register(request);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
