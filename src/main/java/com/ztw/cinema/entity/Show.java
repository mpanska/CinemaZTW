package com.ztw.cinema.entity;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

@Entity
public class Show {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    private Date date;

    private Time time;

    @ManyToOne
    @JoinColumn(name="hall_id")
    private Hall hall;

    @ManyToOne
    @JoinColumn(name="movie_id")
    private Movie movie;

    public Show() {
    }

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

    public Hall getHall() {
        return hall;
    }

    public void setHall(Hall hall) {
        this.hall = hall;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }
}
