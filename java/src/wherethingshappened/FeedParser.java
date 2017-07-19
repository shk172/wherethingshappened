package wherethingshappened;
import wherethingshappened.Feed;

/*Java Libraries*/
import java.io.*;
import java.util.*;
import java.net.URL;
import java.net.MalformedURLException;

public class FeedParser {
	URL url;
	
    FeedParser(String url){
    	 try {
             this.url = new URL(url);
         } catch (MalformedURLException e) {
             throw new RuntimeException(e);
         } 
    }
        
    public ArrayList<Feed> readFeeds(){
    	try{
            BufferedReader in = new BufferedReader(new InputStreamReader(this.url.openStream()));
            ArrayList<Feed> feedList = new ArrayList<Feed>();
            String line;
            while ((line = in.readLine()) != null) {
            	System.out.println(line);
                int titleEndIndex = 0;
                int titleStartIndex = 0;
                Feed feed = new Feed();
                while (titleStartIndex >= 0) {
                    titleStartIndex = line.indexOf("<title>", titleEndIndex);
                    if (titleStartIndex >= 0) {
                        titleEndIndex = line.indexOf("</title>", titleStartIndex);
                        feed.setTitle(line.substring(titleStartIndex + "<title>".length(), titleEndIndex));
                        feedList.add(feed);
                    }
                }
            }
            in.close();
            return feedList;
        } catch (MalformedURLException ue){
            System.out.println("Malformed URL");
        } catch (IOException ioe){
            System.out.println("Something went wrong reading the contents");
        }
        return null;
    }
}

