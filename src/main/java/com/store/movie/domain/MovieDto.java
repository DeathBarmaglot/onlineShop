package com.store.movie.domain;

import lombok.Data;

@Data
public class MovieDto {
    private Long movieId;
    private String nameTarget;
    private String nameOrigin;
    private String yearOfRelease;
    private double rating;
    private double price;
    private String picturePath;
}
