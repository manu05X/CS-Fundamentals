package com.manish.LLD.BookMyShow.Part1.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Genre {
    private String genreId;
    private String name;

    public Genre(String name) {
        this.genreId = java.util.UUID.randomUUID().toString();;
        this.name = name;
    }

    public String getGenreId() {
        return genreId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
