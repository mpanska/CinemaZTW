package com.ztw.cinema.repo;

import com.ztw.cinema.entity.Hall;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HallRepo extends CrudRepository<Hall, Long> {
}
