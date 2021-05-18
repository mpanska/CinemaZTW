package com.ztw.cinema.service;

import com.ztw.cinema.entity.TicketType;
import com.ztw.cinema.repo.TicketTypeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TicketTypeServiceImpl implements TicketTypeService {

    private final TicketTypeRepo ticketTypeRepo;

    @Autowired
    public TicketTypeServiceImpl(TicketTypeRepo ticketTypeRepo) {
        this.ticketTypeRepo = ticketTypeRepo;
    }

    @Override
    public List<TicketType> findAll() {
        List<TicketType> types = new ArrayList<>();
        ticketTypeRepo.findAll().forEach(types::add);
        return types;
    }

    @Override
    public TicketType findById(Long id) {
        return ticketTypeRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Ticket type not found: " + id));
    }

    @Override
    public TicketType add(TicketType type) {
        type.setId(0L);
        return ticketTypeRepo.save(type);
    }

    @Override
    public TicketType update(TicketType type) {
        Long id = type.getId();
        if (!ticketTypeRepo.existsById(id))
            throw new RuntimeException("Ticket type not found: " + id);
        return ticketTypeRepo.save(type);
    }

    @Override
    public void deleteById(Long id) {
        if (!ticketTypeRepo.existsById(id))
            throw new RuntimeException("Ticket type not found: " + id);
        ticketTypeRepo.deleteById(id);
    }
}
