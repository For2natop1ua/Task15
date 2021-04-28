package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage{

    @FindBy(xpath = "//a[@href='/food/']")
    private WebElement food;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public HomePage openPage() {
        driver.get("https://pn.com.ua/");
        return this;
    }

    public FoodPage openFoodPage() {
        food.click();
        return new FoodPage(driver);
    }
}
