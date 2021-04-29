package testClasses;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObject.BasePage;
import pageObject.PastaPage;

public class TestFieldValidation extends BasePage {


    @DataProvider(name = "IncorrectInput")
    public static Object[][]  userDataIncorrect() {
        return new Object[][]{
                {"a"},
                {"$"},
                {"#"},
                {"!"},
                {"@"},
                {"<"},
                {"%"},
                {"^"},
                {"z"}
        };
    }

    @DataProvider(name = "CorrectInput")
    public static Object[][]  userDataCorrect() {
        return new Object[][]{
                {"0"},
                {"1"},
                {"8"}
        };
    }

    @Test(groups = { "include" }, dataProvider = "IncorrectInput")
    public void verifyIncorrectField(String data) {
        PastaPage pastaPage = new PastaPage(driver);
        pastaPage.fieldIncorrectValidation(data);
    }

    @Test(groups = { "include" }, dataProvider = "CorrectInput")
    public void verifyCorrectField(String data) {
        PastaPage pastaPage = new PastaPage(driver);
        pastaPage.fieldCorrectValidation(data);
    }
}
