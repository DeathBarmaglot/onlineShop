import React from 'react';
import { Movies, Sliders } from './web/components';
import "./App.css";

const App = () => {

  return (
    <div className="App">
 {/* <Navbar /> */}
<header className="App-header">
<Movies />
<Sliders />
</header>
</div>

  );
};

export default App;
