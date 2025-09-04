package utility;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class LoginJsonReader {
	   
	   JsonNode jsonNode; // Holds the loaded JSON data in memory
	 
	   /**
	    * Loads the JSON file from the test resources folder.
	    * @param fileName - Name of the JSON file (without extension)
	    */
	   public void loadJson(String fileName) {
		   String basePath = System.getProperty("user.dir"); // Project root path
		   String testResourceLocation = "\\src\\test\\resources\\"; // Location of test resources
		   String filePath = basePath + testResourceLocation + fileName + ".json"; // Full file path
		   ObjectMapper mapper = new ObjectMapper(); // Jackson object mapper to read JSON
		   
		   try {
			   jsonNode = mapper.readTree(new File(filePath)); // Load JSON into jsonNode
		   } catch(IOException e){
			   throw new RuntimeException(e); // Throw runtime exception if file not found / invalid
		   }
	   }
	 
	   /**
	    * Retrieves a value from the JSON using nested keys.
	    * Example: getVal("validLogin", "username") → returns "admin"
	    * @param keys - Keys to traverse the JSON hierarchy
	    * @return String value found at the specified JSON path, or null if not found
	    */
	   public String getVal(String... keys) {
		   JsonNode tempNode = jsonNode; // Temporary node for traversing JSON
		   for(String key : keys) { // Loop through keys (supports nested JSON)
			   if(tempNode != null) {
				   tempNode = tempNode.get(key); // Move deeper into JSON object
			   }
		   }
		   return tempNode != null ? tempNode.asText() : null; // Return value if found, else null
	   }
}
