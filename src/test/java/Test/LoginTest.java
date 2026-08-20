package Test;

import Base.Base;
import POM.Login;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends Base {

    @Test(groups = {"Login", "sanity"})
    public void testValidLogin() {

        Login login = pom.getLogin();
        log.info("Starting login test...");
        login.enterEmail("suyashpatil0100@gmail.com");
        log.info("Enter password test...");
        login.enterPassword("Suyash@001");
        log.info("Click login button...");
        login.clickLogin();
        log.info("Login test complete");
    }

    @Test
    public void testInvValidLogin() {

        Login login = pom.getLogin();
        log.info("Starting login test...");
        login.enterEmail("suyashpatil010@gmail.com");
        log.info("Enter password test...");
        login.enterPassword("Suyash@00001");
        log.info("Click login button...");
        login.clickLogin();
        String error = login.errorvalidation();
        log.error("Capture error msg :" + error);
        Assert.assertEquals(error, "Your email or password is incorrect!",
                "Error message did not match expected text!");
        log.info("Invalid Test Completed");


    }
}
