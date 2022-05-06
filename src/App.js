import React from 'react'
import './App.css';
import Products from "./components/Products/Products";
// import Navbar from './components/Navbar/Navbar';

const App = () => {
  return (
    <div className="App">
      <header className="App-header">
        <Products />
      </header>
    </div>
  );
}
export default App;