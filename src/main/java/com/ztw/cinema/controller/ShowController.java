package com.ztw.cinema.controller;

import com.ztw.cinema.service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/shows")
public class ShowController {

    private final ShowService showService;

    @Autowired
    public ShowController(ShowService showService) {
        this.showService = showService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getShow(@PathVariable Long id) {
        return new ResponseEntity<>(showService.findById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getMovieShows(@RequestParam Long movieId) {
        return new ResponseEntity<>(showService.findByMovieId(movieId), HttpStatus.OK);
    }
}
