package com.store.movie.domain;

import lombok.Data;

@Data
public class MovieThin {
    private String movieId;
    private String nameTarget;
    private String nameOrigin;
    private String yearOfRelease;
    private double rating;
    private double price;
    private String picturePath;
}

