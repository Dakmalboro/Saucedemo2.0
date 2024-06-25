package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    WebDriver driver;
    public By loginInput = By.name("user-name");
    public By passwordInput = By.name("password");
    public By submitButton = By.cssSelector("[type=submit]");
    public By errorMessage = By.cssSelector(".error-message-container.error");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void login(String username, String password) {
        driver.findElement(loginInput).sendKeys(username);
        driver.findElement(passwordInput).sendKeys(password);
        driver.findElement(submitButton).click();
    }

    public WebElement getErrorMessage() {
        return driver.findElement(errorMessage);
    }
}
