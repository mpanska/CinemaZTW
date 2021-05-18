package com.ztw.cinema.repo;

import com.ztw.cinema.entity.Genre;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreRepo extends CrudRepository<Genre, Long> {
}
