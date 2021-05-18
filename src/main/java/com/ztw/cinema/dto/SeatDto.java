package com.ztw.cinema.dto;

public class SeatDto {

    private Long id;

    private Integer number;

    private String row;

    private Boolean isAvailable;

    public SeatDto() {
    }

    public SeatDto(Long id, Integer number, String row, Boolean isAvailable) {
        this.id = id;
        this.number = number;
        this.row = row;
        this.isAvailable = isAvailable;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getRow() {
        return row;
    }

    public void setRow(String row) {
        this.row = row;
    }

    public Boolean getAvailable() {
        return isAvailable;
    }

    public void setAvailable(Boolean available) {
        isAvailable = available;
    }
}
