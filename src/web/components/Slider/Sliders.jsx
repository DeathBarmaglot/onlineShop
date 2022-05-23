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

  return (
    <main>
      <div id="app">
        <div id="hero">
        </div>
        <Grid container justifyContent="center" spacing={0}>
          {movies.map((movie) => (
            <Grid item key={movie.imdbID} xs={5} md={2}>
              <Slider movie={movie}/>
            </Grid>
          ))}
        </Grid>
      </div>
    </main>
  );
};
export default Sliders;
