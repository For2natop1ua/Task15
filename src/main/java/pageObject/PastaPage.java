package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class PastaPage extends BasePage {

    @FindBy(css = "ul.short-menu")
    private WebElement shortMenu;
    @FindBy(css = "li.dropdown-sorting")
    private WebElement sortMenu;
    @FindBy(xpath = "//a[@data-sort='price']")
    private WebElement getPriceAsc;
    @FindBy(xpath = "//a[@data-sort='price_desc']")
    private WebElement getPriceDesc;
    @FindBy(xpath = "//a[@data-sort='offer']")
    private WebElement dropdownMenu;
    @FindBy(id = "price-min")
    private WebElement minPrice;
    @FindBy(id = "price-max")
    private WebElement maxPrice;
    @FindBy(xpath = "//span[contains(.,'Макаронные изделия')]")
    private WebElement pastaTitle;
    String prices = "(//div[@class='avg-price'])[position()>0 and position()<=3]";
    String value = "value";
    String expectedResult = "Макаронные изделия";
    static String currency = " грн";
    static String emptyString = "";


    public PastaPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        shortMenu.isDisplayed();
    }

    public void checkTitle(){
        Assert.assertTrue(pastaTitle.getText().contains(expectedResult));
    }

    public PastaPage priceAsc() {
        sortMenu.click();
        dropdownMenu.isDisplayed();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Actions actions = new Actions(driver);
        actions.moveToElement(getPriceAsc).click().perform();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return this;
    }

    public PastaPage priceDesc() {
        sortMenu.click();
        getPriceDesc.isDisplayed();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Actions actions = new Actions(driver);
        actions.moveToElement(getPriceDesc).click().perform();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }

    public void fieldIncorrectValidation(String stringToVerify) {
        fieldValidation(stringToVerify);
        Assert.assertEquals(minPrice.getAttribute(value), emptyString);
        Assert.assertEquals(maxPrice.getAttribute(value), emptyString);
    }

    public void fieldValidation(String stringToVerify){
        minPrice.clear();
        minPrice.sendKeys(stringToVerify);
        maxPrice.clear();
        maxPrice.sendKeys(stringToVerify);
    }

    public void fieldCorrectValidation(String stringToVerify) {
        fieldValidation(stringToVerify);
        Assert.assertEquals(minPrice.getAttribute(value), stringToVerify);
        Assert.assertEquals(maxPrice.getAttribute(value), stringToVerify);
    }

    public void getPricesAsc() {
        List<WebElement> pricesList = driver.findElements(By.xpath(prices));
        int[] arr = integerValues(pricesList);

        if(arr[0]<=arr[1] && arr[1]<=arr[2]) {
            String correct = "Correct!";
            Assert.assertEquals(correct, "Correct!");
        }
        else {
            String correct = "Incorrect!";
            Assert.assertEquals(correct, "Correct!");
        }
    }

    public void getPricesDesc() {
        List<WebElement> pricesList = driver.findElements(By.xpath(prices));
        int[] arr = integerValues(pricesList);
        if(arr[0]>=arr[1] && arr[1]>=arr[2]) {
            String correct = "Correct!";
            Assert.assertEquals(correct, "Correct!");
        }
        else {
            String correct = "Incorrect!";
            Assert.assertEquals(correct, "Correct!");
        }
    }

    public static int[] integerValues(List<WebElement> pricesList){

        String[] str = new String[3];
        int size = str.length;
        for(int i = 0;i<size;i++){
            str[i] = pricesList.get(i).getText().replace(currency, emptyString);
        }

        int[] arr = new int [size];
        for(int i =0; i<size; i++){
            arr[i] = Integer.parseInt(str[i]);
        }

        return arr;
    }
}
