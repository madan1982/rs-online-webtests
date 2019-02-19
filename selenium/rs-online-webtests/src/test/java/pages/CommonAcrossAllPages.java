package pages;

import library.WebLibrary;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CommonAcrossAllPages extends WebLibrary {
    private WebDriver driver;
    public CommonAcrossAllPages(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(className = "icon-cart")
    private WebElement cartIcon;

    @FindBy(css = ".deliveryHeaderDiv > .layerTitleText")
    private WebElement paymentHeading;

    @FindBy(css = " button[class='btn btn-primary-red btn-large btn-add-to-basket']")
    private WebElement addToBasketButton;

    @FindBy(css = "button[class='btn btn-secondary-blue btn-large nav-view-cart ']")
    private WebElement viewBasketButton;

    @FindBy(id="js-basketQty")
    private WebElement quantityInBasketElement;

    public void clickOnFinalProductForGivenMainProductAndSubProduct(String mainProduct, String subProduct, String finalProductType) {
        waitForMilliSeconds(500);
        closeSurveyPopUpIfExist(driver);
        driver.findElement(By.cssSelector("a[href='/web/c/"+mainProduct+"/"+subProduct+"/"+finalProductType+"/']")).click();
        Assert.assertTrue(driver.getCurrentUrl().contains(finalProductType));
    }

    public void clickOnFinalProductTypeLinkWithMainProductAndSubProduct(String mainProduct, String subProduct, String finalProductType) {
        waitForMilliSeconds(500);
        closeSurveyPopUpIfExist(driver);
        driver.findElement(By.xpath("//li/a[starts-with(@href,'https://uk.rs-online.com/web/c/"+mainProduct+"/"+subProduct+"/"+finalProductType+"/?applied-dimensions=')]")).click();
        Assert.assertTrue(driver.getCurrentUrl().contains(finalProductType));
    }

    public void addGivenProductsToCartFromProductListScreen(String listOfProducts) {
        waitForMilliSeconds(500);
        closeSurveyPopUpIfExist(driver);
        if (listOfProducts.trim().contains(",")){
            String multiProductList[] = listOfProducts.split((","));
            for (String stockNumber : multiProductList) addProductToBasketForGivenRSSstockNumber(stockNumber);
        }else {
            addProductToBasketForGivenRSSstockNumber(listOfProducts);
        }
    }
    
    private void addProductToBasketForGivenRSSstockNumber(String rssStockNumber){
        waitForMilliSeconds(500);
        closeSurveyPopUpIfExist(driver);
        driver.findElement(By.cssSelector("button[data-rsstocknumber='"+rssStockNumber+"']")).click();
    }

    public void clickOnBasketIcon() {
        closeSurveyPopUpIfExist(driver);
        waitForMilliSeconds(500);
        cartIcon.click();
    }

    public void verifyPaymentScreen() {
        Assert.assertTrue(paymentHeading.isDisplayed());
    }

    public void clickOnSpecificProduct(String rsStockNumber) {
        closeSurveyPopUpIfExist(driver);
        rsStockNumber = rsStockNumber.replace("-", "");
//        driver.findElement(By.cssSelector("a[href='.*/"+rsStockNumber+"/']")).click();
        driver.findElement(By.xpath("//div/a[contains(@href,'/"+rsStockNumber+"/')][1]")).click();
    }

    public void addToBasketOnProductScreen(){
        closeSurveyPopUpIfExist(driver);
        addToBasketButton.click();
    }

    public void viewBasketFromProductScreen(){
        closeSurveyPopUpIfExist(driver);
        viewBasketButton.click();
    }

    public int numberOfItemsInBasket(){
        waitForMilliSeconds(2000);
        closeSurveyPopUpIfExist(driver);
        return Integer.parseInt(quantityInBasketElement.getText());
    }
}
