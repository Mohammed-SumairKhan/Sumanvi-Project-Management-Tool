package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * LoginPage class represents the login page of the application.
 * It contains web elements and methods to perform login and logout actions.
 * 
 * Uses PageFactory to initialize web elements.
 */
public class LoginPage {

	WebDriver driver;

	// Locator for username input field
	@FindBy(name = "username")
	WebElement usernameInput;

	// Locator for password input field
	@FindBy(name = "password")
	WebElement passwordInput;

	// Locator for login button
	@FindBy(className = "btn-login")
	WebElement loginButton;

	// Locator for logout button
	@FindBy(xpath = "//*[@class= 'logout-btn']")
	WebElement logoutButton;

	 /**
     * Constructor to initialize the LoginPage object.
     * Initializes the web elements using PageFactory.
     * 
     * @param driver WebDriver instance passed from the test class
     */
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/**
     * Perform login with valid credentials.
     * Enters the username and password, then clicks the login button.
     * 
     * @param user The username to login
     * @param pass The password to login
     */
	public void login(String username, String password) {
		usernameInput.sendKeys(username);
		passwordInput.sendKeys(password);
		loginButton.click();
	}

	/**
     * Perform login attempt with invalid credentials.
     * Enters the username and password, then clicks the login button.
     * Used to verify login failure scenarios.
     * 
     * @param user The username to login
     * @param pass The password to login
     */
	public void invalid(String username, String password) {
		usernameInput.sendKeys(username);
		passwordInput.sendKeys(password);
		loginButton.click();
	}

	/**
     * Perform logout from the application.
     * Clicks the logout button to end the session.
     */
	public void logout() {
		// sideBar.click();
		logoutButton.click();
	}

}
