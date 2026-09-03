package Manager;

import POM.AddToCart;
import POM.Checkout;
import POM.Login;
import POM.Logout;
import POM.Payment;
import Utils.WaitUtils;
import org.openqa.selenium.WebDriver;

public class PageObjectManager {

    private final WebDriver driver;
    private final WaitUtils waitUtils;   // ✅ common wait object

    private Login login;
    private Logout logout;
    private AddToCart addToCart;
    private Checkout checkout;
    private Payment payment;

    public PageObjectManager(WebDriver driver) {
        this.driver = driver;
        this.waitUtils = new WaitUtils(driver, 15); // global timeout
    }

    public WaitUtils getWaitUtils() {
        return waitUtils;
    }

    public Login getLogin() {
        if (login == null) {
            login = new Login(driver , waitUtils);
        }
        return login;
    }

    public Logout getLogout() {
        if (logout == null) {
            logout = new Logout(driver , waitUtils);
        }
        return logout;
    }

    public AddToCart getAddToCart() {
        if (addToCart == null) {
            addToCart = new AddToCart(driver , waitUtils);
        }
        return addToCart;
    }

    public Checkout getCheckout() {
        if (checkout == null) {
            checkout = new Checkout(driver,waitUtils);
        }
        return checkout;
    }

    public Payment getPayment() {
        if (payment == null) {
            payment = new Payment(driver , waitUtils);
        }
        return payment;
    }
}
