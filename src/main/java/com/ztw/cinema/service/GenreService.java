package com.ztw.cinema.service;

import com.ztw.cinema.entity.Genre;

import java.util.List;

public interface GenreService {

    List<Genre> findAll();

    Genre findById(Long id);

    Genre add(Genre genre);

    Genre update(Genre genre);

    void deleteById(Long id);
}
