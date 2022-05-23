package com.store.utils;

import com.store.country.Country;
import com.store.gerne.domain.Genre;
import com.store.movie.domain.Movie;
import com.store.review.Review;
import com.store.user.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.store.utils.FileReader.readUFromUrl;

@Slf4j
@RequiredArgsConstructor
public class Parser {

    public static List<User> parserUser() {
        String fileName = "https://trello.com/1/cards/5c7d3c9c8d6ddf776c2d3dde/attachments/5c7d3c9d8d6ddf776c2d3e11/download/user.txt";
        List<String> rows = readUFromUrl(fileName);
        List<User> users = new ArrayList<>();
        User user = new User();

        for (int i = 0; i < rows.size(); i++) {
            if (i % 3 == 0) {
                user = new User();
                user.setNickname(rows.get(i));
            } else if (i % 3 == 1) {
                user.setEmail(rows.get(i));
            } else if (i % 3 == 2) {
                user.setPassword(rows.get(i));
                users.add(user);
            }
        }
        return users;
    }

    public static List<Movie> parserMovie() {
        String fileName = "https://trello.com/1/cards/5c7d3c9c8d6ddf776c2d3dde/attachments/5c7d3c9d8d6ddf776c2d3e0b/download/movie.txt";
        List<String> rows = readUFromUrl(fileName);
        List<Movie> movies = new ArrayList<>();
        Movie movie = new Movie();

        for (int i = 0; i < rows.size(); i++) {
            if (i % 7 == 0) {
                movie = new Movie();
                String[] split = rows.get(i).split("/");
                movie.setNameTarget(split[0]);
                movie.setNameOrigin(split[1]);

            } else if (i % 7 == 1) {
                movie.setYearOfRelease(rows.get(i));

            } else if (i % 7 == 2) {
                Country country = new Country();
                Set<Country> countries = new HashSet<>();
                String s = rows.get(i);
                country.setCountryName(s);
                countries.add(country);
                movie.setCountries(countries);

//            } else if (i % 7 == 3) {
//                String[] split = rows.get(i).split(", ");
//                List<Genre> set = new ArrayList<>();
//                for (String s : split) {
//                    Genre genre = new Genre();
//                    genre.setName(s);
//                    set.add(genre);
//                }
//                movie.setGenres(set);

            } else if (i % 7 == 4) {
                movie.setDescription(rows.get(i));

            } else if (i % 7 == 5) {
                String row = rows.get(i).split(":")[1];
                movie.setRating(Double.parseDouble(row));

            } else if (i % 7 == 6) {
                String row = rows.get(i).split(":")[1];
                movie.setPrice(Double.parseDouble(row));
                movies.add(movie);
            }
        }

        return movies;
    }

    public static Iterable<Genre> parserGenre() {
        String fileName = "https://trello.com/1/cards/5c7d3c9c8d6ddf776c2d3dde/attachments/5c7d3c9d8d6ddf776c2d3e09/download/genre.txt";
        List<String> rows = readUFromUrl(fileName);
        List<Genre> genres = new ArrayList<>();

        for (String row : rows) {
            Genre genre = new Genre();
            genre.setName(row);
            genres.add(genre);
        }
        return genres;
    }

//    public static List<Review> parserReview() {
//        String fileName = "https://trello.com/1/cards/5c7d3c9c8d6ddf776c2d3dde/attachments/5c7d3c9d8d6ddf776c2d3e0f/download/review.txt";
//        List<String> rows = readUFromUrl(fileName);
//        List<Review> reviews = new ArrayList<>();
//        Review review = new Review();
//
//        for (int i = 0; i < rows.size(); i++) {
//            if (i % 3 == 0) {
//                review = new Review();
//                review.setMovieName(rows.get(i));
//            } else if (i % 3 == 1) {
//                rows.get(i)
//                review.setUserName();
//            } else if (i % 3 == 2) {
//                review.setText(rows.get(i));
//                reviews.add(review);
//            }
//        }
//        return reviews;
//    }

}
