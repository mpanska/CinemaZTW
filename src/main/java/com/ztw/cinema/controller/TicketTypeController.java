package com.ztw.cinema.controller;

import com.ztw.cinema.service.TicketTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ticketTypes")
public class TicketTypeController {

    private final TicketTypeService ticketTypeService;

    @Autowired
    public TicketTypeController(TicketTypeService ticketTypeService) {
        this.ticketTypeService = ticketTypeService;
    }

    @GetMapping
    public ResponseEntity<?> getTicketTypes() {
        return new ResponseEntity<>(ticketTypeService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getTicketType(@PathVariable Long id) {
        return new ResponseEntity<>(ticketTypeService.findById(id), HttpStatus.OK);
    }
}
