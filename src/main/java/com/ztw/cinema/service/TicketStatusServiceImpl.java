package com.ztw.cinema.service;

import com.ztw.cinema.entity.TicketStatus;
import com.ztw.cinema.repo.TicketStatusRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TicketStatusServiceImpl implements TicketStatusService {

    private final TicketStatusRepo ticketStatusRepo;

    @Autowired
    public TicketStatusServiceImpl(TicketStatusRepo ticketStatusRepo) {
        this.ticketStatusRepo = ticketStatusRepo;
    }

    @Override
    public List<TicketStatus> findAll() {
        List<TicketStatus> statuses = new ArrayList<>();
        ticketStatusRepo.findAll().forEach(statuses::add);
        return statuses;
    }

    @Override
    public TicketStatus findById(Long id) {
        return ticketStatusRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Ticket status not found: " + id));
    }

    @Override
    public TicketStatus add(TicketStatus status) {
        status.setId(0L);
        return ticketStatusRepo.save(status);
    }

    @Override
    public TicketStatus update(TicketStatus status) {
        Long id = status.getId();
        if (!ticketStatusRepo.existsById(id))
            throw new RuntimeException("Ticket status not found: " + id);
        return ticketStatusRepo.save(status);
    }

    @Override
    public void deleteById(Long id) {
        if (!ticketStatusRepo.existsById(id))
            throw new RuntimeException("Ticket status not found: " + id);
        ticketStatusRepo.deleteById(id);
    }
}
