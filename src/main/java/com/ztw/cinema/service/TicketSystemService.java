package com.ztw.cinema.service;

import com.ztw.cinema.dto.TicketRequest;
import com.ztw.cinema.entity.Ticket;

import java.util.List;

public interface TicketSystemService {

    public List<Ticket> reserveTicket(List<TicketRequest> ticketRequests, String authHeader);

    public List<Ticket> buyTicket(List<TicketRequest> ticketRequests, String authHeader);
}
