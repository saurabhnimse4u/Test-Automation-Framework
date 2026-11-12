# Selenium Automation Framework | Java 21 | TestNG | Maven

This is a Selenium Automation Testing Framework developed using Java 21, Selenium WebDriver, TestNG, and Maven.

The framework is designed to automate web application testing and supports Data-Driven Testing, cross-browser testing, cloud execution using LambdaTest, and headless execution.

It also generates HTML test reports using Extent Reports and maintains execution logs using Log4j.



## Authors

- Name [Saurabh Nimse](https://github.com/saurabhnimse4u/)
- Email saurabhnimse4u@gmail.com
- Contact:+91 9970818888

## 🚀 About Me
I'm a Saurabh Nimse and I have 8 years of experience in Automation testing using technologies like selenium, restassured, playwright, postman.




## 🔗 Links

[![linkedin](https://img.shields.io/badge/linkedin-0A66C2?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/saurabh-nimse-899027b0/)
[![twitter](https://img.shields.io/badge/twitter-1DA1F2?style=for-the-badge&logo=twitter&logoColor=white)](https://twitter.com/)


## Prerequisites

- Java JDK 21
- Maven
- Eclipse / VS Code
- Git
- LambdaTest account (for cloud execution)


## Future Improvements
- Jenkins integration.
- GitHub Actions integration.
- Parallel test execution.
- Automatic screenshot capture on failures.
- Email notifications for test reports.

## Future Enhancements
- CI/CD integration using Jenkins or GitHub Actions.
- Parallel test execution using TestNG.
- Docker-based browser execution.
- Retry mechanism for failed test cases.
- Screenshot capture on test failures.
- Automatic screenshot attachment in Extent Reports.
- Page Object Model (POM) enhancements.
- Environment-based configuration management.
- API automation integration using REST Assured.
- Slack or email notifications after execution.
- Automated report publishing.
## Setup Installation

**Clone the reposito**
``` bash
git clone https://github.com/saurabhnimse4u/Test-Automation-Framework.git
cd Test-Automation-Framework
```

**Run Tests on Local browser**
```bash
mvn clean test -Dbrowser=chrome -DisHeadless=false -DisLambdaTest=false
```

**Run Tests in Headless Mode**
```bash
mvn clean test -Dbrowser=chrome -DisHeadless=true -DisLambdaTest=false
```

**Run Tests on LambdaTest**
```bash
mvn clean test -Dbrowser=chrome -DisHeadless=true -DisLambdaTest=true
```
## Reports 
To view the report:

- Navigate to the project root directory.
- Locate report.html.
- Open the file in Chrome, Firefox, or any modern browser.
- Review the execution results.

## Logs
- Execution logs are generated inside the logs/ directory.

## Integrated the Project with GitHub Actions
- This automation framework is integrated with Github Actions
- So it will be executed every day 11pm IST.
- Reports can be archive in gh-branch.
