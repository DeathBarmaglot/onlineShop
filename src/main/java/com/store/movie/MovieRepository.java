package com.store.movie;

import com.store.movie.domain.Movie;
import com.store.movie.domain.MovieFull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    Optional<Movie> findByMovieId(Long id);

    @Override
    List<Movie> findAll();

    @Query(nativeQuery = true, value = "SELECT movie_id, name_target, name_origin, description, year_of_release, rating, price, picture_path " +
            "FROM movie WHERE movie_id IN (SELECT movie_id FROM movie ORDER BY random() LIMIT 3);")
    List<Movie> getRandom();

    Optional<Movie> findByNameTarget(String name);

    @Query(nativeQuery = true, value = "SELECT movie.movie_id, name_target, name_origin, description, year_of_release, rating, price, picture_path " +
            "FROM movie LEFT JOIN movie_genre ON movie_genre.movie_id = movie.movie_id WHERE movie_genre.genre_id=?;")
    List<Movie> findMoviesByGenreId(Long id);


    @Query(nativeQuery = true, value = "SELECT mg.movie_id, m.name_target, m.name_origin, m.year_of_release, m.description, " +
            "m.rating, m.price, m.picture_path, mc.country_id, c.country_name, " +
            "mg.genre_id, g.name, r.review_id, r.movie_id, r.text " +
            "FROM movie m " +
            "LEFT JOIN movie_countries AS mc ON (m.movie_id = mc.movie_id)" +
            "LEFT JOIN country AS c ON (mc.country_id = c.country_id)" +
            "LEFT JOIN movie_genre AS mg ON (mc.movie_id = mg.movie_id)" +
            "LEFT JOIN genre AS g ON (mg.genre_id = g.genre_id)" +
            "LEFT JOIN review AS r ON (mg.movie_id = r.movie_id)" +
            "WHERE m.movie_id = ?;")
    Optional<Movie> getMovieByMovieId(Long id);

}
