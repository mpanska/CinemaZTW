package com.ztw.cinema.service;

import com.ztw.cinema.entity.Seat;

import java.util.List;

public interface SeatService {

    List<Seat> findAll();

    List<Seat> findAllByHallId(Long hallId);

    Seat findById(Long id);

    Seat add(Seat seat);

    Seat update(Seat seat);

    void deleteById(Long id);
}
