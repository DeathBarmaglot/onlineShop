package com.store.movie;

import com.store.movie.domain.Movie;
import com.store.movie.impl.DefaultMovieService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping(path = {"/", "/api/v1/movies"}, produces = MediaType.APPLICATION_JSON_VALUE)
public class MovieController {

    private static final Logger logger = LoggerFactory.getLogger(MovieController.class);
    private final DefaultMovieService movieService;

    public MovieController(DefaultMovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public List<Movie> getAll() {
        List<Movie> all = movieService.getAll();
        logger.info("get {} movies from db", all.size());
        return all;
    }

    @GetMapping("/{movieId}")
    public Optional<Movie> getMovieById(
            @PathVariable(value = "movieId") Long id) {
        logger.info("get movie by id:{} from db", id);
        return movieService.getById(id);
    }
}