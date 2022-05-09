package com.store.movie.impl;
import com.store.movie.MovieRepository;
import com.store.movie.MovieService;
import com.store.movie.domain.Movie;
import com.store.movie.domain.MovieDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DefaultMovieService implements MovieService {
    final private ModelMapper modelMapper = new ModelMapper();
    final private MovieRepository movieRepository;

    public DefaultMovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public List<MovieDto> getAll() {
        List<Movie> movieList = movieRepository.findAll();
        return movieList.stream().map(movie ->
                modelMapper.map(movie, MovieDto.class))
                .collect(Collectors.toList());
    }

     @Override
     public List<MovieDto> getRandom() {
         List<Movie> movieList = movieRepository.getRandom();
         return movieList.stream().map(movie ->
                         modelMapper.map(movie, MovieDto.class))
                 .collect(Collectors.toList());
     }

     @Override
     public Optional<Movie> getByName(String name) {
//         return movieRepository.findByName(name);
         return null;
     }

     @Override
     public List<Movie> getByGenreId(Long id) {
//         return movieRepository.findMoviesByGenre(id);
         return null;
     }

    @Override
    public Optional<Movie> getById(Long id) {
        return movieRepository.findById(id);
    }
}
