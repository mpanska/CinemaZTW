package com.ztw.cinema.service;

import com.ztw.cinema.entity.Movie;
import com.ztw.cinema.repo.MovieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieServiceImpl implements MovieService{

    private final MovieRepo movieRepo;

    @Autowired
    public MovieServiceImpl(MovieRepo movieRepo) {
        this.movieRepo = movieRepo;
    }

    @Override
    public List<Movie> findAll() {
        List<Movie> movies = new ArrayList<>();
        movieRepo.findAll().forEach(movies::add);
        return movies;
    }

    @Override
    public Movie findById(Long id) {
        return movieRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Movie not found: " + id));
    }

    @Override
    public Movie add(Movie movie) {
        movie.setId(0L);
        return movieRepo.save(movie);
    }

    @Override
    public Movie update(Movie movie) {
        Long id = movie.getId();
        if (!movieRepo.existsById(id))
            throw new RuntimeException("Movie not found: " + id);
        return movieRepo.save(movie);
    }

    @Override
    public void deleteById(Long id) {
        if (!movieRepo.existsById(id))
            throw new RuntimeException("Movie not found: " + id);
        movieRepo.deleteById(id);
    }
}
