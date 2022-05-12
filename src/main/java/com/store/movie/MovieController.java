package com.store.movie;

import com.store.model.RequestProps;
import com.store.model.SortDirection;
import com.store.movie.domain.MovieDto;
import com.store.movie.domain.MovieFull;
import com.store.movie.impl.DefaultMovieService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping(path = {"/", "/api/v1/movie"}, produces = MediaType.APPLICATION_JSON_VALUE)
public class MovieController {

    private static final Logger logger = LoggerFactory.getLogger(MovieController.class);
    private final DefaultMovieService movieService;

    public MovieController(DefaultMovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public List<MovieDto> getAll(
            @RequestParam(value = "id", required = false) SortDirection id,
            @RequestParam(value = "rating", required = false) SortDirection rating,
            @RequestParam(value = "price", required = false) SortDirection price) {
        RequestProps props = RequestProps.builder().rating(rating).price(price).id(id).build();
        List<MovieDto> moviesDto = movieService.getAll(props);
        logger.info("Get {} movies, sorted by {}", moviesDto.size(), props);
        return moviesDto;
    }

    @GetMapping("/{movieId}")
    public MovieFull getMovieById(@PathVariable(value = "movieId") Long id) {
        logger.info("Get movie by id#{} from Database", id);
        return movieService.getById(id);
    }

    @GetMapping(path = "/random")
    public List<MovieDto> getRandom() {
        List<MovieDto> randoms = movieService.getRandom();
        logger.info("Get random {} movies", randoms.size());
        return randoms;
    }

    @GetMapping("/genre/{genreId}")
    public List<MovieDto> getMoviesByGenreId(@PathVariable(value = "genreId") Long id) {
        List<MovieDto> moviesByGenre = movieService.getByGenreId(id);
        logger.info("get {} movies by genre# {}", moviesByGenre.size(), id);
        return moviesByGenre;
    }
}