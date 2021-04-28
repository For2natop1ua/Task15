package testClasses;

import org.testng.annotations.Test;
import pageObject.BasePage;
import pageObject.PastaPage;

public class TestPriceAsc extends BasePage {

    @Test(groups = { "include" })
    public void verifyPrices() {
        PastaPage pastaPage = new PastaPage(driver);
        pastaPage.priceAsc()
                .getPricesAsc();
    }
}
