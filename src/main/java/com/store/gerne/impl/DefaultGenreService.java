package com.store.gerne.impl;

import com.store.gerne.GenreRepository;
import com.store.gerne.domain.Genre;
import com.store.gerne.domain.GenreDto;
import com.store.gerne.GenreService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DefaultGenreService implements GenreService {

    final private ModelMapper modelMapper = new ModelMapper();
    private final GenreRepository genreRepository;

    @Override
    public List<GenreDto> findAll() {
        List<Genre> genres = genreRepository.findAll();
        return genres.stream().map(genre ->
                        modelMapper.map(genre, GenreDto.class))
                .collect(Collectors.toList());
    }
}