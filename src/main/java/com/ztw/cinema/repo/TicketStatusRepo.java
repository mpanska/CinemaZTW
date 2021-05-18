package com.ztw.cinema.repo;

import com.ztw.cinema.entity.TicketStatus;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketStatusRepo extends CrudRepository<TicketStatus, Long> {
}
