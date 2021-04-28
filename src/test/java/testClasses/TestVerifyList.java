package testClasses;

import org.testng.annotations.Test;
import pageObject.BasePage;
import pageObject.PastaPage;

public class TestVerifyList extends BasePage {

    @Test(groups = { "exclude" })
    public void verifyPastaList() {
        PastaPage pastaPage = new PastaPage(driver);
        pastaPage.checkTitle();
    }
}