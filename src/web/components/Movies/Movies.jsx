import axios from "axios";
import React, { useState, useEffect } from "react";
import Movie from "./Movie";
import useStyles from "./styles";
import { Grid } from "@material-ui/core";

const Movies = () => {
  const [movies, setMovies] = useState([]);

  const fetchMovies = () => {
    axios
      .get("https://web-online-store.herokuapp.com/api/v1/movie/random")
      .then((res) => {
        setMovies(res.data);
      });
  };

  useEffect(() => {
    fetchMovies();
  }, []);

  const classes = useStyles();

  return (
    <main className={classes.content}>      
      <div id="app">
        <div id="icons">
              <i className="fa fa-apple" id="apple"></i>
              <i className="fa fa-linkedin-square" id="twitter"></i>
              <i className="fa fa-github-square github" id="github"></i>
              <i className="fa fa-facebook-square" id="facebook"
                href="https://www.facebook.com/deathbarmaglot"></i>
        </div>
        <div className={classes.toolbar}></div>
        <div id="hero">
          <h1 className="disappear">
            <span>M</span>
            <span>o</span>
            <span>v</span>
            <span>i</span>
            <span>E</span> <span>L</span>
            <span>A</span>
            <span>n</span>
            <span>D</span>

          </h1>
        </div>
        <Grid container justifyContent="center" spacing={2}>
          {movies.map((movie) => (
            <Grid item key={movie.movieId} xs={10} md={3}>
              <Movie movie={movie} />
            </Grid>
          ))}
        </Grid>
      </div>
    </main>
  );
};

export default Movies;
