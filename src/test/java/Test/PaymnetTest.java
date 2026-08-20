package Test;

import Base.Base;
import POM.Payment;
import org.testng.annotations.Test;

public class PaymnetTest extends Base {

    @Test(groups = {"Payment", "sanity"}, dependsOnGroups = "Checkout")
    public void testPaymentpage() throws InterruptedException {
        Payment py = pom.getPayment();
        py.enterCardName("MasterCard");
        py.enterCardNumber("4111111111111111");
        py.enterCvcNumber("123");
        py.enterexMonth("01");
        py.enterExYear("2029");
        py.enterSubmitbtn();

        String confirmMsg = py.toastMsg();
        System.out.println(confirmMsg);

    }
}
