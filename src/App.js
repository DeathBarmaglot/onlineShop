import axios from "axios";
import React from 'react';
import { Movies, Sliders } from './web/components';
import { useState, useEffect } from "react";
import "./App.css";

const App = () => {

  const [cart, setCart] = useState({});

  const fetchCart = async () => {
    axios
    .get("https://web-online-store.herokuapp.com/api/v1/movie/3832")
    .then((res) => {
     setCart(res.data);
    });
  };
  
const handleAddToCart = async(movieId, quantity) => {
  axios
  .post("https://web-online-store.herokuapp.com/api/v1/movie/{movieId}")
  .then((res) => {
   setCart(res.data);
  });
}

  useEffect(() => {
    fetchCart();
  }, []);

  return (
    <div className="App">
      <header className="App-header">
        <Movies carts = {cart} onAddToCart={handleAddToCart}/>
        <Sliders />
      </header>
    </div>
    
  );
};

export default App;
