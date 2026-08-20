package Base;

import Manager.PageObjectManager;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import org.apache.logging.log4j.Logger;

public class Base {

    protected static final Logger log = LogManager.getLogger(Base.class);
    protected static WebDriver driver;
    protected static PageObjectManager pom;

    @BeforeSuite(alwaysRun = true)
    public void setup() {
        driver = new ChromeDriver();
        log.info("Intializing driver");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("https://automationexercise.com/login");
        pom = new PageObjectManager(driver);

    }

    @AfterSuite(alwaysRun = true)
    public void teardown() {
        log.info("Tearing down driver");
        driver.quit();

    }

    public static WebDriver getDriver() {
        return driver;
    }
}

