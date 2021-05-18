package com.ztw.cinema.service;

import com.ztw.cinema.dto.HallDto;
import com.ztw.cinema.dto.MovieDto;
import com.ztw.cinema.dto.SeatDto;
import com.ztw.cinema.dto.ShowDetailsDto;
import com.ztw.cinema.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShowDetailsServiceImpl implements ShowDetailsService{

    private final ShowService showService;
    private final SeatService seatService;
    private final TicketService ticketService;

    @Autowired
    public ShowDetailsServiceImpl(ShowService showService, SeatService seatService, TicketService ticketService) {
        this.showService = showService;
        this.seatService = seatService;
        this.ticketService = ticketService;
    }

    @Override
    public ShowDetailsDto findById(Long id) {
        ShowDetailsDto showDetails = new ShowDetailsDto();
        List<SeatDto> seatDtos = new ArrayList<>();

        Show show = showService.findById(id);
        Hall hall = show.getHall();
        Movie movie = show.getMovie();
        List<Seat> seats = new ArrayList<>(seatService.findAllByHallId(hall.getId()));
        List<Ticket> tickets = new ArrayList<>(ticketService.findByShowId(id));

        showDetails.setId(show.getId());
        showDetails.setDate(show.getDate());
        showDetails.setTime(show.getTime());
        showDetails.setHall(new HallDto(hall.getId(), hall.getName(), hall.getTotalSeats()));
        showDetails.setMovie(new MovieDto(movie.getId(), movie.getName(), movie.getDirector(), movie.getDescription(), movie.getReleaseDate(), movie.getDuration()));

        for (Seat seat : seats) {
            SeatDto seatDto = new SeatDto(seat.getId(), seat.getNumber(), seat.getRow(), true);
            for (Ticket ticket : tickets)
                if (ticket.getSeat().getId().equals(seatDto.getId())) {
                    seatDto.setAvailable(false);
                    tickets.remove(ticket);
                    break;
                }
            seatDtos.add(seatDto);
        }

        showDetails.setSeats(seatDtos);

        return showDetails;
    }
}
