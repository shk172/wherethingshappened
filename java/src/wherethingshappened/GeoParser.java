package wherethingshappened;

import java.util.List;

import com.bericotech.clavin.GeoParserFactory;
import com.bericotech.clavin.resolver.ResolvedLocation;

public class GeoParser {
    public static void parse(String inputString) throws Exception {
        // Instantiate the CLAVIN GeoParser
        com.bericotech.clavin.GeoParser parser = GeoParserFactory.getDefault("../CLAVIN/IndexDirectory");
                
        // Parse location names in the text into geographic entities
        List<ResolvedLocation> resolvedLocations = parser.parse(inputString);
        
        // Display the ResolvedLocations found for the location names
        for (ResolvedLocation resolvedLocation : resolvedLocations)
            System.out.println(resolvedLocation);

    }
}
