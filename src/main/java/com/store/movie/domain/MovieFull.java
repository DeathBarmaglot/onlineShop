package com.store.movie.domain;

import com.store.country.Country;
import com.store.gerne.domain.GenreDto;
import com.store.review.ReviewDto;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
public class MovieFull {
    private String movieId;
    private String nameTarget;
    private String nameOrigin;
    private String yearOfRelease;
    private double rating;
    private double price;
    private String picturePath;
    private String description;
    private Set<GenreDto> genres;
    private Set<Country> countries;
    private List<ReviewDto> reviews;
}
