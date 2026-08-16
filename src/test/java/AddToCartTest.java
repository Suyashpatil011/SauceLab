import Base.Base;
import POM.AddToCart;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddToCartTest extends Base {


    private AddToCart at;  // declare once

    @BeforeMethod(alwaysRun = true)
    public void initPageObjects() {
        // driver is already initialized by Base.setup()
        at = new AddToCart(driver);
    }

    @Test(groups = "Login")
    public void testAddToCart() {
        log.info("adding product test...");
        at.hoveronAddToCart("Winter Top");
        log.info("Product added successfully...");
        at.clickonAddToCart();
        log.info("Navigated to checkout flow..");
    }

    @Test(groups = "Login")
    public void testcheckout() {
        at.clickonAddToCart();
        log.info("checking out product test...");
    }


}
