package com.store.movie;

import com.store.movie.domain.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    @Override
    Optional<Movie> findById(Long id);

    @Override
    List<Movie> findAll();
}
