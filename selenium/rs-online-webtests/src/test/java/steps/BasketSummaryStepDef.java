package steps;

import com.google.inject.Inject;
import cucumber.api.java.en.And;
import org.openqa.selenium.WebDriver;
import pages.BasketSummary;
import pages.CommonAcrossAllPages;

public class BasketSummaryStepDef {
    @Inject
    private WebDriver driver;

    private static BasketSummary basketSummary;
    private static CommonAcrossAllPages commonAcrossAllPages;


    @And("^customer verifies all added products (.*) displayed in basket summary screen$")
    public void verifyProductsAdded(String stockNumbersOfProductsAdded){
        basketSummary = new BasketSummary(driver);
        commonAcrossAllPages = new CommonAcrossAllPages(driver);
        basketSummary.verifyProductsAdded(stockNumbersOfProductsAdded);
    }

    @And("^customer clicks on Checkout securely$")
    public void checkOutSecurely(){
        basketSummary.clickOnCheckOutSecurely();
    }

    @And("^customer chooses Guest checkout after entering email address (.*)$")
    public void guestCheckout(String emailAddress){
        basketSummary.enterEmailAddressAndGuestCheckout(emailAddress);
    }

    @And("^check customer basket and empty basket if there are items$")
    public void emptyCustomerBasket(){
        commonAcrossAllPages = new CommonAcrossAllPages(driver);
        if(commonAcrossAllPages.numberOfItemsInBasket()>0) {
            basketSummary = new BasketSummary(driver);
            commonAcrossAllPages.clickOnBasketIcon();
            basketSummary.emptyBasket();
        }
    }
}
