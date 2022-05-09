package com.store.movie.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

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

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name = "movie_genre",
            joinColumns = {@JoinColumn(name = "movie_id")},
            inverseJoinColumns = {@JoinColumn(name = "genre_id")})
    private Set<com.store.gerne.domain.Genre> genres;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Movie movie = (Movie) o;
        return !(movie.getMovieId() == null || getMovieId() == null) && Objects.equals(getMovieId(), movie.getMovieId());
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
