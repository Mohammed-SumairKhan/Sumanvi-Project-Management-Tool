# Sumanvi Project management Tool

## Project Overview
Sumanvi Project Management Tool is a web-based application for managing tasks, tracking projects, and collaborating efficiently. It includes login, task search, dashboard insights, and navigation features.

Automation Testing: The website is tested using Java, Selenium WebDriver, TestNG, and ExtentReports to validate functionalities like login, search, dashboard, and navigation.

## Setup Steps
1.Clone the Repository
git clone https://github.com/<your-username>/sumanvi_project_management_tool.git

2.Navigate to Project Folder
cd sumanvi_project_management_tool

3.Install Maven Dependencies
mvn clean install

4.Configure config.properties
Set your browser: browser=chrome or firefox
Set your URL: url=https://sumanvi.pythonanywhere.com/login/
Update username, password, and wait times if needed

5.Run Tests
Using TestNG XML:
mvn test -DsuiteXmlFile=testing.xml
Or run individual test classes directly from your IDE

6.View Reports
Reports are generated in the extent-report/ folder
Open .html files in a browser to see detailed test results

## Potential Improvements

-Add screenshot capture for failed test cases to improve debugging.
-Implement data-driven testing using Excel or CSV for multiple test scenarios.
-Integrate with CI/CD tools like Jenkins or GitHub Actions for automated test execution.
-Add cross-browser testing for more coverage (Edge, Safari, etc.).
-Enhance logging and reporting with detailed step descriptions and timestamps.
-Implement parallel test execution to reduce total run time.