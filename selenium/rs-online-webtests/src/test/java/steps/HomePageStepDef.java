package steps;

import com.google.inject.Inject;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.Authentication;
import pages.CommonAcrossAllPages;
import pages.HomePage;

public class HomePageStepDef {

    @Inject
    private WebDriver driver;

    private static HomePage homePage;
    private static Authentication authentication;
    private static CommonAcrossAllPages commonAcrossAllPages;

    @Given("^customer opened homepage$")
    public void launchHomePage(){
        driver.get("https://uk.rs-online.com/web/");
        homePage = new HomePage(driver);
    }

    @And("^customer accept cookies by clicking on Ok I understand$")
    public void acceptCookie(){
        homePage.clickOnIUnderstandToAcceptCookie();
    }

    @And("^customer selects (.*) and (.*) from All products menu$")
    public void selectSubMenuFromAllProducts(String mainProduct, String subProduct){
        homePage.clickOnAllProducts();
        homePage.moveOnToMainProductTypeFromAllProductsMenuAndSelectSubProduct(mainProduct, subProduct);
    }

    @And("^customer will login with username (.*) and password (.*)$")
    public void login(String username, String password){
        homePage.clickLogin();
        commonAcrossAllPages = new CommonAcrossAllPages(driver);
        authentication = new Authentication(driver);
        authentication.login(username, password);
    }

    @And("^verify customer is logged in by checking customers name which should be displayed As (.*)$")
    public void verifyGreeting(String customerName){
        homePage.verifyGreeting(customerName);
    }

    @And("^customer selects (.*) from Our Brands$")
    public void selectBrand(String brandName){
        homePage.clickOnSpecificBrandFromOurBrands(brandName.trim());
    }

    @When("^customer search for (.*) and click search icon$")
    public void searchForGivenTermAndClickSearchIcon(String searchTerm){
        homePage.enterSearchTermAndClickOnSearchIcon(searchTerm);
    }

    @When("^customer search for (.*) and do NOT click on search Icon$")
    public void searchForGivenTermOnly(String searchTerm){
        homePage.enterSearchTermOnly(searchTerm);
    }

    @And("^customer selects search hint category (.*)$")
    public void selectSearchResultsFromHintCategory(String category){
        homePage.selectHintResultCategory(category);
    }

}
