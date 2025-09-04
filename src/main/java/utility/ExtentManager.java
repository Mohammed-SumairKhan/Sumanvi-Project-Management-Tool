package utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * ExtentManager is responsible for creating and managing
 * a singleton instance of ExtentReports.
 */
public class ExtentManager {
    private static ExtentReports extentReports;

    /**
     * Creates (if not already created) and returns the ExtentReports instance.
     * 
     * @param fileName The name of the HTML report file (without extension).
     * @return ExtentReports instance
     */
    public static ExtentReports getExtentReport(String fileName) {
        if (extentReports == null) {
            String basePath = System.getProperty("user.dir"); // browser the base path
            String folderLocation = "\\extent-report\\"; // location of the folder
            String filePath = basePath + folderLocation + fileName + ".html";

            ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter(filePath);
            extentSparkReporter.config().setDocumentTitle("Automation Test Report"); // Browser tab title
            extentSparkReporter.config().setReportName("Sumanvi Project Test Execution Report"); // Report header
            extentSparkReporter.config().setTheme(Theme.DARK);

            extentReports = new ExtentReports();
            extentReports.attachReporter(extentSparkReporter);

            // Add useful system info to the report
            extentReports.setSystemInfo("Tester", "Mohammed Sumair Khan");
            extentReports.setSystemInfo("Project", "Sumanvi Project Management Tool");
            extentReports.setSystemInfo("Environment", "QA");
            extentReports.setSystemInfo("OS", System.getProperty("os.name"));
            extentReports.setSystemInfo("Java Version", System.getProperty("java.version"));
            extentReports.setSystemInfo("Browser", "Chrome"); // You can also read from config.properties
        }
        return extentReports;
    }
}
