import React, { Component } from 'react';
import ReactMapboxGl, { Layer, Feature, GeoJSONLayer } from "react-mapbox-gl";
import ReactGeocoder from 'react-geocoder-autocomplete';
import MapboxGeocoder from 'mapbox-gl-geocoder';
import firebase from 'firebase';
import firebaseConfig from './firebaseConfig';
import logo from './logo.svg';
import './App.css';

import importArticles from './services/importArticles';

class App extends Component {
	constructor(props){
		super(props);
		this.state={
			articleList: {},
			loading: true,
		};
	}
	componentWillMount(){
		var articles = this.state.articles;
		importArticles(articles).then((articleList)=>{
			console.log(articleList.Australia[0]);
			this.setState({
				articleList: articleList,
				loading: false,
			});
		})
	}

  render() {
  	if(this.state.loading){
  		return(
  			<p>Loading...</p>
  			)
  	}
  	else{
  		console.log(this.state);
	  	const accessToken = 'pk.eyJ1Ijoic2hrMTcyIiwiYSI6ImNqNTBpMzBtZDA0emEyd3Btdm0yanZiNHQifQ.1VKCHBk0__216jznAfBMoQ';
	    var Map = ReactMapboxGl({
	      accessToken: accessToken
	    });
	    var geocoder = new MapboxGeocoder({accessToken: accessToken});

	    var locations = Object.keys(this.state.articleList).map((country)=>{
	    	return(
	    		<Feature coordinates={[this.state.articleList.Australia[0].location.lng, this.state.articleList.Australia[0].location.lat]}/>
	    		)
	    })
	    return (
	      <div className="App">
	        <div className="App-header">
	          <img src={logo} className="App-logo" alt="logo" />
	          <h2>Welcome to React</h2>
	        </div>
	        <Map
	          style='mapbox://styles/mapbox/satellite-v9'
	          containerStyle={{height: "80vh", width: "95svw"}}
	          zoom={[2]}
	          center={[0,0]}>
	          <Layer
	          	type="symbol"
	        		id="marker"
	       			layout={{ "icon-image": "harbor-15" }}>
	       			{locations}
	       		</Layer>
	          {/*
	          <ReactGeocoder
					  	accessToken={accessToken}
					  />
					*/}
	        </Map>
	      </div>
	    );
  	}
  }
}

export default App;
