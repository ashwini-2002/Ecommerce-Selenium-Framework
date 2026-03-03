package pages;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.DriverManager;

public class ProductPage {

    WebDriverWait wait;

    public ProductPage() {
        PageFactory.initElements(
                DriverManager.getDriver(), this);

        wait = new WebDriverWait(
                DriverManager.getDriver(),
                Duration.ofSeconds(10));
    }

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    WebElement firstProductAdd;

    @FindBy(className = "shopping_cart_link")
    WebElement cart;

    public ProductPage selectFirstProduct() {
        wait.until(ExpectedConditions.elementToBeClickable(firstProductAdd))
                .click();
        return this;
    }

    public CartPage goToCart() {
        wait.until(ExpectedConditions.elementToBeClickable(cart))
                .click();
        return new CartPage();
    }
}