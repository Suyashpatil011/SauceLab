package Test;

import Base.Base;
import POM.AddToCart;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class AddToCartTest extends Base {


    private AddToCart at;  // declare once

    @BeforeMethod(alwaysRun = true)
    public void initPageObjects(java.lang.reflect.Method method) {
        at = pom.getAddToCart();
        if (method.getName().equals("testAddToCart")) {
            // Navigate explicitly since login lands on the home page, not the products listing
            driver.get("https://automationexercise.com/products");
        }
    }

    @Test(groups = {"AddToCart", "sanity"}, dependsOnGroups = "Login")
    public void testAddToCart() {
        log.info("adding product test...");
        at.hoveronAddToCart("Winter Top");
        log.info("Product added successfully...");
        at.clickonAddToCart();
        log.info("Navigated to checkout flow..");
    }

    @Test(groups = {"AddToCart", "sanity"}, dependsOnMethods = "testAddToCart")
    public void testcheckout() {
        // Already navigated to /view_cart via testAddToCart's modal click - just verify we landed there
        Assert.assertTrue(driver.getCurrentUrl().contains("/view_cart"), "Did not land on the cart page");
        Assert.assertTrue(at.isProductInCart("Winter Top"), "Added product 'Winter Top' was not found in the cart");
        log.info("Verified added product 'Winter Top' is present in the cart");
    }


}
