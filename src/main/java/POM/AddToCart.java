package POM;

import Utils.WaitUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

public class AddToCart {

    private WebDriver driver;
    private WaitUtils wait;

    public AddToCart(WebDriver driver) {
        this.driver = driver;
        this.wait = new WaitUtils(driver, 10); // 10 sec timeout
    }


    // Dynamic locator for product card
    private By productCard(String productName) {
        return By.xpath
                ("//div[@class='productinfo text-center'][.//p[contains" +
                        "(.,'" + productName + "')]]");
    }

    // Dynamic locator for Add to Cart button
    private By addToCartBtn(String productName) {
        return By.xpath
                ("//div[@class='productinfo text-center'][.//p[contains(.,'" + productName + "')]]" +
                        "//a[contains(@class,'add-to-cart')]");
    }

    // Scroll + wait + hover
    public void hoveronAddToCart(String productName) {
        WebElement product = wait.waitForVisibility(productCard(productName));

        // Scroll into view
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", product);

        // Hover
        Actions actions = new Actions(driver);
        actions.moveToElement(product).perform();

        // Click Add to Cart
        WebElement addBtn = wait.waitForClickable(addToCartBtn(productName));
        addBtn.click();

    }
    public void clickonAddToCart() {
        By cartlink = By.xpath("//a[@href='/view_cart']");
        WebElement popupElement = wait.waitForVisibility(cartlink);
        popupElement.click();
    }

}

