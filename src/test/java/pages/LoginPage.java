package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    public By LOGIN_INPUT = By.name("user-name");
    public By PASSWORD_INPUT = By.name("password");
    public By SUBMIT_BUTTON = By.cssSelector("[type=submit]");
    public By ERROR_MESSAGE = By.cssSelector(".error-message-container.error");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get(BASE_URL);
    }

    public void login(String username, String password) {
        driver.findElement(LOGIN_INPUT).sendKeys(username);
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        driver.findElement(SUBMIT_BUTTON).click();
    }

    public String getErrorMessage() {
        return driver.findElement(ERROR_MESSAGE).getText();
    }
}
