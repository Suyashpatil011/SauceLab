package POM;

import Utils.WaitUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

public class AddToCart {

    private WebDriver driver;
    private WaitUtils wait;

    public AddToCart(WebDriver driver) {
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
        By cartlink = By.xpath("//a[@href='/view_cart']");
        WebElement popupElement = wait.waitForVisibility(cartlink);
        popupElement.click();
    }
}