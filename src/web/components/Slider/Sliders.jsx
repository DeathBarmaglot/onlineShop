import useStyles from "./styles";
import axios from "axios";
import React, { useState, useEffect } from "react";
import Slider from "./Slider";
import { Grid } from "@material-ui/core";

const Sliders = () => {

  const [movies, setMovies] = useState([]);

  const fetchMovies = () => {
    axios
    .get("http://www.omdbapi.com/?s=spider&apikey=c0bf5d80")
      .then((res) => {
        setMovies(res.data.Search);
      });
  };

  useEffect(() => {
    fetchMovies();
  }, []);

  const classes = useStyles();

  return (
    <main className={classes.content}>
      <div id="app">
        <div id="hero">
          <h1>Movie Land</h1>
        </div>

        <Grid container justifyContent="center" spacing={2}>
          {movies.map((movie) => (
            <Grid item key={movie.movieId} xs={10} md={3}>
              <Slider movie={movie} />
            </Grid>
          ))}
        </Grid>
      </div>
    </main>
  );
};
export default Sliders;
