package pages;

import library.WebLibrary;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends WebLibrary {
    private WebDriver driver;
    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(id = "js-cookie-accept")
    private WebElement understandCookie;

    @FindBy(css = "a[title='All Products']")
    private WebElement allProductsLink;

    @FindBy(css = "a[title='Log In']")
    private WebElement loginLink;

    @FindBy(id = "js-welcome")
    private WebElement welcomeElement;

    @FindBy(css = "a[title='Our Brands']")
    private WebElement ourBrandsElement;

    @FindBy(id = "searchTerm")
    private WebElement mainSearchEdit;

    @FindBy(className = "icon-search")
    private WebElement searchIcon;

    @FindBy(id = "js-search-hint")
    private WebElement searchHintResults;

    public void clickOnAllProducts(){
        allProductsLink.click();
        waitForMilliSeconds(500);
    }

    public void clickOnIUnderstandToAcceptCookie(){
        understandCookie.click();
        waitForMilliSeconds(500);
        waitForInvisibility(understandCookie, 2);
    }

    public void moveOnToMainProductTypeFromAllProductsMenuAndSelectSubProduct(String mainProductType, String subProductType) {
        closeSurveyPopUpIfExist(driver);
        WebElement mainProductElement = driver.findElement(By.cssSelector("a[href='/web/c/"+mainProductType+"/']"));
        new Actions(driver).moveToElement(mainProductElement).perform();
        waitForMilliSeconds(500);
        driver.findElement(By.cssSelector("a[href='/web/c/"+mainProductType+"/"+subProductType+"/']")).click();
        Assert.assertTrue(driver.getCurrentUrl().contains(mainProductType));
        Assert.assertTrue(driver.getCurrentUrl().contains(subProductType));
    }

    public void verifyGreeting(String customerName){
        closeSurveyPopUpIfExist(driver);
        Assert.assertTrue(welcomeElement.getText().equalsIgnoreCase("Welcome "+customerName));
    }

    public void clickLogin(){
        loginLink.click();
    }

    public void clickOnSpecificBrandFromOurBrands(String brandName) {
        closeSurveyPopUpIfExist(driver);
        ourBrandsElement.click();
        driver.findElement(By.cssSelector("a[title='"+brandName+"']")).click();
    }

    public void enterSearchTermAndClickOnSearchIcon(String searchTerm) {
        mainSearchEdit.sendKeys(searchTerm);
        searchIcon.click();
    }

    public void enterSearchTermOnly(String searchTerm) {
        mainSearchEdit.sendKeys(searchTerm);
    }

    public void selectHintResultCategory(String category) {
        searchHintResults.findElement(By.xpath("//a[contains(@data-category, '"+category+"')]")).click();
        waitForMilliSeconds(200);
    }

}
