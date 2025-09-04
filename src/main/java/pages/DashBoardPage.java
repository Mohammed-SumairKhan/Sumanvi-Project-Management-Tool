package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * DashBoardPage class represents the dashboard page of the application.
 * It contains web elements (widgets) and methods to interact with them.
 * 
 * Uses PageFactory to initialize web elements.
 */
public class DashBoardPage {

    // WebDriver instance for interacting with the browser
    WebDriver driver;

    // Locator for Total Customers widget
    @FindBy(xpath = "//h4[text() = 'Total Customers']")
    WebElement totalCustomer;

    // Locator for Tasks widget
    @FindBy(xpath = "//h4[text() = 'Tasks']")
    WebElement tasks;

    // Locator for Employees widget
    @FindBy(xpath = "//h4[text() = 'Employees']")
    WebElement employees;

    // Locator for Payments widget
    @FindBy(xpath = "//h4[text() = 'Payments']")
    WebElement payments;

    /**
     * Constructor to initialize the DashBoardPage object.
     * Initializes the web elements using PageFactory.
     * 
     * @param driver WebDriver instance passed from the test class
     */
    public DashBoardPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * Clicks on the Total Customers widget on the dashboard.
     */
    public void clickOnTotalCustomerWidget() {
        totalCustomer.click();
    }

    /**
     * Clicks on the Tasks widget on the dashboard.
     */
    public void clickOnTasksWidget() {
        tasks.click();
    }

    /**
     * Clicks on the Employees widget on the dashboard.
     */
    public void clickOnEmployeesWidget() {
        employees.click();
    }

    /**
     * Clicks on the Payments widget on the dashboard.
     */
    public void clickOnPaymentsWidget() {
        payments.click();
    }
}
