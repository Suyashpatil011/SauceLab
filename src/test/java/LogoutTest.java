import Base.Base;
import POM.Logout;
import org.testng.annotations.Test;

public class LogoutTest extends Base {

    @Test(groups = "Login")

    public void testLogout(){
        Logout lg = new Logout(driver);
        lg.clickLogoutBtn();
        log.info("E2E Testing Completed..!!");
    }
}
