package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest {
    @Test(dataProvider = "loginData")
    public void enterLoginInvalidAndPasswordInvalid(String username, String password, String expectedError) {
        loginPage.open();
        loginPage.login(username, password);
        assertEquals(loginPage.getErrorMessage(), expectedError);
    }

    @DataProvider()
    public Object[][] loginData() {
        return new Object[][]{
                {"1212312", "21231", "Epic sadface: Username and password do not match any user in this service"},
                {"", "", "Epic sadface: Username is required"},
                {"21314", "", "Epic sadface: Password is required"}
        };
    }

    @Test
    public void enterValid() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        assertTrue(productsPage.titleIsPresent(), "The register is not displayed");
    }
}
