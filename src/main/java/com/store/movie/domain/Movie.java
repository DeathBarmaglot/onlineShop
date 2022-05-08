package com.store.movie.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long movieId;
    private String nameTarget;
    private String nameOrigin;
    private String yearOfRelease;
    @Column(name = "description", length = 1024)
    private String description;
    private double rating;
    private double price;
    private String picturePath;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Movie movie = (Movie) o;
        return movieId != null && Objects.equals(movieId, movie.movieId);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "movieId = " + movieId + ", " +
                "nameNative = " + nameOrigin + ", " +
                "nameTranslate = " + nameTarget + ", " +
                "yearOfRelease = " + yearOfRelease + ", " +
                "rating = " + rating + ", " +
                "price = " + price + ", " +
                "description = " + description + ", " +
                "picturePath = " + picturePath + ")";
    }
}
