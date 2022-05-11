package com.store.gerne.impl;

import com.store.gerne.GenreService;
import com.store.gerne.domain.GenreDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Primary
@Service
@RequiredArgsConstructor
public class CachedGenreService implements GenreService {

    private final DefaultGenreService genreService;
    private volatile List<GenreDto> genreCache = new ArrayList<>();

    @Override
    public List<GenreDto> findAll() {
        log.info("Get cached list");
        return new ArrayList<>(genreCache);
    }

    @Scheduled(cron = "0 0 0/3 * * ?")
    public void update() {
        genreCache.clear();
        refresh();
        log.info("Genre cache refreshed");
    }

    @PostConstruct
    public void refresh() {
        genreCache = genreService.findAll();
    }
}
