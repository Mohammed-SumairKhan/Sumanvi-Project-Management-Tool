package searchbar;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import driverproperties.BrowserHandler;
import pages.LoginPage;
import pages.SearchPage;
import utility.PropertiesReader;
import utility.SearchJsonReader;
import utility.WaitUtils;

/**
 * SearchBarTests class contains automated tests to verify the search
 * functionality in the application. This includes searching by Name, Phone,
 * Service, Task ID and verifying the Clear Search button.
 * 
 * Uses TestNG for testing framework and Selenium WebDriver for browser
 * automation.
 */
public class SearchBarTests {

    WebDriver driver; // Controls the browser instance
    PropertiesReader propertiesReader = new PropertiesReader(); // Reads values from config.properties
    SearchPage searchPage; // Page Object for search actions
    SearchJsonReader searchJsonreader; // Reads search test data from search.json

    /**
     * Runs once before all test methods. Loads the JSON test data file
     * (search.json).
     */
    @BeforeTest
    public void beforeAllTest() {
        searchJsonreader = new SearchJsonReader(); // Initialize JSON reader
        searchJsonreader.loadJson("search"); // Load search.json file from resources
    }

    /**
     * Runs before each test. Launches the browser, navigates to app, logs in, and
     * sets up SearchPage object.
     */
    @BeforeMethod
    public void start() {
        driver = BrowserHandler.getBrowser(propertiesReader.getBrowserName()); // Launch browser as per config
        driver.get(propertiesReader.getUrl()); // Open application URL
        WaitUtils.implicitWait(driver); // Apply implicit wait
        LoginPage loginPage = new LoginPage(driver); // Initialize LoginPage object
        loginPage.login(propertiesReader.getUserName(), propertiesReader.getPassword()); // Login using config creds
        searchPage = new SearchPage(driver); // Initialize SearchPage object
    }

    /**
     * Test Case 1: Verify that search works with name. Expected Result: User should
     * get the result matching the searched name.
     */
    @Test(priority = 1)
    public void searchByName() {
        searchPage.searchByName(searchJsonreader.getVal("searchData", "searchByName")); // Perform search with name
        WaitUtils.applyHardWait(); // Allow results to load
        WebElement result = driver.findElement(By.xpath("//strong[text() = 'rohan']")); // Locate search result
        WaitUtils.waitForElementVisible(driver, result); // Wait until result is visible
        String actual_name = result.getText(); // Capture actual name
        String expected_name = "rohan"; // Expected name
        Assert.assertEquals(actual_name, expected_name); // Verify search result
    }

    /**
     * Test Case 2: Verify that search works with phone number. Expected Result:
     * User should get the result matching the searched phone number.
     */
    @Test(priority = 2)
    public void searchByPhone() {
        searchPage.searchByPhone(searchJsonreader.getVal("searchData", "searchByPhone")); // Perform search with phone
        WaitUtils.applyHardWait(); // Allow results to load
        List<WebElement> phoneCell = driver.findElements(By.xpath("//small[@class = 'text-muted']")); // Locate result
        WaitUtils.waitForElementVisible(driver, phoneCell.get(0)); // Wait until result is visible
        String expected_res = "Showing results for: \"6312345678\""; // Expected message
        String actual_res = phoneCell.get(0).getText(); // Actual message
        Assert.assertEquals(actual_res, expected_res); // Verify search result
    }

    /**
     * Test Case 3: Verify that search works with customer service type. Expected
     * Result: User should get the result matching the searched service.
     */
    @Test(priority = 3)
    public void searchByService() {
        searchPage.searchByService(searchJsonreader.getVal("searchData", "searchByService")); // Perform search with service
        WaitUtils.applyHardWait(); // Allow results to load
        WebElement serviceBadge = driver.findElement(By.xpath("//*[@class= 'badge bg-info']")); // Locate service badge
        WaitUtils.waitForElementVisible(driver, serviceBadge); // Wait until result is visible
        String act_res = serviceBadge.getText(); // Capture actual service
        String exp_res = "Aadhar Changes"; // Expected service
        Assert.assertEquals(act_res, exp_res); // Verify search result
    }

    /**
     * Test Case 4: Verify that search works with Task ID. Expected Result: User
     * should get the result matching the searched Task ID.
     */
    @Test(priority = 4)
    public void searchByTaskId() {
        searchPage.searchByTaskId(searchJsonreader.getVal("searchData", "searchByTaskId")); // Perform search
        WaitUtils.applyHardWait(); // Allow results to load

        By taskLocator = By.xpath("//*[@class='text-primary']"); 
        WebElement taskElement = WaitUtils.waitForElementVisibleByLocator(driver, taskLocator); // Fresh element
        
        String act_res = taskElement.getText(); 
        String exp_res = "TSK004"; 
        Assert.assertEquals(act_res, exp_res); 
    }


    /**
     * Test Case 5: Verify that the Clear Search button resets the search input and
     * results. Expected Result: Search input should be empty and default records
     * displayed.
     */
    @Test(priority = 5)
    public void clearSearchButtonTest() {
        searchPage.searchByName("rohan"); // Perform search with name
        WaitUtils.applyHardWait(); // Allow results to load
        searchPage.clickClearSearch(); // Click the clear search button
        String searchInput = driver.findElement(By.name("search")).getAttribute("value"); // Get search input value
        Assert.assertTrue(searchInput.isEmpty()); // Verify search input is cleared
    }

    /**
     * Runs after each test method. Quits the browser to clean up resources.
     */
    @AfterMethod
    public void close() {
        driver.quit(); // Quit browser after each test
    }
}
