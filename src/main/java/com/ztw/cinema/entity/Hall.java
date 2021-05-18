package com.ztw.cinema.entity;

import javax.persistence.*;

@Entity
public class Hall {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    private String name;

    private Integer totalSeats;

//    @OneToMany(cascade=CascadeType.ALL)
//    @JoinColumn(name="hall_id")
//    private Collection<Seat> seats;

    public Hall() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(Integer totalSeats) {
        this.totalSeats = totalSeats;
    }

//    public Collection<Seat> getSeats() {
//        return seats;
//    }
//
//    public void setSeats(Collection<Seat> seats) {
//        this.seats = seats;
//    }
}
