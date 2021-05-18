package com.ztw.cinema.controller;

import com.ztw.cinema.dto.TicketRequest;
import com.ztw.cinema.service.TicketSystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@PreAuthorize("hasRole('USER')")
@RestController
@RequestMapping("/api")
public class TicketSystemController {

    private final TicketSystemService ticketSystemService;

    @Autowired
    public TicketSystemController(TicketSystemService ticketSystemService) {
        this.ticketSystemService = ticketSystemService;
    }

    @PostMapping("/reserveTicket")
    public ResponseEntity<?> reserveTicket(@RequestHeader("Authorization") String authHeader, @RequestBody List<TicketRequest> request) {
        return new ResponseEntity<>(ticketSystemService.reserveTicket(request, authHeader), HttpStatus.CREATED);
    }

    @PostMapping("/buyTicket")
    public ResponseEntity<?> buyTicket(@RequestHeader("Authorization") String authHeader, @RequestBody List<TicketRequest> request) {
        return new ResponseEntity<>(ticketSystemService.buyTicket(request, authHeader), HttpStatus.CREATED);
    }
}
