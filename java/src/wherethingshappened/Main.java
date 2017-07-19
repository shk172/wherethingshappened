package wherethingshappened;
import wherethingshappened.FeedParser;
import wherethingshappened.GeoParser;
/*Java Libraries*/
import java.io.*;
import java.util.List;
import java.net.URL;
import java.net.MalformedURLException;

public class Main {

    public static void main(String[] args) throws Exception {
    	FeedParser parser = new FeedParser("http://feeds.bbci.co.uk/news/rss.xml?edition=int");
    	parser.readFeeds();
    }
}
