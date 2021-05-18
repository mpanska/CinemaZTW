package com.ztw.cinema.repo;

import com.ztw.cinema.entity.Movie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepo extends CrudRepository<Movie, Long> {
}
