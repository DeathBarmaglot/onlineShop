import React, { useEffect } from 'react'
import './App.css';
import axios from 'axios';
import Movie from "./components/Movies/Movies";
// import Navbar from './components/Navbar/Navbar';

const UserProfile = () => {

  const fetchUserProfiles = () => {
    axios.get("http://localhost:8080/").then(res =>{
      console.log(res)})    
  }

  useEffect(() => {
    fetchUserProfiles();
  }, [])
  return <h1>Online Store</h1>
}


const App = () => {
  return (
    <div className="App">
      <header className="App-header">
        <Movie />
        <UserProfile />
      </header>
    </div>
  );
}
export default App;