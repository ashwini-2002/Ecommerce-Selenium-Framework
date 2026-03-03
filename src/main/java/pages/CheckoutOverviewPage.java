package pages;

import java.time.Duration;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;
import base.DriverManager;

public class CheckoutOverviewPage {

    WebDriverWait wait;

    public CheckoutOverviewPage() {
        PageFactory.initElements(
                DriverManager.getDriver(), this);
        wait = new WebDriverWait(
                DriverManager.getDriver(),
                Duration.ofSeconds(10));
    }

    @FindBy(id="finish")
    WebElement finishBtn;

    public ConfirmationPage finishOrder() {

        wait.until(ExpectedConditions.elementToBeClickable(finishBtn)).click();

        return new ConfirmationPage();
    }
}