package Test;

import Base.Base;
import POM.Checkout;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckoutTest extends Base {
    private Checkout ck;

    @BeforeMethod(alwaysRun = true)
    public void initPageObject() {
        ck = pom.getCheckout();
    }


    @Test(groups = {"Checkout", "sanity"}, dependsOnGroups = "AddToCart")
    public void testCheckoutbtn() {
        ck.clickOncheckoutbtn();
    }

    @Test(groups = {"Checkout", "sanity"}, dependsOnMethods = "testCheckoutbtn")
    public void testProcessbtn() {
        ck.clickOncheckoutbtn();
    }

}

