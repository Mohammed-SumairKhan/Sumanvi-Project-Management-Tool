package utility;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SearchJsonReader { // Class to read values from JSON files
    JsonNode jsonNode; // Holds the JSON content in memory
    
    // Loads a JSON file from test/resources folder
    public void loadJson(String fileName) {
        String baseFile = System.getProperty("user.dir"); // Get project base path
        String testResourceLocation = "\\src\\test\\resources\\"; // Path to resources
        String filePath = baseFile + testResourceLocation + fileName + ".json"; // Build full file path
        ObjectMapper mapper = new ObjectMapper(); // Jackson mapper object
        
        try {
            jsonNode = mapper.readTree(new File(filePath)); // Read JSON into JsonNode
        } catch (IOException e) {
            throw new RuntimeException(e); // Rethrow as unchecked exception
        }
    }
    
    // Fetches a nested value by passing keys (supports multiple levels)
    public String getVal(String... keys) {
        JsonNode tempNode = jsonNode; // Start with root node
        for (String key : keys) { // Loop through each key
            if (tempNode != null) {
                tempNode = tempNode.get(key); // Move deeper into JSON
            }
        }
        return tempNode != null ? tempNode.asText() : null; // Return value if found
    }
}
