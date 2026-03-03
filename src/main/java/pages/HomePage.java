package pages;

import org.openqa.selenium.support.*;
import base.DriverManager;

public class HomePage {

    public HomePage() {
        PageFactory.initElements(
            DriverManager.getDriver(), this);
    }

    @FindBy(className="inventory_item")
    java.util.List<org.openqa.selenium.WebElement> products;

    public ProductPage selectFirstProduct() {
        products.get(0).click();
        return new ProductPage();
    }
}
