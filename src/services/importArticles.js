import firebase from 'firebase';

export default function importArticles(articles) {
	return new Promise(function(resolve, reject){
		var firebaseRef = firebase.database().ref("locations");
		var articlesObject = {};
    firebaseRef.once("value", (data)=>{
    	var length = Object.keys(data.val()).length;
    	var counter = 0;
    	Object.keys(data.val()).forEach((location)=>{
    		articlesObject[location] = [];
				let url = `https://maps.googleapis.com/maps/api/geocode/json?address=${ location }`
		    fetch(url).then(response => response.json())
		      .then(json => {
		      	var numArticles = Object.keys(data.val()[location]).length;
		      	var articleCounter = 0;
		      	counter++;
		      	Object.keys(data.val()[location]).forEach((article)=>{
		      		var articleLocation = data.val()[location];
		      		articlesObject[location].push({
		      			article: articleLocation[article],
		      			location: json.results[0].geometry.location,
		      		})
		      		articleCounter++;
		      		if(articleCounter === numArticles && counter === length){
		      			resolve(articlesObject);
		      		}
		      	})
		      	
		      })
		      .catch(error => console.log(error))
    	})
    	
    })
	})
}