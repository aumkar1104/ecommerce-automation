package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.CheckoutPage;
import pages.LoginPage;

public class PaymentTest extends BaseTest {

    @Test(description = "Complete end to end checkout workflow")
    public void checkoutWorkflowTest() {
        // Step 1 - Login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        // Step 2 - Add item to cart
        CartPage cartPage = new CartPage(driver);
        cartPage.addFirstItemToCart();
        cartPage.goToCart();

        // Step 3 - Proceed to checkout
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.proceedToCheckout();

        // Step 4 - Fill shipping details
        checkoutPage.fillShippingDetails("John", "Doe", "12345");

        // Step 5 - Complete order
        checkoutPage.finishOrder();

        // Step 6 - Verify confirmation
        Assert.assertTrue(
            checkoutPage.getConfirmationMessage()
                        .contains("Thank you for your order"),
            "Confirmation message should appear after successful checkout"
        );
    }

    @Test(description = "Checkout button should navigate to shipping details page")
    public void checkoutNavigationTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        CartPage cartPage = new CartPage(driver);
        cartPage.addFirstItemToCart();
        cartPage.goToCart();

        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.proceedToCheckout();

        Assert.assertTrue(
            driver.getCurrentUrl().contains("checkout-step-one"),
            "Should navigate to checkout step one page"
        );
    }
}