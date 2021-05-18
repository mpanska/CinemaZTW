package com.ztw.cinema.repo;

import com.ztw.cinema.entity.Show;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface ShowRepo extends CrudRepository<Show, Long> {
    Iterable<Show> findShowByMovieId(Long movieId);
}
