package com.ztw.cinema.service;

import com.ztw.cinema.entity.Ticket;

import java.util.List;

public interface TicketService {

    List<Ticket> findAll();

    List<Ticket> findByShowId(Long showId);

    Ticket findById(Long id);

    Ticket add(Ticket ticket);

    Ticket update(Ticket ticket);

    void deleteById(Long id);
}
