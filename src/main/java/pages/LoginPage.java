package pages;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.DriverManager;

public class LoginPage {

    WebDriverWait wait;

    public LoginPage() {
        PageFactory.initElements(
                DriverManager.getDriver(), this);

        wait = new WebDriverWait(
                DriverManager.getDriver(),
                Duration.ofSeconds(10));
    }

    @FindBy(id = "user-name")
    WebElement username;

    @FindBy(id = "password")
    WebElement password;

    @FindBy(id = "login-button")
    WebElement loginBtn;

    public LoginPage enterUsername(String user) {
        wait.until(ExpectedConditions.visibilityOf(username))
                .sendKeys(user);
        return this;
    }

    public LoginPage enterPassword(String pass) {
        wait.until(ExpectedConditions.visibilityOf(password))
                .sendKeys(pass);
        return this;
    }

    public ProductPage clickLogin() {
        wait.until(ExpectedConditions.elementToBeClickable(loginBtn))
                .click();
        return new ProductPage();
    }
}