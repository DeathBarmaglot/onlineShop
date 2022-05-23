import React from 'react'
import { Card, CardMedia, CardContent, CardActions, Typography, IconButton } from '@material-ui/core';
import { AddShoppingCart } from '@material-ui/icons';
import useStyles from './styles';

const Movie = ({movie, onAddToCart}) => {
const classes = useStyles();

 console.log(movie)

  return (
    <div>
   <Card className={classes.root}>
          <CardMedia className={classes.media} image={movie.picturePath} title={movie.nameTarget} />
          <CardContent>
            <div key={movie.movieId} className={classes.cardContent}>
              <Typography gutterBottom variant="h5">
                {movie.nameTarget}
              </Typography>
              <Typography gutterBottom variant="h5">
                ${movie.price}
              </Typography>
            </div>
            <Typography variant="body2" color="textSecondary">{movie.nameOrigin}</Typography>
          </CardContent>
          <CardActions disableSpacing className={classes.cardActions}>
            <IconButton aria-label="Add to Cart" onClick={() => onAddToCart(movie.movieId, 1)}>
              <AddShoppingCart />
            </IconButton>
          </CardActions>
        </Card>
    </div>
  )
}

export default Movie;
