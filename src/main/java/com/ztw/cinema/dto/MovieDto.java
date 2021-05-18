package com.ztw.cinema.dto;

import java.sql.Date;

public class MovieDto {

    private Long id;

    private String name;

    private String director;

    private String description;

    private Date releaseDate;

    private Integer duration;

    public MovieDto() {
    }

    public MovieDto(Long id, String name, String director, String description, Date releaseDate, Integer duration) {
        this.id = id;
        this.name = name;
        this.director = director;
        this.description = description;
        this.releaseDate = releaseDate;
        this.duration = duration;
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

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }
}
