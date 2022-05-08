import axios from "axios";
import React, { useState, useEffect } from "react";
import Movie from './Movie';
import useStyles from './styles';
import {Grid} from '@material-ui/core';

const Movies = () => {

const [movies, setMovies] = useState([]);

const fetchMovies = () => {
  axios
    .get("https://web-online-store.herokuapp.com/api/v1/movies")
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
      <div className={classes.toolbar}></div>
      <Grid container justifyContent="center" spacing={2}>
        {movies.map((movie) => (
          <Grid item key={movie.movieId} xs={10} md={5} lg={4}>
             <Movie movie={movie}/>
          </Grid>
        ))}
     </Grid>
    </main>
  );
};

export default Movies;