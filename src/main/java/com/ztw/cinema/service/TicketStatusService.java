package com.ztw.cinema.service;

import com.ztw.cinema.entity.TicketStatus;

import java.util.List;

public interface TicketStatusService {

    List<TicketStatus> findAll();

    TicketStatus findById(Long id);

    TicketStatus add(TicketStatus status);

    TicketStatus update(TicketStatus status);

    void deleteById(Long id);
}
