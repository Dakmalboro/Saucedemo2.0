package tests;
import org.testng.annotations.Test;
import pages.LoginPage;

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
        assertEquals(loginPage.getErrorMessage(), "Epic sadface: Username is required");
    }

    @Test
    public void enterValid() {
        loginPage.login("standard_user", "secret_sauce");
        assertTrue(productsPage.titleIsPresent(), "The register is not displayed");
    }
}
