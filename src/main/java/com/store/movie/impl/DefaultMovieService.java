package com.store.movie.impl;
import com.store.movie.MovieRepository;
import com.store.movie.MovieService;
import com.store.movie.domain.Movie;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DefaultMovieService implements MovieService {

    final private MovieRepository movieRepository;

    public DefaultMovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public List<Movie> getAll() {
        return movieRepository.findAll();
    }

    // @Override
    // public Iterable<Movie> getRandom() {
    //     return movieRepository.getRandom();
    // }

    // @Override
    // public Optional<Movie> getByName(String name) {
    //     return movieRepository.findByName(name);
    // }

    // @Override
    // public Iterable<Movie> getByGenreId(Long id) {
    //     return movieRepository.findMoviesByGenre(id);
    // }

    @Override
    public Optional<Movie> getById(Long id) {
        return movieRepository.findById(id);
    }
}
