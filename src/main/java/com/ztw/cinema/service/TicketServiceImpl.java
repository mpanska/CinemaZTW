package com.ztw.cinema.service;

import com.ztw.cinema.entity.Ticket;
import com.ztw.cinema.repo.TicketRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {

    private final TicketRepo ticketRepo;

    @Autowired
    public TicketServiceImpl(TicketRepo ticketRepo) {
        this.ticketRepo = ticketRepo;
    }

    @Override
    public List<Ticket> findAll() {
        List<Ticket> tickets = new ArrayList<>();
        ticketRepo.findAll().forEach(tickets::add);
        return tickets;
    }

    @Override
    public List<Ticket> findByShowId(Long showId) {
        List<Ticket> tickets = new ArrayList<>();
        ticketRepo.findTicketByShowId(showId).forEach(tickets::add);
        return tickets;
    }

    @Override
    public Ticket findById(Long id) {
        return ticketRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Ticket not found: " + id));
    }

    @Override
    public Ticket add(Ticket ticket) {
        ticket.setId(0L);
        return ticketRepo.save(ticket);
    }

    @Override
    public Ticket update(Ticket ticket) {
        Long id = ticket.getId();
        if (!ticketRepo.existsById(id))
            throw new RuntimeException("Ticket not found: " + id);
        return ticketRepo.save(ticket);
    }

    @Override
    public void deleteById(Long id) {
        if (!ticketRepo.existsById(id))
            throw new RuntimeException("Ticket not found: " + id);
        ticketRepo.deleteById(id);
    }
}
