package com.store.movie;

import lombok.Data;

@Data
class Movie {
    private Long movieId;
    private String nameTranslate;
    private String nameNative;
    private String yearOfRelease;
    private String description;
    private double rating;
    private double price;
    private String picturePath;
}
