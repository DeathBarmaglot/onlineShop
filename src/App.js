import axios from "axios";
import React from 'react';
import { Movies, Navbar } from './web/components';
import { useState, useEffect } from "react";
import "./App.css";

const App = () => {
  const [cart, setCart] = useState({});

  const fetchCart = async () => {
    axios
    .get("https://web-online-store.herokuapp.com/api/v1/movie/3815")
    .then((res) => {
      setCart(res.data);
    });
  };
  
  useEffect(() => {
    fetchCart();
  }, []);

  console.log(cart)

  return (
    <div className="App">
      <header className="App-header">
        <Navbar />
        <div id="app">
        <div id="hero">
          <h1>Movie Land</h1>
          </div>

    </div>
        <Movies />
      </header>
    </div>
  );
};

export default App;
