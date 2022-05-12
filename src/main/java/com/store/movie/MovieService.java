package com.store.movie;

import com.store.model.RequestProps;
import com.store.movie.domain.Movie;
import com.store.movie.domain.MovieDto;
import com.store.movie.domain.MovieFull;

import java.util.List;
import java.util.Optional;

public interface MovieService {

    List<MovieDto> getAll(RequestProps props);

    MovieFull getById(Long id);

    List<MovieDto> getRandom();

    Optional<Movie> getByName(String name);

    List<MovieDto> getByGenreId(Long id);
}
