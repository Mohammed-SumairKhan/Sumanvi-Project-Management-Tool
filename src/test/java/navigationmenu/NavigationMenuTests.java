package navigationmenu;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import driverproperties.BrowserHandler;
import pages.LoginPage;
import pages.NavigationMenuPage;
import utility.PropertiesReader;
import utility.WaitUtils;

/**
 * Test class to verify navigation menu functionality.
 * Uses Page Object Model (NavigationMenuPage) for better readability and reusability.
 * Includes explicit waits to ensure page navigation is stable before assertions.
 */
public class NavigationMenuTests {

    // WebDriver instance for controlling the browser
    WebDriver driver;

    // WebDriverWait instance (can be used for explicit waits if needed)
    WebDriverWait wait;

    // Utility to fetch values (browser, URL, username, password) from config.properties
    PropertiesReader propertiesReader = new PropertiesReader();

    // Page Object for Navigation Menu
    NavigationMenuPage navigationMenuPage;

    /**
     * Setup method that runs before each test.
     * 1. Launches browser
     * 2. Navigates to the application URL
     * 3. Logs into the application
     * 4. Initializes the NavigationMenuPage
     */
    @BeforeMethod
    public void setup() {
        // Launch browser based on value in config.properties (e.g., Chrome, Edge, Firefox)
        driver = BrowserHandler.getBrowser(propertiesReader.getBrowserName());

        // Open the application URL
        driver.get(propertiesReader.getUrl());

        // Apply implicit wait
        WaitUtils.implicitWait(driver);

        // Perform login before accessing the dashboard
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(propertiesReader.getUserName(), propertiesReader.getPassword());

        // Initialize NavigationMenuPage after successful login
        navigationMenuPage = new NavigationMenuPage(driver);
    }

    /**
     * Test Case 1: Verify navigation to "New Leads" page.
     * Steps:
     *   - Click on "New Leads" link
     *   - Wait for URL to contain "new-lead"
     *   - Assert user is redirected correctly
     */
    @Test(priority = 1)
    public void navigateToNewLeads() {
        navigationMenuPage.clickNewLeads();
        WaitUtils.waitForUrlContains(driver, "new-lead"); // explicit wait
        Assert.assertTrue(driver.getCurrentUrl().contains("new-lead"), "Navigation to New Leads failed!");
    }

    /**
     * Test Case 2: Verify navigation to "All Leads" page.
     */
    @Test(priority = 2)
    public void navigateToAllLeads() {
        navigationMenuPage.clickAllLeads();
        WaitUtils.waitForUrlContains(driver, "all_lead"); // explicit wait
        Assert.assertTrue(driver.getCurrentUrl().contains("all_leads"), "Navigation to All Leads failed!");
    }

    /**
     * Test Case 3: Verify navigation to "Customers" page.
     */
    @Test(priority = 3)
    public void navigateToCustomers() {
        navigationMenuPage.clickCustomer();
        WaitUtils.waitForUrlContains(driver, "customer");
        Assert.assertTrue(driver.getCurrentUrl().contains("customer"), "Navigation to Customers failed!");
    }

    /**
     * Test Case 4: Verify navigation to "Add Services" page.
     */
    @Test(priority = 4)
    public void navigateToAddServices() {
        navigationMenuPage.clickAddServices();
        WaitUtils.waitForUrlContains(driver, "add-services");
        Assert.assertTrue(driver.getCurrentUrl().contains("add-service"), "Navigation to Add Services failed!");
    }

    /**
     * Test Case 5: Verify navigation to "Add Employee" page.
     */
    @Test(priority = 5)
    public void navigateToAddEmployee() {
        navigationMenuPage.clickAddEmployee();
        WaitUtils.waitForUrlContains(driver, "add-employee");
        Assert.assertTrue(driver.getCurrentUrl().contains("add-employee"), "Navigation to Add Employee failed!");
    }

    /**
     * Test Case 6: Verify navigation to "Add Task" page.
     */
    @Test(priority = 6)
    public void navigateToAddTask() {
        navigationMenuPage.clickAddTask();
        WaitUtils.waitForUrlContains(driver, "add-task");
        Assert.assertTrue(driver.getCurrentUrl().contains("add-task"), "Navigation to Add Task failed!");
    }

    /**
     * Tear down method that runs after each test.
     * Closes the browser and ends the WebDriver session.
     */
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
