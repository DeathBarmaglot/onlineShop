import React from 'react';
import { Card, CardMedia, CardContent, CardActions, Typography, IconButton } from '@material-ui/core';
import { AddShoppingCart } from '@material-ui/icons';

import useStyles from '../styles';

const Movie = ({ movie }) => {
  const classes = useStyles();

  return (
    <Card className={classes.root}>
      <CardMedia className={classes.media} image={movie.image} title={movie.name} />
      <CardContent>
        <div className={classes.cardContent}>
          <Typography gutterBottom variant="h5">
            {movie.name}
          </Typography>
          <Typography gutterBottom variant="h5">
            ${movie.price}
          </Typography>
        </div>
        <Typography variant="body2" color="textSecondary">{movie.description}</Typography>
      </CardContent>
      <CardActions disableSpacing className={classes.cardActions}>
        <IconButton aria-label="Add to Cart" onClick=''>
          <AddShoppingCart />
        </IconButton>
      </CardActions>
    </Card>
  );
};

export default Movie;