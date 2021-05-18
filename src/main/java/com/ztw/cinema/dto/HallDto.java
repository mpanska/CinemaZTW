package com.ztw.cinema.dto;

public class HallDto {

    private Long id;

    private String name;

    private Integer totalSeats;

    public HallDto() {
    }

    public HallDto(Long id, String name, Integer totalSeats) {
        this.id = id;
        this.name = name;
        this.totalSeats = totalSeats;
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
}
