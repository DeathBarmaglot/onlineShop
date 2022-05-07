package com.store.movie;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MovieRowMapper implements RowMapper<Movie> {
   @Override
   public Movie mapRow(ResultSet resultSet, int i) throws SQLException {
      Movie movie = new Movie();
      movie.setMovieId(resultSet.getLong("id"));
      movie.setNameTranslate(resultSet.getString("name"));
      return movie;
   }
}
