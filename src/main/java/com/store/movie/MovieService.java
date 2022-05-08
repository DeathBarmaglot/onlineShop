package com.store.movie;

import com.store.movie.domain.Movie;
import com.store.movie.domain.MovieDto;

import java.util.List;
import java.util.Optional;

public interface MovieService {

    List<Movie> getAll();

    Optional<Movie> getById(Long id);

    // Iterable<Movie> getRandom();

    // Optional<Movie> getByName(String name);

    // Iterable<Movie> getByGenreId(Long id);


}
