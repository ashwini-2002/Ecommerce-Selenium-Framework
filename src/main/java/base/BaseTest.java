package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.firefox.*;
import org.testng.annotations.*;

public class BaseTest {

    @BeforeMethod
    @Parameters("browser")
    public void setUp(String browser) {

        WebDriver driver;

        if (browser.equalsIgnoreCase("chrome")) {

            ChromeOptions options = new ChromeOptions();
            options.addArguments("--incognito");

            driver = new ChromeDriver(options);

        } else if (browser.equalsIgnoreCase("firefox")) {

            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("-private");

            driver = new FirefoxDriver(options);

        } else {
            throw new RuntimeException("Browser not supported");
        }

        driver.manage().window().maximize();
        DriverManager.setDriver(driver);
        DriverManager.getDriver().get("https://www.saucedemo.com/");
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {

        WebDriver driver = DriverManager.getDriver();

        if (driver != null) {
            driver.quit();
            DriverManager.unload();
        }
    }
}