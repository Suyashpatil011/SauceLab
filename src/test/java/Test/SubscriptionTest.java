package Test;

import Base.Base;
import POM.Subscription;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SubscriptionTest extends Base {

    @Test(groups = {"Sc", "sanity"}, dependsOnGroups = "Login")
    public void verifyFooterSubscription()
    {
        Subscription sc = new Subscription(driver, waitUtils);
        sc.scrollToFooter();
        String title = sc.getSubscriptionTitle();
        Assert.assertEquals(title, "SUBSCRIPTION");
        sc.getSubscriptionTitle();
        sc.enterEmail("suyashpatil01@gmail.com");
        sc.clickSubmit();
        String notification = sc.getToastNotification();
        Assert.assertEquals(notification, "You have been successfully subscribed!");
    }
}
