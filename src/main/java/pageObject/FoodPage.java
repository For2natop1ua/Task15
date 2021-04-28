package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FoodPage extends BasePage {

    @FindBy(xpath = "//a[@href='/ct/9202/']")
    private WebElement pasta;

    public FoodPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void openPastaPage() {
        pasta.click();
        new PastaPage(driver);
    }
}
