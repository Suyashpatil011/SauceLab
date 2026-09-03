package Test;

import Base.Base;
import POM.Login;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends Base {

    @Test(groups = {"Login", "sanity"})
    public void testValidLogin() {
        // Use PageObjectManager to get Login POM
        Login login = pom.getLogin();

        log.info("Starting valid login test...");
        pom.getWaitUtils().waitForPageAndImages(); // ✅ global wait
        login.enterEmail("suyashpatil0100@gmail.com");
        log.info("Entered email");

        login.enterPassword("Suyash@001");
        log.info("Entered password");

        login.clickLogin();
        log.info("Clicked login button");

        // Add assertion if you want to verify successful login
        // Example: Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"));
        log.info("Valid login test completed successfully");
    }

    @Test(groups = {"Login", "negative"})
    public void testInvalidLogin() {
        Login login = pom.getLogin();

        log.info("Starting invalid login test...");
        pom.getWaitUtils().waitForPageAndImages(); // ✅ global wait

        login.enterEmail("suyashpatil010@gmail.com");
        log.info("Entered invalid email");

        login.enterPassword("Suyash@00001");
        log.info("Entered invalid password");

        login.clickLogin();
        log.info("Clicked login button");

        String error = login.errorvalidation();
        log.error("Captured error message: " + error);

        Assert.assertEquals(error, "Your email or password is incorrect!",
                "Error message did not match expected text!");

        log.info("Invalid login test completed successfully");
    }
}
