package pages;

import library.WebLibrary;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResults extends WebLibrary {
    private WebDriver driver;
    public SearchResults(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(xpath = "//div[contains(@class, 'top-categories-container')]")
    private WebElement topCategoryGrid;

    @FindBy(xpath = "//span[@class='icon icon-rs_23-cross close-icon']")
    private WebElement closeSubCategoryFilterIcon;

    @FindBy(xpath = "//button[text() = 'Apply filters']")
    private WebElement applyFilterButtonOnMainScreen;

    @FindBy(xpath = "//rs-apply-button / button[@class='btn btn-primary matches-btn active']")
    private WebElement applyFilterButtonOnFilterPopUp;

    @FindBy(xpath = "//div[contains(@class, 'paginationMessage')]")
    private WebElement resultsMessage;

    @FindBy(id="sidebar")
    private WebElement searchResultsCategoriesOnLeftSideMenu;

    public void clickOnGivenTopCategoryInSearchResults(String searchResultTopCategory) {
        closeSurveyPopUpIfExist(driver);
        topCategoryGrid.findElement(By.xpath("//a[contains(@href, '"+searchResultTopCategory+"')]")).click();
        closeSurveyPopUpIfExist(driver);
    }
    public void closeSubFilterPopUp(){
        closeSubCategoryFilterIcon.click();
        waitForMilliSeconds(200);
    }
    public void clickApplyFiltersOnMainScreen(){
        applyFilterButtonOnMainScreen.click();
        waitForMilliSeconds(1000);
        closeSurveyPopUpIfExist(driver);
    }
    public void printResultsMessage(){
        System.out.println("********* Search Results: " + resultsMessage.getText());
    }
    public void applyFilterFromFilterPopUp() {
        applyFilterButtonOnFilterPopUp.click();
        waitForMilliSeconds(1000);
        closeSurveyPopUpIfExist(driver);
    }

    public void applyGivenMainFilterCategory(String mainFilterType){
        closeSurveyPopUpIfExist(driver);
        driver.findElement(By.xpath("//a[text() = '"+mainFilterType+"']")).click();
        waitForMilliSeconds(200);
    }

    public void applyGivenFilterSubCategory(String subFilterType){
        driver.findElement(By.xpath("//span[@class='filterCheckboxLabelText']/span[text() = '"+subFilterType+"']")).click();
        waitForMilliSeconds(200);
    }

    public void selectProductCategoryFromSideMenuSearchResults(String productCategory){
        closeSurveyPopUpIfExist(driver);
        searchResultsCategoriesOnLeftSideMenu.findElement(By.xpath("//span[text() = '"+productCategory+"']")).click();
        waitForMilliSeconds(500);
    }
}
