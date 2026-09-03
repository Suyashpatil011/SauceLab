package POM;

import Utils.WaitUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

public class AddToCart {

    private WebDriver driver;
    private WaitUtils wait;

    public AddToCart(WebDriver driver, WaitUtils waitUtils) {
        this.driver = driver;
        this.wait = new WaitUtils(driver, 10);
    }

    private By productCard(String productName) {
        return By.xpath(
                "//div[@class='productinfo text-center'][.//p[contains(.,'" +
                        productName + "')]]");
    }

    private By addToCartBtn(String productName) {
        return By.xpath(
                "//div[@class='productinfo text-center'][.//p[contains(.,'" +
                        productName + "')]]//a[contains(@class,'add-to-cart')]");
    }

    public void hoveronAddToCart(String productName) {

        WebElement product = wait.waitForVisibility(productCard(productName));

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView(true);", product);

        new Actions(driver)
                .moveToElement(product)
                .perform();

        WebElement addBtn = wait.waitForClickable(addToCartBtn(productName));

        // Use JavaScript click instead of Selenium click
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].click();", addBtn);
    }

    public void clickonAddToCart() {
        // Scoped to the "Added!" modal - the unscoped xpath also matches the (hidden) header cart link
        By cartlink = By.xpath("//div[@id='cartModal']//a[@href='/view_cart']");
        WebElement popupElement = wait.waitForClickable(cartlink);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", popupElement);
    }

    private By cartProductName(String productName) {
        return By.xpath("//td[@class='cart_description']//a[contains(text(),'" + productName + "')]");
    }

    public boolean isProductInCart(String productName) {
        try {
            return wait.waitForVisibility(cartProductName(productName)).isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }
}