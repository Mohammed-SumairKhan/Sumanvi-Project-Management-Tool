package utility;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * PropertiesReader is a utility class that loads and reads values
 * from the config.properties file.
 * 
 * It provides methods to fetch browser name, URL, wait times,
 * username, and password for test execution.
 */
public class PropertiesReader {

    Properties properties;

    /**
     * Constructor to load the properties file into memory.
     * The file path is fixed as "src/main/resources/config.properties".
     */
    public PropertiesReader() {
        properties = new Properties();

        try {
            // Load the config.properties file
            FileInputStream f = new FileInputStream("src/main/resources/config.properties");
            properties.load(f);
        } catch (Exception e) {
            // Print stack trace if file not found or loading fails
            e.printStackTrace();
        }
    }

    /**
     * Reads browser name from the properties file.
     * 
     * @return browser name as String (e.g., "chrome", "firefox")
     */
    public String getBrowserName() {
        return properties.getProperty("browser");
    }

    /**
     * Reads application URL from the properties file.
     * 
     * @return URL as String
     */
    public String getUrl() {
        return properties.getProperty("url");
    }
    
    /**
     * Reads implicit wait time (in seconds) from the properties file.
     * 
     * @return implicit wait duration in seconds
     */
    public int getImplicitWait() {
        return Integer.parseInt(properties.getProperty("implicitwait"));
    }
    
    /**
     * Reads explicit wait time (in seconds) from the properties file.
     * 
     * @return explicit wait duration in seconds
     */
    public int getExplicitWait() {
        return Integer.parseInt(properties.getProperty("explicitwait"));
    }
    
    /**
     * Reads hard wait time (in seconds) from the properties file.
     * 
     * @return hard wait duration in seconds
     */
    public int getHardWait() {
        return Integer.parseInt(properties.getProperty("hardwait"));
    }
    
    /**
     * Reads username from the properties file.
     * 
     * @return username as String
     */
    public String getUserName() {
        return properties.getProperty("username");
    }
    
    /**
     * Reads password from the properties file.
     * 
     * @return password as String
     */
    public String getPassword() {
        return properties.getProperty("password");
    }
}
