package wherethingshappened;
import wherethingshappened.Feed;
import wherethingshappened.FeedParser;
import wherethingshappened.FirebaseWrapper;
import wherethingshappened.GeoParser;
import wherethingshappened.Json;
import wherethingshappened.MapInfo;

import java.util.HashSet;

public class Main {

    public static void main(String[] args) throws Exception {
    	FirebaseWrapper firebase = new FirebaseWrapper("https://wherethingshappened.firebaseio.com/locations");
    	FeedParser parser = new FeedParser("http://feeds.bbci.co.uk/news/rss.xml?edition=int");
    	Feed feed = parser.readFeed();
    	System.out.println(feed);
        for (FeedMessage message : feed.getMessages()) {
        	HashSet<String> parseResults = GeoParser.parse(message.getTitle(), message.getDescription());
        	if(!parseResults.isEmpty()){
        		MapInfo info = new MapInfo(parseResults, message.getTitle(), message.getDescription());
        		HashSet<Json> jsons = info.toJSON();
        		for(Json json : jsons){
        			firebase.post(json.key, json.data);	
        		}
        	}
        }
    }
}
