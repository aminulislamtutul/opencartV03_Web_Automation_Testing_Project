# **OpenCart UI Automation Framework**
## About Project
This project is an automation framework built using Java, Selenium, TestNG, and integrated with Jenkins & Docker.

<img width="843" height="518" alt="Hybrid Automation framework" src="https://github.com/user-attachments/assets/f999acb1-d588-4664-aaf0-59453753f51e" />

## Project Dependencies
- [**Java JDK 17**](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html) – Programming language
- [**Selenium 4**](https://www.selenium.dev/) – Web automation framework
- [**Maven**](https://maven.apache.org/) – Build and dependency management tool
- [**TestNG**](https://testng.org/) – Testing framework
- [**Jenkins**](https://www.jenkins.io/) – Continuous Integration / Continuous Delivery (CI/CD)  
- [**Docker**](https://www.docker.com/) – Containerization for test execution
- [**Git**](https://git-scm.com/) – Version control system
## Overview
This project is a Hybrid Automation Framework built for automating the OpenCart application using Selenium, TestNG, Maven, Docker, and Jenkins.

The framework supports:

- Page Object Model (POM) design pattern
- Data-driven testing (Excel-based)
- Cross-browser execution
- Parallel execution with Selenium Grid & Docker
- Jenkins CI/CD integration
- Extent Reporting & TestNG Listeners
## Project Structure
```
├── src/test/java/                 → Test scripts & page objects
│   ├── pageObjects/               → POM classes
│   ├── testBase/                  → Base setup class
│   ├── testCases/                 → TestNG test cases
│   └── utilities/                 → Helper classes (Excel, Reports)
├── src/test/resources/            → Config & log4j files
│   ├── config.properties/         → URL/PWD/Environment
│   └── log4j2.xml/                → Log4j execution logs
├── TestData/                      → Test data files (Excel)
├── reports/                       → HTML Extent Reports
├── screenshots/                   → Captured screenshots on failures
├── logs/                          → Log4j execution logs
├── test-output/                   → TestNG default reports
├── docker-compose.yaml            → Docker Grid setup
├── docker-grid.xml                → Grid execution config
├── pom.xml                        → Maven dependencies & plugins
├── crossbrowsertesting.xml        → Cross Browser Testing TestNG suite
├── grouping.xml                   → Grouping TestNG suite                       
├── master.xml                     → Master TestNG suite
├── run.bat                        → Batch file for execution
└── README.md                      → Project documentation
```
##  Setup & Execution
### 1️⃣ Clone the repository
```
https://github.com/aminulislamtutul/opencartV01_Web_Automation_Testing_Project.git
```
### 2️⃣ Install dependencies

```bash
mvn clean install
```
* **Using run.bat**

```bash
run.bat
```
##  Docker + Selenium Grid Execution
### Run Grid

```bash
docker-compose up -d
```
### Execute Tests on Grid

```bash
mvn clean test -DsuiteXmlFile=docker-grid.xml
```
## Reports & Logs
- Extent Reports → `reports/`
- Screenshots on Failure → `screenshots/`
- Log file → `logs/automation.log`
- TestNG Reports → `test-output/`
<img width="944" height="419" alt="Screenshot_5" src="https://github.com/user-attachments/assets/b220ca28-b07b-4b03-99fb-8d30987a0243" />

## CI/CD with Jenkins
1. Install Jenkins & configure Maven + Git in **Global Tool Configuration**
2. Create a new Jenkins Job → Pull this repo
3. Add **Build Step**:
```bash
mvn clean test -DsuiteXmlFile=master.xml
```
4. View execution & reports in Jenkins
<img width="1353" height="595" alt="JenkinsConfiguration" src="https://github.com/user-attachments/assets/d062c266-8762-4af7-afee-d1599a2efb4b" />

## Test Cases Implemented
* **TestAccountRegistrationPage_TC001** → Validate account registration
* **TestAccountLoginPage_TC002** → Validate login with valid credentials
* **TestAccountLogoutPage_TC003** → Validate logout
* **TestSearchProduct_TC004** → Validate Search Functionality
* **TestAddToCartPage_TC005** → Validate Add to Cart Page
* **DDTestAccountLoginPage_TC006** → Validate login with multiple data sets (Excel-driven)
## Future Enhancements
* Integrate with **Allure Reports**
* Add support for **API Testing**
* Enable **Cloud Execution** (BrowserStack/SauceLabs)

