package com.ztw.cinema.service;

import com.ztw.cinema.entity.Hall;

import java.util.List;

public interface HallService {

    List<Hall> findAll();

    Hall findById(Long id);

    Hall add(Hall hall);

    Hall update(Hall hall);

    void deleteById(Long id);
}
