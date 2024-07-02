package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends BasePage {
    public final By TITLE = By.cssSelector("[class=title]");
    public final By CART = By.cssSelector(".shopping_cart_link");
    private final String ADD_TO_CART_PATTERN = "//div[text()='%s']//ancestor::div[@class='inventory_item']//button[text()='Add to cart']";
    private final String PRICE_PRODUCT_PATTERN = "//div[text()='%s']//ancestor::div[@class='inventory_item']//div[@data-test='inventory-item-price']";

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get(BASE_URL + "/inventory.html");
    }

    public boolean titleIsPresent() {
        return driver.findElement(TITLE).isDisplayed();
    }

    public void addToCart(String product) {
        By addToCartButton = By.xpath(String.format(ADD_TO_CART_PATTERN, product));
        driver.findElement(addToCartButton).click();
    }

    public String getProductPrice(String product) {
        By priceElement = By.xpath(String.format(PRICE_PRODUCT_PATTERN, product));
        return driver.findElement(priceElement).getText();
    }

    public void openCart() {
        driver.findElement(CART).click();
    }
}
