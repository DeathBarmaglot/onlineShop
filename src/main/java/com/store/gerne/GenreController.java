package com.store.gerne;

import com.store.gerne.domain.GenreDto;
import com.store.gerne.impl.DefaultGenreService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "api/v1/genre")
public class GenreController {

    private final DefaultGenreService genreService;

    @GetMapping()
    public List<GenreDto> getAll() {
        return genreService.findAll();
    }
}