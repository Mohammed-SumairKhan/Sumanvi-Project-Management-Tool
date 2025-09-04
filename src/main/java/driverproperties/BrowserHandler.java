package driverproperties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * BrowserHandler class is responsible for initializing and returning
 * the WebDriver instance based on the browser name provided.
 * 
 * Supported browsers:
 * - Chrome
 * - Firefox
 */
public class BrowserHandler {

    /**
     * Returns a WebDriver instance for the given browser.
     * 
     * @param browserName The name of the browser (e.g., "chrome", "firefox")
     * @return WebDriver instance for the requested browser
     */
    public static WebDriver getBrowser(String browserName) {

       WebDriver driver = null; // Initialize WebDriver as null
      
        switch (browserName) {
            case "chrome":
                // Launch Chrome browser
                driver = new ChromeDriver();
                break;

            case "firefox":
                // Launch Firefox browser
                driver = new FirefoxDriver();
                break;

            default:
                // Print message if browser is not supported
                System.out.println("Browser not supported");
        }

        // Maximize browser window
        driver.manage().window().maximize();
        
        return driver; // Return the WebDriver instance
    }
}
