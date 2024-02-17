package utilities;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import endpoints.GivenPaths;

public class CreateTempJsonFile {
	//public static JSONArray givendata;
	
	public static  JSONArray readdatafromjson() throws IOException, ParseException {
		// Read the JSON file and parse its content
		JSONParser jsonparser = new JSONParser();
		// Parse the JSON file
		FileReader reader = new FileReader(GivenPaths.jsonpath);
	    Object obj = jsonparser.parse(reader);	    
	    JSONArray givendata=(JSONArray)obj;
	    return givendata;
	}
}

