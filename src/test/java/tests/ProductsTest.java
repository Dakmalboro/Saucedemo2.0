package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ProductsTest extends BaseTest {
    @Test(dataProvider = "productData")
    public void buyProducts(String productName, String price) {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCart(productName);
        productsPage.openCart();
        assertTrue(cartPage.getProductsNames().contains(productName));
    }

    @Test(dataProvider = "productData")
    public void checkPrices(String productName, String price) {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        assertEquals(productsPage.getProductPrice(productName), price);
    }

    @DataProvider()
    public Object[][] productData() {
        return new Object[][]{
                {"Sauce Labs Backpack", "$29.99"},
                {"Sauce Labs Onesie", "$7.99"},
                {"Sauce Labs Bolt T-Shirt", "$15.99"}
        };
    }
}
