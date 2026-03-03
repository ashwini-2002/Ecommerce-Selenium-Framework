package pages;

import java.time.Duration;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;
import base.DriverManager;

public class ConfirmationPage {

    WebDriverWait wait;

    public ConfirmationPage() {
        PageFactory.initElements(
                DriverManager.getDriver(), this);
        wait = new WebDriverWait(
                DriverManager.getDriver(),
                Duration.ofSeconds(10));
    }

    @FindBy(className="complete-header")
    WebElement confirmation;

    public String getConfirmationText() {
        return wait.until(ExpectedConditions.visibilityOf(confirmation))
                .getText();
    }
}