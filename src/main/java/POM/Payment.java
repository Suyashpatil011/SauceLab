package POM;

import Utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Payment {
    WebDriver driver;
    WaitUtils wait;


    private By nameOnCard = By.name("name_on_card");
    private By cardNumber = By.name("card_number");
    private By cvcNumber = By.name("cvc");
    private By expirationMonth = By.name("expiry_month");
    private By expirationYear = By.name("expiry_year");
    private By submitBtn = By.id("submit");
    private By finalmsg = By.cssSelector("h2[class='title text-center'] b");

    public Payment(WebDriver driver) {
        this.driver = driver;
        this.wait = new WaitUtils(driver, 20);
    }

    public void enterCardName(String cardname) {
        driver.findElement(nameOnCard).sendKeys(cardname);
    }

    public void enterCardNumber(String cardnumber) {
        driver.findElement(cardNumber).sendKeys(cardnumber);
    }

    public void enterCvcNumber(String cvc) {
        driver.findElement(cvcNumber).sendKeys(cvc);
    }


    public void enterexMonth(String month) {
        driver.findElement(expirationMonth).sendKeys(month);
    }


    public void enterExYear(String Year) {
        driver.findElement(expirationYear).sendKeys(Year);
    }


    public void enterSubmitbtn() {
        driver.findElement(submitBtn).click();
    }

    public String toastMsg() throws InterruptedException {
        Thread.sleep(4000);
        return wait.waitForVisibility(finalmsg).getText();

    }


}
