package dashboard;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import driverproperties.BrowserHandler;
import pages.DashBoardPage;
import pages.LoginPage;
import utility.PropertiesReader;
import utility.WaitUtils;

/**
 * DashBoardTests class contains automated tests to verify that 
 * each widget on the dashboard redirects to the correct page.
 * 
 * Uses TestNG for testing framework and Selenium WebDriver for browser automation.
 */
public class DashBoardTests {

	WebDriver driver;
	WebDriverWait wait;
	PropertiesReader propertiesReader = new PropertiesReader(); // Initialize PropertiesReader object
	DashBoardPage dashBoardPage;
	
	 /**
     * Method to setup the test environment.
     * Launches browser, opens application URL, logs in, and initializes the DashBoardPage object.
     */
	@BeforeMethod
	public void start() {
		driver = BrowserHandler.getBrowser(propertiesReader.getBrowserName()); // Launch the browser using BrowserHandler
		driver.get(propertiesReader.getUrl()); // Open the application URL
		WaitUtils.implicitWait(driver); // implicit wait
		LoginPage loginPage = new LoginPage(driver); // Initialize LoginPage object
		loginPage.login(propertiesReader.getUserName(), propertiesReader.getPassword()); // login into the application
		dashBoardPage = new DashBoardPage(driver); // intialize dashboardpage

	}
	
	 /**
     * Verify that clicking the Total Customers widget redirects to the correct page.
     */
	@Test(priority = 1)
	public void totalCustomersWidgetRedirects() {

		dashBoardPage.clickOnTotalCustomerWidget();
		WaitUtils.waitForUrlContains(driver, "/customer/");//implicit wait
		String actual_url = driver.getCurrentUrl();
		String expected_url = "https://sumanvi.pythonanywhere.com/customer/";

		Assert.assertEquals(actual_url, expected_url);

	}
	
	 /**
     * Verify that clicking the Tasks widget redirects to the correct page.
     */
	@Test(priority = 2)
	public void tasksWidgetRedirects() {
		dashBoardPage.clickOnTasksWidget();
		WaitUtils.waitForUrlContains(driver, "/task-list/");//implicit wait
		String actual_url = driver.getCurrentUrl();
		String expected_url = "https://sumanvi.pythonanywhere.com/task-list/";

		Assert.assertEquals(actual_url, expected_url);
	}
	
	/**
     * Verify that clicking the Employees widget redirects to the correct page.
     */
	@Test(priority = 3)
	public void employeesWidgetRedirects() {
		dashBoardPage.clickOnEmployeesWidget();
		WaitUtils.waitForUrlContains(driver, "/employee_list/"); //implicit wait
		String actual_url = driver.getCurrentUrl();
		String expected_url = "https://sumanvi.pythonanywhere.com/employee_list/";

		Assert.assertEquals(actual_url, expected_url);
	}
	
	/**
     * Verify that clicking the Payments widget redirects to the correct page.
     */
	@Test(priority = 4)
	public void paymentsWidgetRedirects() {
		dashBoardPage.clickOnPaymentsWidget();
		WaitUtils.waitForUrlContains(driver, "/payments/"); //implicit wait
		String actual_url = driver.getCurrentUrl();
		String expected_url = "https://sumanvi.pythonanywhere.com/payments/";

		Assert.assertEquals(actual_url, expected_url);
	}
	
	 /**
     * Method to clean up the test environment.
     * Quits the browser after each test method execution.
     */
	@AfterMethod
	public void close() {
		driver.quit(); // Quit browser after each test
	}

}
