package com.store.movie;

import com.store.movie.domain.Movie;
import com.store.movie.domain.MovieDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    @Override
    Optional<Movie> findById(Long id);

    @Override
    List<Movie> findAll();

    @Query(nativeQuery=true, value = "SELECT movie_id, name_target, name_origin, description, year_of_release, rating, price, picture_path FROM movie " +
            "WHERE movie_id IN (SELECT movie_id FROM movie ORDER BY random() LIMIT 3)")
    List<Movie> getRandom();
}
