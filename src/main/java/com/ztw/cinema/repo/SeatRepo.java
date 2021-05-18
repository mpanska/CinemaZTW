package com.ztw.cinema.repo;

import com.ztw.cinema.entity.Seat;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeatRepo extends CrudRepository<Seat, Long> {
    Iterable<Seat> findSeatByHallId(Long hallId);
}
