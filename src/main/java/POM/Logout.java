package POM;

import Utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Logout {

    private WebDriver driver;
    private WaitUtils wait;
    private By logoutBtn = By.xpath("//a[@href='/logout']");

    public Logout(WebDriver driver, WaitUtils waitUtils) {
        this.driver = driver;
        this.wait = new WaitUtils(driver, 10);

    }

    public void clickLogoutBtn() {
        wait.waitForVisibility(logoutBtn).click();
    }


}
