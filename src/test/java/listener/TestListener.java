package listener;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import utility.ExtentManager;

/**
 * TestNG Listener implementation for Extent Reports.
 * 
 * This class listens to test execution events (start, pass, fail, skip)
 * and logs them into the Extent Report.
 */
public class TestListener implements ITestListener {
    
    // Get a singleton instance of ExtentReports (report generator)
    private static ExtentReports extent = ExtentManager.getExtentReport("Extent-Report");// create a report with given name
    
    // Thread-safe storage for ExtentTest object (important if tests run in parallel)
    private static ThreadLocal<ExtentTest> testThread = new ThreadLocal<>();

    /**
     * Runs before each test method starts.
     * Creates a new ExtentTest entry with test name (and optional description).
     */
    @Override
    public void onTestStart(ITestResult result) {
        String testName = result.getMethod().getMethodName(); // Get the method name
        String description = result.getMethod().getDescription(); // Optional: @Test(description="")
        ExtentTest test = extent.createTest(testName, description); // Create new test in report
        testThread.set(test); // Store it in ThreadLocal
    }

    /**
     * Runs when a test method passes.
     * Logs the result as PASS in the report.
     */
    @Override
    public void onTestSuccess(ITestResult result) {
        testThread.get().log(Status.PASS, "✅ Test Passed"); // Log PASS in Extent Report
    }

    /**
     * Runs when a test method fails.
     * Logs the result as FAIL in the report along with exception details.
     */
    @Override
    public void onTestFailure(ITestResult result) {
        // Log failure message + exception stack trace
        testThread.get().log(Status.FAIL, "❌ Test Failed: " + result.getThrowable());
    }

    /**
     * Runs when a test method is skipped.
     * Logs the result as SKIP in the report.
     */
    @Override
    public void onTestSkipped(ITestResult result) {
        testThread.get().log(Status.SKIP, "⚠️ Test Skipped"); // Log SKIP
    }

    /**
     * Runs after all test methods in the suite are finished.
     * Flushes the Extent Report (writes all logs to HTML file).
     */
    @Override
    public void onFinish(ITestContext context) {
        extent.flush(); // Finalize and save the report
    }
}
