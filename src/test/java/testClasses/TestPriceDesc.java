package testClasses;

import org.testng.annotations.Test;
import pageObject.BasePage;
import pageObject.PastaPage;

public class TestPriceDesc extends BasePage {

    @Test(groups = { "include"})
    public void verifyPrices() {
        PastaPage pastaPage = new PastaPage(driver);
        pastaPage.priceDesc()
                .getPricesDesc();
    }
}
