package com.store.movie;

import java.util.List;
import java.util.Optional;

public interface MovieDao {
    List<Movie> selectMovies();
    int insertMovie(Movie movie);
    int deleteMovie(Long id);
    Optional<Movie> selectMovieById(Long id);
}
