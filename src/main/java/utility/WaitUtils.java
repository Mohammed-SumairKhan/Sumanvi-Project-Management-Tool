package utility;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * WaitUtils class provides utility methods to handle different types of waits
 * in Selenium WebDriver, including hard wait, implicit wait, and explicit wait.
 * 
 * Makes test execution more stable and reliable by synchronizing with page elements.
 */
public class WaitUtils {

    // PropertiesReader instance to fetch wait durations from configuration
    static PropertiesReader propertiesReader = new PropertiesReader();
    
    /**
     * Apply a hard wait (Thread.sleep) for a specified duration.
     * Use sparingly as it pauses execution completely.
     */
    public static void applyHardWait() {
        try {
            Thread.sleep(propertiesReader.getHardWait()); // Pause execution
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Apply an implicit wait for the WebDriver instance.
     * WebDriver will poll the DOM for elements up to the specified time.
     * 
     * @param driver WebDriver instance to apply the implicit wait
     */
    public static void implicitWait(WebDriver driver) {
        driver.manage().timeouts().implicitlyWait(
                Duration.ofSeconds(propertiesReader.getImplicitWait())
        );
    }

    /**
     * Apply an explicit wait to wait until the current URL contains the specified partial URL.
     * Useful for waiting until page navigation or redirection occurs.
     * 
     * @param driver WebDriver instance
     * @param partialUrl Partial URL to wait for
     */
    public static void waitForUrlContains(WebDriver driver, String partialUrl) {
    	WebDriverWait wait = new WebDriverWait(driver, 
    			Duration.ofSeconds(propertiesReader.getExplicitWait()));
        wait.until(ExpectedConditions.urlContains(partialUrl)); // Wait until URL contains the string
    }
    
    /**
     * Wait until the specified WebElement is visible on the page.
     * 
     * @param driver WebDriver instance
     * @param element WebElement to wait for visibility
     */
    public static void waitForElementVisible(WebDriver driver, WebElement element) {
    	WebDriverWait wait = new WebDriverWait(driver, 
    			Duration.ofSeconds(propertiesReader.getExplicitWait()));
    	wait.until(ExpectedConditions.visibilityOf(element));
    }
    
    /**
     * Wait until the specified WebElement is clickable.
     * 
     * @param driver WebDriver instance
     * @param element WebElement to wait for clickability
     */
    public static void waitForElementClickable(WebDriver driver, WebElement element) {
    	WebDriverWait wait = new WebDriverWait(driver,
    			Duration.ofSeconds(propertiesReader.getExplicitWait()));
    	wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    
    /**
     * Waits until the element located by the given locator is visible on the page.
     * This method avoids StaleElementReferenceException because it re-finds
     * the element each time until it becomes visible.
     *
     * @param driver  WebDriver instance
     * @param locator By locator of the element to be waited for
     * @return WebElement once it is visible
     */
    public static WebElement waitForElementVisibleByLocator(WebDriver driver, By locator) {
        // Create a WebDriverWait instance using explicit wait time from config.properties
        WebDriverWait wait = new WebDriverWait(driver, 
                Duration.ofSeconds(propertiesReader.getExplicitWait())); 

        // Wait until the element located by 'locator' is visible on the page, then return it
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }


}












