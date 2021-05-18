package com.ztw.cinema.controller;

import com.ztw.cinema.service.ShowDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/showDetails")
public class ShowDetailsController {

    private final ShowDetailsService showDetailsService;

    @Autowired
    public ShowDetailsController(ShowDetailsService showDetailsService) {
        this.showDetailsService = showDetailsService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getShowDetails(@PathVariable Long id) {
        return new ResponseEntity<>(showDetailsService.findById(id), HttpStatus.OK);
    }
}
