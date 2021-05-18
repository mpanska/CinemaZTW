package com.ztw.cinema.service;

import com.ztw.cinema.entity.Show;
import com.ztw.cinema.repo.ShowRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShowServiceImpl implements ShowService{

    private final ShowRepo showRepo;

    @Autowired
    public ShowServiceImpl(ShowRepo showRepo) {
        this.showRepo = showRepo;
    }

    @Override
    public List<Show> findAll() {
       List<Show> shows = new ArrayList<>();
       showRepo.findAll().forEach(shows::add);
       return shows;
    }

    @Override
    public List<Show> findByMovieId(Long movieId) {
        List<Show> shows = new ArrayList<>();
        showRepo.findShowByMovieId(movieId).forEach(shows::add);
        return shows;
    }

    @Override
    public Show findById(Long id) {
        return showRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Show not found: " + id));
    }

    @Override
    public Show add(Show show) {
        show.setId(0L);
        return showRepo.save(show);
    }

    @Override
    public Show update(Show show) {
        Long id = show.getId();
        if (!showRepo.existsById(id))
            throw new RuntimeException("Show not found: " + id);
        return showRepo.save(show);
    }

    @Override
    public void deleteById(Long id) {
        if (!showRepo.existsById(id))
            throw new RuntimeException("Show not found: " + id);
        showRepo.deleteById(id);
    }
}
