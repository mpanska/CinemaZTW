package com.ztw.cinema.service;

import com.ztw.cinema.entity.TicketType;

import java.util.List;

public interface TicketTypeService {

    List<TicketType> findAll();

    TicketType findById(Long id);

    TicketType add(TicketType type);

    TicketType update(TicketType type);

    void deleteById(Long id);
}
