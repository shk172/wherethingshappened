import React, { Component } from 'react';
import ReactMapboxGl, { Layer, Feature } from "react-mapbox-gl";

import logo from './logo.svg';
import './App.css';

class App extends Component {
  render() {
    const Map = ReactMapboxGl({
      accessToken: 'pk.eyJ1Ijoic2hrMTcyIiwiYSI6ImNqNTBpMzBtZDA0emEyd3Btdm0yanZiNHQifQ.1VKCHBk0__216jznAfBMoQ'
    });

    return (
      <div className="App">
        <div className="App-header">
          <img src={logo} className="App-logo" alt="logo" />
          <h2>Welcome to React</h2>
        </div>
        <Map
          style='mapbox://styles/mapbox/satellite-v9'
          containerStyle={{height: "80vh", width: "80vw"}}/>
      </div>
    );
  }
}

export default App;
