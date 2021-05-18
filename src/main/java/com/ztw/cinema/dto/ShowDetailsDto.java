package com.ztw.cinema.dto;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

public class ShowDetailsDto {

    private Long id;

    private Date date;

    private Time time;

    private HallDto hall;

    private MovieDto movie;

    private List<SeatDto> seats;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public HallDto getHall() {
        return hall;
    }

    public void setHall(HallDto hall) {
        this.hall = hall;
    }

    public MovieDto getMovie() {
        return movie;
    }

    public void setMovie(MovieDto movie) {
        this.movie = movie;
    }

    public List<SeatDto> getSeats() {
        return seats;
    }

    public void setSeats(List<SeatDto> seats) {
        this.seats = seats;
    }
}
