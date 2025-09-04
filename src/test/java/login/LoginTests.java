package login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import driverproperties.BrowserHandler;
import pages.LoginPage;
import utility.LoginJsonReader;
import utility.PropertiesReader;
import utility.WaitUtils;

/**
 * LoginTests class contains automated tests to verify the login and logout 
 * functionalities of the application.
 * 
 * Uses TestNG for test management and Selenium WebDriver for browser automation.
 */
public class LoginTests {

	WebDriver driver; // Controls the browser instance
	PropertiesReader propertiesReader = new PropertiesReader(); // Reads values from config.properties
	LoginPage loginPage; // Page Object for login actions
	LoginJsonReader loginJsonReader; // Reads login credentials from login.json
	
	/**
     * Runs once before all test methods.
     * Loads the JSON test data file (login.json).
     */
	@BeforeTest
	public void beforeAllTest(){
		loginJsonReader = new LoginJsonReader(); // Initialize JSON reader
		loginJsonReader.loadJson("login"); // Load login.json file from resources
	}
	
	/**
	 * Runs before each test.
	 * Launches the browser, navigates to login page, and sets up LoginPage object.
	 */
	@BeforeMethod
	public void start() {
		driver = BrowserHandler.getBrowser(propertiesReader.getBrowserName()); // Launch browser as per config
		driver.get(propertiesReader.getUrl()); // Open application URL
		WaitUtils.implicitWait(driver); // Apply implicit wait
		loginPage = new LoginPage(driver); // Initialize LoginPage object
	}

	/**
	 * Test Case 1: Verify login with valid credentials.
	 * Expected Result: User should be redirected to dashboard page.
	 */
	@Test(priority = 1)
	public void validLogin() {
		loginPage.login(loginJsonReader.getVal("validLogin", "username"),  // Enter valid username from the login.json
				loginJsonReader.getVal("validLogin", "password")); // Enter valid password from the login.json

		WaitUtils.waitForUrlContains(driver, "dashboard"); // Wait until dashboard is loaded
		String actual_url = driver.getCurrentUrl(); // Capture actual URL after login
		String expected_url = "https://sumanvi.pythonanywhere.com/dashboard/"; // Expected dashboard URL

		Assert.assertEquals(actual_url, expected_url); // Verify login success
	}

	/**
	 * Test Case 2: Verify login with invalid credentials.
	 * Expected Result: Error message "Invalid username or password" should be displayed.
	 */
	@Test(priority = 2)
	public void invalidLogin() {
		loginPage.invalid(loginJsonReader.getVal("invalidLogin", "username"),  // Enter invalid username from the login.json
				loginJsonReader.getVal("invalidLogin", "password")); // Enter invalid password from the login.json

		String exp_error = "Invalid username or password"; // Expected error message
		String act_error = driver.findElement(By.xpath("//div[@role='alert']")).getText(); // Actual error from UI

		Assert.assertEquals(act_error, exp_error); // Verify error message
	}

	/**
	 * Test Case 3: Verify logout functionality.
	 * Expected Result: User should be redirected back to login page after logout.
	 */
	@Test(priority = 3)
	public void logoutTest() {
		loginPage.login(propertiesReader.getUserName(), propertiesReader.getPassword()); // Login using config creds
		loginPage.logout(); // Perform logout action

		WaitUtils.waitForUrlContains(driver, "login"); // Wait until login page is loaded
		String actual_url = driver.getCurrentUrl(); // Capture actual URL after logout
		String expected_url = propertiesReader.getUrl(); // Expected login page URL from config

		Assert.assertEquals(actual_url, expected_url); // Verify logout success
	}
	
	/**
     * Runs after each test method.
     * Quits the browser to clean up resources.
     */
	@AfterMethod
	public void close() {
		if (driver != null) {
		    driver.quit(); // Quit browser safely
		} 
	}
}
