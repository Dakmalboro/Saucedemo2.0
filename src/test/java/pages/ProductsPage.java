package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage {
    WebDriver driver;
    public By title = By.cssSelector("[class=title]");

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean titleIsPresent() {
        return driver.findElement(title).isDisplayed();
    }
}
