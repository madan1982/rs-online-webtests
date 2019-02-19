package steps;

import com.google.inject.Inject;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.openqa.selenium.WebDriver;
import pages.SearchResults;

public class SearchResultsStepDef {
    @Inject
    private WebDriver driver;

    private static SearchResults searchResults;

    @And("^customer selects top category (.*)$")
    public void selectGivenTopCategoryFromSearchResults(String searchResultTopCategory){
        searchResults = new SearchResults(driver);
        searchResults.clickOnGivenTopCategoryInSearchResults(searchResultTopCategory);
    }

    @And("^customer applies main filter (.*) and sub filter (.*) and close sub filter popup$")
    public void selectMainFilterAndSubFilterAndCloseFilterPopUp(String mainFilter, String subFilter){
        selectMainFilterAndSubFilter(mainFilter, subFilter);
        searchResults.closeSubFilterPopUp();
    }

    @And("^customer clicks on Apply Filters on sub category filter pop-up$")
    public void applyFilterFromFilterPopUp(){
        searchResults.applyFilterFromFilterPopUp();
    }

    @And ("^customer clicks on Apply Filters on main screen$")
    public void applyFiltersOnMainScreen(){
        searchResults.clickApplyFiltersOnMainScreen();
    }

    @Then("^print search results$")
    public void printResults(){
        searchResults.printResultsMessage();
    }

    @And("^customer applies main filter (.*) and sub filter (.*) and do NOT Close filter pop-up$")
    public void selectMainFilterAndSubFilter(String mainFilter, String subFilter){
        searchResults = new SearchResults(driver);
        searchResults.applyGivenMainFilterCategory(mainFilter);
        searchResults.applyGivenFilterSubCategory(subFilter);
    }

    @And ("^customer selects product category (.*) from side menu of search results$")
    public void selectProductCategoryFromSideMenu(String prodCategory){
        searchResults = new SearchResults(driver);
        searchResults.selectProductCategoryFromSideMenuSearchResults(prodCategory);
    }

}
