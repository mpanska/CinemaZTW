package com.ztw.cinema.service;

import com.ztw.cinema.entity.Movie;

import java.util.List;

public interface MovieService {

    List<Movie> findAll();

    Movie findById(Long id);

    Movie add(Movie movie);

    Movie update(Movie movie);

    void deleteById(Long id);
}
