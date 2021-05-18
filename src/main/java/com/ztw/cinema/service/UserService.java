package com.ztw.cinema.service;

import com.ztw.cinema.entity.User;

public interface UserService {

    User findByUsername(String username);
}
