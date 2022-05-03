package com.store.movie.impl;

import com.store.model.RequestProps;
import com.store.model.currency.DefaultExchangeService;
import com.store.movie.MovieRepository;
import com.store.movie.MovieService;
import com.store.movie.domain.Movie;
import com.store.movie.domain.MovieDto;
import com.store.movie.domain.MovieFull;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DefaultMovieService implements MovieService {
    final private ModelMapper modelMapper = new ModelMapper();
    final private MovieRepository movieRepository;
    final private DefaultExchangeService exchangeService;

    @Override
    public List<MovieDto> getAll(RequestProps props) {
        List<Movie> movieList = movieRepository.findAll(Sort.by(props.getOrder()));
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
        return movieRepository.findByNameTarget(name);
    }

    @Override
    public List<MovieDto> getByGenreId(Long id) {
        List<Movie> moviesByGenre = movieRepository.findMoviesByGenreId(id);
        return moviesByGenre.stream().map(movie ->
                        modelMapper.map(movie, MovieDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public MovieFull getById(RequestProps props) {
        Movie movie = movieRepository.getMovieByMovieId(props.getId()).orElseThrow();
        Double exchange = exchangeService.exchange(movie.getPrice(), props.getCurrency());
        movie.setPrice(exchange);
        return modelMapper.map(movie, MovieFull.class);
    }
}
