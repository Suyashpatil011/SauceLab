package Test;

import Base.Base;
import POM.Logout;
import org.testng.annotations.Test;

public class LogoutTest extends Base {

    @Test(groups = {"Logout", "sanity"}, dependsOnGroups = "Payment")
    public void testLogout(){
        Logout lg = pom.getLogout();
        lg.clickLogoutBtn();
        log.info("E2E Testing Completed..!!");
    }
}
