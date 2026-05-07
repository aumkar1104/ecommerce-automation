# E-Commerce Automation Testing Framework

Automated end-to-end testing framework for the SauceDemo e-commerce application using Selenium WebDriver, TestNG, and Maven.

The framework follows the Page Object Model (POM) design pattern and includes reporting, reusable utilities, and CI-ready execution support.

---

## Built With

- Java 11
- Selenium WebDriver 4.18.1
- TestNG 7.9.0
- Maven 3.9.14
- WebDriverManager 5.7.0
- ExtentReports 5.1.1
- Jenkins

---

## Features

- Cross-browser ready Selenium setup
- Page Object Model architecture
- Reusable test utilities and base classes
- HTML reporting with ExtentReports
- Maven-based dependency management
- CI/CD execution support using Jenkins
- Scalable test structure for additional modules

---

## Test Scenarios

### Authentication
- Successful login with valid credentials
- Error validation for invalid login attempts

### Cart Functionality
- Add product to cart
- Verify cart badge count
- Navigate to cart page

### Checkout Flow
- Complete order placement workflow
- Validate checkout navigation steps

---

## Project Structure

```text
src
└── test
    └── java
        ├── pages
        │   ├── BasePage.java
        │   ├── LoginPage.java
        │   ├── CartPage.java
        │   └── CheckoutPage.java
        │
        ├── tests
        │   ├── BaseTest.java
        │   ├── LoginTest.java
        │   ├── CartTest.java
        │   └── PaymentTest.java
        │
        └── utils
            ├── ReportManager.java
            └── TestListener.java
```

---

## Running the Tests

### Prerequisites

- Java 11 or higher
- Maven installed
- Google Chrome

### Execute Test Suite

```bash
mvn test
```

You can also run the suite directly using:

```text
testng.xml → Run As → TestNG Suite
```

---

## Reports

Execution reports are generated automatically after test completion.

```text
reports/TestReport.html
```

---

## Framework Design

The framework is designed around the Page Object Model to keep page interactions separate from test logic. This improves maintainability, readability, and scalability as the test suite grows.

Reusable base classes and utility components are used to minimize code duplication and simplify test management.

---

## Author

Aumkar