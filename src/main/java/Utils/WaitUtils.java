package Utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class WaitUtils {

    private WebDriver driver;
    private WebDriverWait wait;

    public WaitUtils(WebDriver driver, int timeoutInSeconds) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
    }

    // ✅ Wait until page is fully loaded
    public void waitForPageLoad() {
        wait.until(webDriver ->
                ((JavascriptExecutor) webDriver)
                        .executeScript("return document.readyState").equals("complete"));
    }

    // ✅ Wait until all images are loaded
    public void waitForImagesToLoad() {
        wait.until(webDriver -> (Boolean) ((JavascriptExecutor) webDriver)
                .executeScript(
                        "return Array.from(document.images).every(img => img.complete && img.naturalWidth > 0)"
                ));
    }

    // ✅ Common method for page + images
    public void waitForPageAndImages() {
        waitForPageLoad();
        waitForImagesToLoad();
    }

    // Existing methods
    public WebElement waitForVisibility(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement waitForClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public WebElement waitForPresence(By locator) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public boolean waitForText(By locator, String text) {
        return wait.until(ExpectedConditions.textToBePresentInElementLocated(locator, text));
    }
}
