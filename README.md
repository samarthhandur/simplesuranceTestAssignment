
# Simplesurance Automation Assignment (Selenium-WebDriver + Java)

## Project Structure

```
build.gradle
gradlew
settings.gradle
src
└── test
    └── java
        └── com
            └── simplesurance
                └── helper
                    ├── BaseTest.java : Base class with driver config
                    ├── Utils.java : Utlity functions with super driver
                    ├── Log.java : Log class for defining log params
                    ├── Constant.java : class to keep test constants
                ├── pages   
                    └── LoginPageObject.java : Class for logging in
                    ├── CertificateListPageObject.java : Class for verifying insurance certificates
                    ├── CreateCertificatePageObject.java : Class for creating insurance certificates
                    ├── CreateSubAgentPageObject.java : Class for creating and verifying subagents addition
                    ├── PaymentConfirmationPageObject.java : Class for completing the payment for purchasing insurance
                ├── tests
                    ├── LoginTest.java : Login test class 
                    ├── CertificateListTest.java : Certificate list test class
                    ├── CreateCertificateTest.java : Create insurance certificates test class
                    ├── CreateSubAgentListTest.java : class for testing subagent addition and verifying added agents
                    ├── PaymentTest.java : class to verify payment after adding customer details
                    ├── TestRunnerClass.java : Main class for running test suite
                    ├── TestSuiteClass.java : Test suite to define the collection of test classes.
                    
                    
```

Libraries:

- JUnit 4
- selenium-java Client 2.53.0
- java-hamcrest 2.0.0.0



## Requirements

- Chrome browser to be installed (chromeDriver =>2.30)
- Gradle installed
- Selenium webdriver installed

## Framework
 - Gradle build tool, maintaining all the library definition in gradle.build 
 - Data Driven Framework to read the the test data, using excel sheet which is kept under the root folder.
 - Page Object Model design pattern for maintaining the separate class for each feature
 - Page Foctory Model for defining and locating web elements
 - Logforj logger for defining and logging events

```

#### Java

Follow the required Java instructions for  operating system.

Be sure to install Java 8 or newer.

#### Start the tests

Open terminal, browse to root directory of project, run the test suite:

```
gradle -Dtest.single=TestSuite clean test
```

#### Test Reports

```
Please find test report under below path 

build/html/index.html
build/xml
```

#### Test Screen Recording

```
Please find below google drive link for test screen recording

https://drive.google.com/file/d/1zTQRY9eQVR2jX3KTJylrauIZObEXr8Vw/view?usp=sharing

