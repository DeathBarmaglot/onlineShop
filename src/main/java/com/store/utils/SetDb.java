package com.store.utils;

import com.store.gerne.impl.DefaultGenreService;
import com.store.movie.impl.DefaultMovieService;
import com.store.review.impl.DefaultReviewService;
import com.store.user.User;
import com.store.user.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.store.utils.Parser.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/v1/db")
public class SetDb {
    private final DefaultMovieService movieService;
//    private final DefaultPosterService posterService;
    private final DefaultGenreService genreService;
    private final DefaultReviewService reviewService;
    private final UserRepository userRepository;

//    @GetMapping("/review")
//    public List<Review> addReviews() {
//        List<Review> reviews = parserReview();
//        reviewService.saveAll(reviews);
//        return reviews;
//    }

    @GetMapping("/user")
    public Iterable<User> addUsers() {
        List<User> users = parserUser();
        return userRepository.saveAll(users);
    }

//    @GetMapping("/genre")
//    public Iterable<Genre> addGenres() {
//        Iterable<Genre> genres = parserGenre();
//        return genreService.saveAll(genres);
//    }

//    @GetMapping("/poster")
//    public Iterable<Poster> addPoster() {
//        String fileName = "https://trello.com/1/cards/5c7d3c9c8d6ddf776c2d3dde/attachments/5c7d3c9d8d6ddf776c2d3e0d/download/poster.txt";
//        List<String> rows = readUFromUrl(fileName);
//        List<Poster> posters = new ArrayList<>();
//        Poster poster = new Poster();
//        for (String row : rows) {
//            String[] split = row.split(" https:");
//            Movie movie = movieService.findByNameTranslate(split[0]).get();
//            String link = "https:" + split[1];
//            poster.setNameTranslate(split[0]);
//            poster.setPicturePath(link);
//            posters.add(poster);
//            movie.setPicturePath(poster.getPicturePath());
//            movie.setPicturePath(link);
//            Movie save = movieService.save(movie);
//            log.info("{} is Saved", movie);
//            log.info("{}", save);
//        }
//        return posterService.saveAll(posters);
//    }

}