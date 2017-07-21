package wherethingshappened;

import wherethingshappened.Json;
import java.util.HashSet;

public class MapInfo {
	HashSet<String> locations;
	HashSet<Json> jsons;
	String articleTitle;
	String articleDescription;
	
	MapInfo(HashSet<String> locations, String title, String description){
		this.jsons = new HashSet<Json>();
		this.locations = locations;
		this.articleTitle = title;
		this.articleDescription = description;
	}
	
	public HashSet<Json> toJSON(){
		int counter = 0;
		if(!this.locations.isEmpty()){
			for(String location : this.locations){
				Json json = new Json();
				String jsonData =  "{\"title\":\"" + this.articleTitle + "\",\"description\":\"" + 
					this.articleDescription + "\",\"location\":\"" + location + "\"}"; 
				json.key = location;
				json.data = jsonData;
				this.jsons.add(json);
			}
		}
		return this.jsons;
	}
}
