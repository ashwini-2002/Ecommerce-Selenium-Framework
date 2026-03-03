package pages;

import java.time.Duration;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;
import base.DriverManager;

public class CartPage {

    WebDriverWait wait;

    public CartPage() {
        PageFactory.initElements(
                DriverManager.getDriver(), this);
        wait = new WebDriverWait(
                DriverManager.getDriver(),
                Duration.ofSeconds(10));
    }

    @FindBy(id = "checkout")
    WebElement checkoutBtn;

    public CheckoutInfoPage clickCheckout() {

        wait.until(ExpectedConditions.elementToBeClickable(checkoutBtn))
                .click();

        return new CheckoutInfoPage();  // IMPORTANT
    }
}