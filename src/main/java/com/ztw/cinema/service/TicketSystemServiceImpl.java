package com.ztw.cinema.service;

import com.ztw.cinema.dto.TicketRequest;
import com.ztw.cinema.entity.Ticket;
import com.ztw.cinema.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TicketSystemServiceImpl implements TicketSystemService {

    private final TicketService ticketService;
    private final ShowService showService;
    private final SeatService seatService;
    private final TicketTypeService ticketTypeService;
    private final TicketStatusService ticketStatusService;
    private final UserService userService;
    private final JwtUtil jwtUtil;
    private final Long reservedStatusId = 1L;
    private final Long paidStatusId = 2L;

    @Autowired
    public TicketSystemServiceImpl(TicketService ticketService, ShowService showService, SeatService seatService, TicketTypeService ticketTypeService, TicketStatusService ticketStatusService, UserService userService, JwtUtil jwtUtil) {
        this.ticketService = ticketService;
        this.showService = showService;
        this.seatService = seatService;
        this.ticketTypeService = ticketTypeService;
        this.ticketStatusService = ticketStatusService;
        this.jwtUtil = jwtUtil;
        this.userService = userService;
    }

    public List<Ticket> processTicket(List<TicketRequest> ticketRequests, String authHeader, Long statusId) {
        List<Ticket> tickets = new ArrayList<>();

        for (TicketRequest ticketRequest : ticketRequests) {
            Ticket ticket = new Ticket();
            ticket.setId(ticketRequest.getId());
            ticket.setShow(showService.findById(ticketRequest.getShowId()));
            ticket.setSeat(seatService.findById(ticketRequest.getSeatId()));
            ticket.setUser(userService.findByUsername(getUsernameFromAuthHeader(authHeader)));
            ticket.setTicketType(ticketTypeService.findById(ticketRequest.getTicketTypeId()));
            ticket.setTicketStatus(ticketStatusService.findById(statusId));

            tickets.add(ticketService.add(ticket));
        }

        return tickets;
    }

    @Override
    public List<Ticket> reserveTicket(List<TicketRequest> ticketRequests, String authHeader) {
        return processTicket(ticketRequests, authHeader, reservedStatusId);
    }

    @Override
    public List<Ticket> buyTicket(List<TicketRequest> ticketRequests, String authHeader) {
        return processTicket(ticketRequests, authHeader, paidStatusId);
    }

    private String getUsernameFromAuthHeader(String authHeader) {
        String token = authHeader.substring(7);
        return jwtUtil.extractUsername(token);
    }
}
