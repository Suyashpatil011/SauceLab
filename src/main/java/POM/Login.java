package POM;

import Utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class Login {

    public WebDriver driver;
    private WaitUtils waitUtils;

    public Login(WebDriver driver, WaitUtils waitUtils) {
        this.driver = driver;
        this.waitUtils = waitUtils; // 10 sec timeout
    }

    private By userName = By.xpath("//input[@data-qa='login-email']");
    private By passField = By.xpath("//input[@data-qa='login-password']");
    private By loginbtn =   By.xpath("//button[@data-qa='login-button']");
    private By errormsg = By.xpath("//p[@style='color: red;']");


    public void enterEmail(String email) {
        waitUtils.waitForVisibility(userName);
        WebElement emailField = driver.findElement(userName);
        emailField.clear();                     // ✅ clear old text
        waitUtils.waitForClickable(userName);   // ✅ ensure ready
        emailField.sendKeys(email);
    }

    public void enterPassword(String password) {
        waitUtils.waitForVisibility(passField);
        WebElement passwordField = driver.findElement(passField);
        passwordField.clear();
        passwordField.sendKeys(password);
    }


    public void clickLogin() {
        driver.findElement(loginbtn).click();
    }

    public String errorvalidation() {
        WebElement errorElement = waitUtils.waitForVisibility(errormsg);
        return errorElement.getText();
    }

}
