import React from 'react'
import { Card, CardMedia, CardContent, CardActions, Typography, IconButton } from '@material-ui/core';
import { AddShoppingCart } from '@material-ui/icons';
import useStyles from './styles';

const Slider = ({movie}) => {

  const classes = useStyles();
  console.log(movie)

return (
  <div>
 <Card className={classes.root}>
        <CardMedia className={classes.media} image={movie.Poster} title={movie.Title} />
        <CardContent>
          <div key={movie.movieId} className={classes.cardContent}>
            <Typography gutterBottom variant="h5">
              {movie.Title}
            </Typography>
          </div>
          <Typography variant="body2" color="textSecondary">{movie.nameOrigin}</Typography>
        </CardContent>
        <CardActions disableSpacing className={classes.cardActions}>
          <IconButton aria-label="Add to Cart">
            <AddShoppingCart />
          </IconButton>
        </CardActions>
      </Card>
  </div>
)
}

export default Slider;
