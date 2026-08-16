package POM;

import Utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Checkout {

    public WebDriver driver;
    private WaitUtils wait;

    public Checkout(WebDriver driver){
        this.driver = driver;
        this.wait = new WaitUtils(driver,10);
    }

    private By proceedToCheckouBtn = By.xpath("//a[@class='btn btn-default check_out']");
    private By processOnlastScreen = By.xpath("///a[@href='/payment']");

    public void clickOncheckoutbtn(){
        driver.findElement(proceedToCheckouBtn).click();
    }
    public void placeOrderBtn(){
        driver.findElement(processOnlastScreen).click();
    }
}
