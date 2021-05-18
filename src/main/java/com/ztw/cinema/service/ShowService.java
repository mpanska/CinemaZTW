package com.ztw.cinema.service;

import com.ztw.cinema.entity.Show;

import java.util.List;

public interface ShowService {

    List<Show> findAll();

    List<Show> findByMovieId(Long movieId);

    Show findById(Long id);

    Show add(Show show);

    Show update(Show show);

    void deleteById(Long id);
}
