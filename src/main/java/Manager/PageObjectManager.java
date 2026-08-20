package Manager;

import POM.AddToCart;
import POM.Checkout;
import POM.Login;
import POM.Logout;
import POM.Payment;
import org.openqa.selenium.WebDriver;

public class PageObjectManager {

    private final WebDriver driver;

    private Login login;
    private Logout logout;
    private AddToCart addToCart;
    private Checkout checkout;
    private Payment payment;

    public PageObjectManager(WebDriver driver) {
        this.driver = driver;
    }

    public Login getLogin() {
        if (login == null) {
            login = new Login(driver);
        }
        return login;
    }

    public Logout getLogout() {
        if (logout == null) {
            logout = new Logout(driver);
        }
        return logout;
    }

    public AddToCart getAddToCart() {
        if (addToCart == null) {
            addToCart = new AddToCart(driver);
        }
        return addToCart;
    }

    public Checkout getCheckout() {
        if (checkout == null) {
            checkout = new Checkout(driver);
        }
        return checkout;
    }

    public Payment getPayment() {
        if (payment == null) {
            payment = new Payment(driver);
        }
        return payment;
    }
}
