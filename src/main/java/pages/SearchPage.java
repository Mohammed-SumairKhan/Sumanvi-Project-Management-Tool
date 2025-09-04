package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * SearchPage class represents the search functionality of the application. It
 * contains web elements and methods to perform searches by different criteria
 * and to clear the search results.
 * 
 * Uses PageFactory to initialize web elements.
 */
public class SearchPage {
	WebDriver driver;

	// Locator for searchBar
	@FindBy(name = "search")
	WebElement searchBar;

	// Locator for searchButton
	@FindBy(css = "button.search-btn")
	WebElement searchButton;

	// Locator for clearSearchButton
	@FindBy(xpath = "//a[contains(@class , 'clear-search')]")
	WebElement clearSearchButton;

	/**
	 * Constructor to initialize the SearchPage object. Initializes the web elements
	 * using PageFactory.
	 * 
	 * @param driver WebDriver instance passed from the test class
	 */
	public SearchPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/**
	 * Performs search by name. Enters the name in the search field and clicks the
	 * search button.
	 * 
	 * @param name The name to search
	 */
	public void searchByName(String name) {
		searchBar.sendKeys(name);
		searchButton.click();

	}

	/**
	 * Performs search by phone number. Enters the phone number in the search field
	 * and clicks the search button.
	 * 
	 * @param phoneNumber The phone number to search
	 */
	public void searchByPhone(String phoneNumber) {
		searchBar.sendKeys(phoneNumber);
		searchButton.click();
	}

	/**
	 * Performs search by service type. Enters the service name in the search field
	 * and clicks the search button.
	 * 
	 * @param service The service to search
	 */
	public void searchByService(String service) {
		searchBar.sendKeys(service);
		searchButton.click();
	}

	/**
	 * Performs search by Task ID. Enters the Task ID in the search field and clicks
	 * the search button.
	 * 
	 * @param TaskId The Task ID to search
	 */
	public void searchByTaskId(String TaskId) {
		searchBar.sendKeys(TaskId);
		searchButton.click();
	}

	/**
	 * Clicks on the Clear Search button to reset the search input and results.
	 */
	public void clickClearSearch() {
		clearSearchButton.click();
	}

}
