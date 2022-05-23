import Movie from "./Movie";
import React from "react";

const MovieList = () => {
  return (
    <>
      {props.movie.map((movie, index) => (
        <div>
          <img src={Movie.Poster} alt="movie"></img>
        </div>
      ))}
    </>
  );
};

export default MovieList;
