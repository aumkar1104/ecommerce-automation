package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test(description = "Valid login should reach inventory page")
    public void validLoginTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");
        Assert.assertTrue(
            driver.getCurrentUrl().contains("inventory"),
            "URL should contain 'inventory' after successful login"
        );
    }

    @Test(description = "Invalid login should show error message")
    public void invalidLoginTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("wrong_user", "wrong_password");
        Assert.assertTrue(
            loginPage.isErrorDisplayed(),
            "Error message should be displayed for invalid login"
        );
    }
}