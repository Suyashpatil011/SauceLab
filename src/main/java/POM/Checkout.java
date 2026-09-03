package POM;

import Utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Checkout {

    public WebDriver driver;


    public Checkout(WebDriver driver, WaitUtils waitUtils) {
        this.driver = driver;
    }

    private By proceedToCheckouBtn = By.xpath("//a[@class='btn btn-default check_out']");
    private By processOnlastScreen = By.xpath("///a[@href='/payment']");

    public void clickOncheckoutbtn() {
        driver.findElement(proceedToCheckouBtn).click();
    }

    public void placeOrderBtn() {
        driver.findElement(processOnlastScreen).click();
    }
}
