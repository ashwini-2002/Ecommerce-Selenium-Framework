package pages;

import java.time.Duration;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;
import base.DriverManager;

public class CheckoutInfoPage {

    WebDriverWait wait;

    public CheckoutInfoPage() {
        PageFactory.initElements(
                DriverManager.getDriver(), this);
        wait = new WebDriverWait(
                DriverManager.getDriver(),
                Duration.ofSeconds(10));
    }

    @FindBy(id="first-name")
    WebElement firstName;

    @FindBy(id="last-name")
    WebElement lastName;

    @FindBy(id="postal-code")
    WebElement postal;

    @FindBy(id="continue")
    WebElement continueBtn;

    public CheckoutOverviewPage enterDetails(String fn, String ln, String pc) {

        wait.until(ExpectedConditions.visibilityOf(firstName)).sendKeys(fn);
        wait.until(ExpectedConditions.visibilityOf(lastName)).sendKeys(ln);
        wait.until(ExpectedConditions.visibilityOf(postal)).sendKeys(pc);

        wait.until(ExpectedConditions.elementToBeClickable(continueBtn)).click();

        return new CheckoutOverviewPage();
    }
}