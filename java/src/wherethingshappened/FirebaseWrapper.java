package wherethingshappened;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.MalformedURLException;

public class FirebaseWrapper {
	String firebaseRef;
	
	FirebaseWrapper(String url){
		this.firebaseRef = url;
	}

	//Updates existing data
	public void patch(String key, String data) throws Exception{
		//Create URL connection to the Firebase address and configure
		try{
			String ref = this.firebaseRef + "/" + key + ".json";
			URL refURL = new URL (ref);
			HttpURLConnection connection = (HttpURLConnection) refURL.openConnection();
			connection.setDoOutput(true);
		    connection.setRequestProperty("Content-Type", "application/json");
		    
		    //Override POST method to PATCH method so that a non-traditional PATCH method can be used with Firebase
		    connection.setRequestProperty("X-HTTP-Method-Override", "PATCH");
		    connection.setRequestMethod("POST");
		    
		    //Write to Firebase
		    OutputStreamWriter output = new OutputStreamWriter(connection.getOutputStream(), "UTF-8");
		    output.write(data);
		    output.close();
		    
		    new InputStreamReader(connection.getInputStream());
		}  catch (Exception e) {
		    e.printStackTrace();
	    }	      
	}
	
	//Adds to the list of data
	public void post(String key, String data) throws Exception{
		//Create URL connection to the Firebase address and configure
		try{
			String ref = this.firebaseRef + "/" + key + ".json";
			URL refURL = new URL (ref);
			HttpURLConnection connection = (HttpURLConnection) refURL.openConnection();
			connection.setDoOutput(true);
		    connection.setRequestProperty("Content-Type", "application/json");
		    connection.setRequestMethod("POST");
		    
		    //Write to Firebase
		    OutputStreamWriter output = new OutputStreamWriter(connection.getOutputStream(), "UTF-8");
		    output.write(data);
		    output.close();
		    
		    new InputStreamReader(connection.getInputStream());
		}  catch (Exception e) {
		    e.printStackTrace();
	    }	      
	}
	
	//PUT: overrides current data with completely new entries
	public void put(String key, String data) throws Exception{
		//Create URL connection to the Firebase address and configure
		try{
			String ref = this.firebaseRef + "/" + key + ".json";
			URL refURL = new URL (ref);
			HttpURLConnection connection = (HttpURLConnection) refURL.openConnection();
			connection.setDoOutput(true);
		    connection.setRequestProperty("Content-Type", "application/json");
		    connection.setRequestMethod("PUT");
		    
		    //Write to Firebase
		    OutputStreamWriter output = new OutputStreamWriter(connection.getOutputStream(), "UTF-8");
		    output.write(data);
		    output.close();
		    
		    new InputStreamReader(connection.getInputStream());
		}  catch (Exception e) {
		    e.printStackTrace();
	    }	      
	}
	
	public String get(String key) throws Exception{
		String ref = this.firebaseRef + "/" + key + ".json";
		URL refURL = new URL (ref);
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(refURL.openStream(), "UTF-8"))) {
			String result = "";
	        for (String line; (line = reader.readLine()) != null;) {
	            result += line + "\n";
	        }
	        return result;
	    }
	}    
	
	public void testPatch() throws Exception{
		//Create URL connection to the Firebase address and configure
		try{
			String ref = this.firebaseRef + "/test" + ".json";
			URL refURL = new URL (ref);
			HttpURLConnection connection = (HttpURLConnection) refURL.openConnection();
			String data = "{\"user\":{\"user\":\"user\"},\"users\":{\"users\":\"users\"}}";
			System.out.println("json: " + data);
			connection.setDoOutput(true);
		    connection.setRequestProperty("Content-Type", "application/json");
		    
		    //Override POST method to PATCH method so that a non-traditional PATCH method can be used with Firebase
		    connection.setRequestProperty("X-HTTP-Method-Override", "PATCH");
		    connection.setRequestMethod("POST");
		    
		    //Write to Firebase
		    OutputStreamWriter output = new OutputStreamWriter(connection.getOutputStream(), "UTF-8");
		    output.write(data);
		    output.close();
		    
		    new InputStreamReader(connection.getInputStream());
		}  catch (Exception e) {
		    e.printStackTrace();
	    }	      
	}
}
