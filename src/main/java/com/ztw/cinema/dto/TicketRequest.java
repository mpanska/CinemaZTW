package com.ztw.cinema.dto;

public class TicketRequest {

    private Long id;

    private Double price;

    private Long showId;

    private Long seatId;

    private Long ticketTypeId;

    public Long getId() {
        return id;
    }

    public Double getPrice() {
        return price;
    }

    public Long getShowId() {
        return showId;
    }

    public Long getSeatId() {
        return seatId;
    }

    public Long getTicketTypeId() {
        return ticketTypeId;
    }
}
