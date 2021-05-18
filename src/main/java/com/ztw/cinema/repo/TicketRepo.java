package com.ztw.cinema.repo;

import com.ztw.cinema.entity.Ticket;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface TicketRepo extends CrudRepository<Ticket, Long> {
    Iterable<Ticket> findTicketByShowId(Long showId);
}
