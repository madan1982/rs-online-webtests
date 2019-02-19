package pages;

import library.WebLibrary;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class BasketSummary extends WebLibrary {
    private WebDriver driver;
    public BasketSummary(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(id = "checkoutSecurelyAndPuchBtn")
    private WebElement checkOutSeccurelyButton;

    @FindBy(className = "emailAddress")
    private WebElement guestEmailAdderss;

    @FindBy(id = "guestCheckoutForm:guestCheckout")
    private WebElement guestCheckOutButton;

    @FindBy(id = "alreadyRegisteredForm:continue")
    private List<WebElement> alreadyRegisteredGuestContinueButtonExist;

    @FindBy(id = "alreadyRegisteredForm:continue")
    private WebElement alreadyRegisteredGuestContinueButton;

    @FindBy(id = "clearBasketButton")
    private WebElement clearAllItemsInBasketButton;

    @FindBy(id = "confirmDeleteContinue")
    private WebElement confirmDeleteButton;


    public void verifyProductsAdded(String stockNumbersOfProductsAdded) {
        closeSurveyPopUpIfExist(driver);
        waitForMilliSeconds(500);
        if (stockNumbersOfProductsAdded.trim().contains(",")){
            String multiProductList[] = stockNumbersOfProductsAdded.split((","));
            int index = 1;
            for (String stockNumber : multiProductList) {
                verifyGivenMultipleStockNumbersPresentInBasketSummary(stockNumber, index);
                index += 1;
            }
        }else {
            verifyGivenStockNumberPresentInBasketSummary(stockNumbersOfProductsAdded);
        }

    }

    private void verifyGivenMultipleStockNumbersPresentInBasketSummary(String stockNumber, int index){
        closeSurveyPopUpIfExist(driver);
        Assert.assertTrue(driver.findElement(By.xpath("(//span[@class='labelText right5']/following-sibling::span[@class='textTitle'])["+index+"]")).getText().equalsIgnoreCase(stockNumber));
    }

    private void verifyGivenStockNumberPresentInBasketSummary(String stockNumber){
        closeSurveyPopUpIfExist(driver);
        Assert.assertTrue(driver.findElement(By.cssSelector(".labelText + .textTitle")).getText().equalsIgnoreCase(stockNumber));
    }

    public void clickOnCheckOutSecurely(){
        closeSurveyPopUpIfExist(driver);
        checkOutSeccurelyButton.click();
    }

    public void enterEmailAddressAndGuestCheckout(String emailAddress) {
        guestEmailAdderss.sendKeys(emailAddress);
        guestCheckOutButton.click();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        if(alreadyRegisteredGuestContinueButtonExist.size()>0) alreadyRegisteredGuestContinueButton.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    public void emptyBasket(){
        closeSurveyPopUpIfExist(driver);
        clearAllItemsInBasketButton.click();
        confirmDeleteButton.click();
    }


}
