# Sumanvi Project Management Tool

## Project Overview
Sumanvi Project Management Tool is a web-based application for managing tasks, tracking projects, and collaborating efficiently.  
It includes login, task search, dashboard insights, and navigation features.

**Automation Testing:** The website is tested using Java, Selenium WebDriver, TestNG, and ExtentReports to validate functionalities like login, search, dashboard, and navigation.

## Setup Steps

## 1. Clone the Repository
git clone https://github.com/<your-username>/sumanvi_project_management_tool.git
## 2. Navigate to Project Folder
cd sumanvi_project_management_tool
## 3. Install Maven Dependencies
mvn clean install
## 4. Configure config.properties
- Set your browser: browser=chrome or firefox
- Set your URL: url=https://sumanvi.pythonanywhere.com/login/
- Update username, password, and wait times if needed
## 5. Run Tests
- Using TestNG XML:
mvn test -DsuiteXmlFile=testing.xml
- Or run individual test classes directly from your IDE
## 6. View Reports
- Reports are generated in the extent-report/ folder
- Open .html files in a browser to see detailed test results

## Reports
- DashBoard-Report.html
- Extent-Report.html (General suite report)
- login-Report.html
- NavigationMenu-Report.html
- Search-Report.html

## Future Enhancements
- Capture screenshots on test failure for better debugging
- Integrate with Allure Reports for enhanced visualization
- Expand test coverage for new modules and workflows
- Implement CI/CD integration with Jenkins or GitHub Actions

## Author
- Mohammed Sumair Khan
- 📍 Bangalore, Karnataka, India
- 📧 sumairk0777@gmail.com