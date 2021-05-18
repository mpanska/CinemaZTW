package com.ztw.cinema.repo;

import com.ztw.cinema.entity.TicketType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketTypeRepo extends CrudRepository<TicketType, Long> {
}
