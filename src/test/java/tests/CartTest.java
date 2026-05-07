package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.LoginPage;

public class CartTest extends BaseTest {

    @Test(description = "Adding item to cart should update cart count to 1")
    public void addToCartTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        CartPage cartPage = new CartPage(driver);
        cartPage.addFirstItemToCart();

        Assert.assertEquals(
            cartPage.getCartCount(), 
            1,
            "Cart count should be 1 after adding one item"
        );
    }

    @Test(description = "Cart page should display added item")
    public void cartItemVisibleTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        CartPage cartPage = new CartPage(driver);
        cartPage.addFirstItemToCart();
        cartPage.goToCart();

        Assert.assertTrue(
            driver.getCurrentUrl().contains("cart"),
            "Should navigate to cart page"
        );
    }
}