package wherethingshappened;

import java.util.HashSet;
import java.util.List;

import com.bericotech.clavin.GeoParserFactory;
import com.bericotech.clavin.resolver.ResolvedLocation;

public class GeoParser {
	
	
	public static HashSet<String> parse(String title, String description) throws Exception {
        // Instantiate the CLAVIN GeoParser
        com.bericotech.clavin.GeoParser parser = GeoParserFactory.getDefault("../CLAVIN/IndexDirectory");
                
        // Parse location names in the text into geographic entities
        List<ResolvedLocation> resolvedLocations = parser.parse(title + description);
        
        // Display the ResolvedLocations found for the location names
        HashSet<String> results = new HashSet<String>();
        for (ResolvedLocation resolvedLocation : resolvedLocations){
            //System.out.println("Article Title: " + title + ", " + resolvedLocation.getGeoname().getPrimaryCountryName());
            results.add(resolvedLocation.getGeoname().getPrimaryCountryName());
        }
        return results;
    }
	
    public static void parse(String inputString) throws Exception {
        // Instantiate the CLAVIN GeoParser
        com.bericotech.clavin.GeoParser parser = GeoParserFactory.getDefault("../CLAVIN/IndexDirectory");
                
        // Parse location names in the text into geographic entities
        List<ResolvedLocation> resolvedLocations = parser.parse(inputString);
        
        // Display the ResolvedLocations found for the location names
        for (ResolvedLocation resolvedLocation : resolvedLocations)
            System.out.println(resolvedLocation.getGeoname());

    }
}
