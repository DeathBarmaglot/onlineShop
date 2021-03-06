import React from 'react';
import { AppBar, Toolbar, IconButton, Typography } from '@material-ui/core';
import { ShoppingCart } from '@material-ui/icons';
import useStyles from '../Navbar/styles';
import logo from './logo.png';

const Navbar = () => {
  const classes = useStyles();

  return (
    <>
      <AppBar position="fixed" className={classes.appBar} color="inherit">
        <Toolbar>
          <Typography variant="h6" className={classes.title} color="textPrimary">
            <img src={logo} alt="MovieLand" height="20px" className="App-logo" /> 
            MovieLand
          </Typography>
          <div className={classes.grow} />
          <div className={classes.button}>
            <IconButton aria-label="Show cart items" color="default">
                <ShoppingCart />
            </IconButton>
          </div>
        </Toolbar>
      </AppBar>
    </>
  );
};

export default Navbar;