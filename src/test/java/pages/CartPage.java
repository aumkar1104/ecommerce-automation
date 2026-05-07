package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class CartPage extends BasePage {

    @FindBy(className = "inventory_item")
    private List<WebElement> productList;

    @FindBy(className = "shopping_cart_link")
    private WebElement cartIcon;

    @FindBy(className = "shopping_cart_badge")
    private WebElement cartBadge;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void addFirstItemToCart() {
        productList.get(0)
                   .findElement(By.cssSelector("button"))
                   .click();
    }

    public void goToCart() {
        cartIcon.click();
    }

    public int getCartCount() {
        return Integer.parseInt(cartBadge.getText());
    }
}