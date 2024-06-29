import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductsPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest {
    @Test
    public void enterLoginInvalidAndPasswordInvalid() {
        loginPage.login("1212312", "21231");
        String error = loginPage.getErrorMessage();
        assertEquals(error, "Epic sadface: Username and password do not match any user in this service");
    }

    @Test
    public void enterEmpty() {
        loginPage = new LoginPage(driver);
        loginPage.login("", "");
        String error = loginPage.getErrorMessage();
        assertEquals(error, "Epic sadface: Username is required");
    }

    @Test
    public void enterValid() {
        loginPage.login("standard_user", "secret_sauce");
        assertTrue(productsPage.titleIsPresent(), "The register is not displayed");
    }

    @Test
    public void test3() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver browser = new ChromeDriver();
        browser.get("https://www.saucedemo.com/");
        browser.findElement(By.id("root"));
        browser.findElement(By.name("password"));
        browser.findElement(By.className("login_logo"));
        browser.findElement(By.xpath("//input[@id='login-button']"));
        browser.findElement(By.xpath("// h4[text()='Accepted usernames are:']"));
        browser.findElement(By.xpath("//div[contains(@class,'login_container')]"));
        browser.findElement(By.xpath("//h4[contains(text(),'Password for all users:')]"));
        browser.findElement(By.xpath("//*[@class='login-box']/ancestor::div[1]"));
        browser.findElement(By.xpath("//input[@class='input_error form_input']/following::input[2]"));
        browser.findElement(By.xpath("//*[@class='form_group']/child::input[@placeholder='Username']"));
        browser.findElement(By.xpath("//*[@class='form_group']/child::input[@placeholder='Username']"));
        browser.findElement(By.xpath("//*[@class='login-box']/parent::*"));
        browser.findElement(By.xpath("//*[@class='login-box']/preceding::*[@type]"));
        browser.findElement(By.xpath("//input[@class='input_error form_input' and @type='text']"));

        browser.findElement(By.cssSelector(".btn_action"));
        browser.findElement(By.cssSelector(".submit-button.btn_action"));
        browser.findElement(By.cssSelector("#root"));
        browser.findElement(By.cssSelector("[type='text']"));
        browser.findElement(By.cssSelector("[class|='login']"));
        browser.findElement(By.cssSelector("[name~='theme-color']"));

        browser.quit();
    }
}
