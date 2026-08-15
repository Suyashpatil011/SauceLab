package POM;

import Utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class Login {

    public WebDriver driver;
    private WaitUtils waitUtils;

    public Login(WebDriver driver) {
        this.driver = driver;
        this.waitUtils = new WaitUtils(driver, 10); // 10 sec timeout
    }

    private By userName = By.xpath("//input[@data-qa='login-email']");
    private By passfiled = By.xpath("//input[@data-qa='login-password']");
    private By loginbtn =   By.xpath("//button[@data-qa='login-button']");
    private By errormsg = By.xpath("//p[@style='color: red;']");


    public void enterEmail(String email) {
        driver.findElement(userName).sendKeys(email);
    }
    public void enterPassword(String password) {
        driver.findElement(passfiled).sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(loginbtn).click();
    }

    public String errorvalidation() {
        WebElement errorElement = waitUtils.waitForVisibility(errormsg);
        return errorElement.getText();
    }

}
