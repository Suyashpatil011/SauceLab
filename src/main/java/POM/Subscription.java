package POM;

import Utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Subscription {

    private WebDriver driver;
    private WaitUtils waitUtils;

    public Subscription(WebDriver driver, WaitUtils waitUtils) {
        this.driver = driver;
        this.waitUtils = waitUtils;
    }

    private By subscriptionTitle = By.cssSelector("div[class='single-widget'] h2");
    private By emailField = By.id("susbscribe_email");
    private By submitbtn = By.id("subscribe");
    private By toastNotification = By.xpath
            ("//div[contains(text(),'You have been successfully subscribed!')]");

    public void scrollToFooter() {
        ((JavascriptExecutor) driver).executeScript
                ("window.scrollTo(0, document.body.scrollHeight)");

    }

    public String getSubscriptionTitle() {
        WebElement titleElement = waitUtils.waitForVisibility(subscriptionTitle);
        return titleElement.getText();
    }

    public void enterEmail(String email) {
        WebElement emailInput = waitUtils.waitForClickable(emailField);
        emailInput.sendKeys(email);
    }

    public void clickSubmit(){
        WebElement btn = waitUtils.waitForClickable(submitbtn);
        btn.click();
    }

    public String getToastNotification() {
        WebElement toastNotificationElement = waitUtils.waitForVisibility(toastNotification);
        return toastNotificationElement.getText();
    }

}
