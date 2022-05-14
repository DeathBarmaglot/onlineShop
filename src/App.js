import React from 'react';
import {Navbar, Movies, Sliders } from './web/components';

import "./App.css";

const App = () => {


  return (
    <div className="App">
      <header className="App-header">
        <Navbar />
        <Movies />
        {/* <Sliders /> */}
      </header>
    </div>
  );
};

export default App;
