package com.store.movie;

import com.store.model.RequestProps;
import com.store.model.SortDirection;
import com.store.model.currency.DefaultExchangeService;
import com.store.movie.domain.MovieDto;
import com.store.movie.domain.MovieFull;
import com.store.movie.impl.DefaultMovieService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequiredArgsConstructor
@RequestMapping(path = {"/", "/api/v1/movie"}, produces = MediaType.APPLICATION_JSON_VALUE)
public class MovieController {

    private static final Logger logger = LoggerFactory.getLogger(MovieController.class);
    private final DefaultMovieService movieService;

    @GetMapping
    public List<MovieDto> getAll(
            @RequestParam(value = "rating", required = false) SortDirection rating,
            @RequestParam(value = "price", required = false) SortDirection price) {
        RequestProps props = RequestProps.builder().rating(rating).price(price).build();
        List<MovieDto> moviesDto = movieService.getAll(props);
        logger.info("Get {} movies, sorted by {}", moviesDto.size(), props);
        return moviesDto;
    }

    @GetMapping("/{movieId}")
    public ResponseEntity<MovieFull> getMovieById(
            @PathVariable(value = "movieId") Long id,
            @RequestParam(value = "currency", required = false) String currency) {
        logger.info("Get movie by id#{} from Database and price exchange by {}", id, currency);
        RequestProps props = RequestProps.builder().currency(currency).id(id).build();
        return new ResponseEntity(movieService.getById(props), HttpStatus.OK);
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