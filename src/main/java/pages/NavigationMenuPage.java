package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * This class represents the Navigation Menu Page in the application.
 * It contains locators for menu items such as New Leads, All Leads, Customers, etc.
 * and provides action methods to navigate to the corresponding pages.
 */
public class NavigationMenuPage {
    WebDriver driver;

    /** Locator for 'New Leads' navigation link */
    @FindBy(linkText = "New Leads")
    WebElement newLeads;

    /** Locator for 'All Leads' navigation link */
    @FindBy(linkText = "All Leads")
    WebElement allLeads;

    /** Locator for 'Customer' navigation link */
    @FindBy(linkText = "Customer")
    WebElement customer;

    /** Locator for 'Add Services' navigation link */
    @FindBy(linkText = "Add Services")
    WebElement addServices;

    /** Locator for 'Add Employee' navigation link */
    @FindBy(linkText = "Add Employee")
    WebElement addEmployee;

    /** Locator for 'Add Task' navigation link */
    @FindBy(linkText = "Add Task")
    WebElement addTask;

    /**
     * Constructor to initialize the NavigationMenuPage.
     * @param driver The WebDriver instance used to interact with the browser.
     */
    public NavigationMenuPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * Clicks on the 'New Leads' navigation link.
     */
    public void clickNewLeads() {
        newLeads.click();
    }

    /**
     * Clicks on the 'All Leads' navigation link.
     */
    public void clickAllLeads() {
        allLeads.click();
    }

    /**
     * Clicks on the 'Customer' navigation link.
     */
    public void clickCustomer() {
        customer.click();
    }

    /**
     * Clicks on the 'Add Services' navigation link.
     */
    public void clickAddServices() {
        addServices.click();
    }

    /**
     * Clicks on the 'Add Employee' navigation link.
     */
    public void clickAddEmployee() {
        addEmployee.click();
    }

    /**
     * Clicks on the 'Add Task' navigation link.
     */
    public void clickAddTask() {
        addTask.click();
    }
}
