package steps;

import com.google.inject.Inject;
import cucumber.api.java.en.And;
import org.openqa.selenium.WebDriver;
import pages.DeliveryAddress;

public class DeliveryAddressStepDef {

    @Inject
    private WebDriver driver;

    private static DeliveryAddress deliveryAddress;

    @And("^customer fills in Delivery with Title (.*), FirstName (.*), SurName (.*) and ContactNumber (.*)$")
    public void fillDeliveryContactDetails(String title, String firstName, String surName, String contactNumber){
        deliveryAddress = new DeliveryAddress(driver);
        deliveryAddress.enterPersonalAndContactDetails(title, firstName, surName, contactNumber);
    }

    @And("^fill address with Name (.*), TradingName (.*), AddressLine1 (.*), AddressLine2(.*), Town (.*), County(.*) and PostCode (.*) and continue to payment$")
    public void fillDeliveryAddressAndContinueToPayment(String name, String tradingName, String addressLine1, String addressLine2, String town, String County, String postCode){
        deliveryAddress.enterDeliveryAddress(name, tradingName, addressLine1, addressLine2, town, County, postCode);
        deliveryAddress.clickOnContinueToPayment();
    }

    @And("^verify customer has delivery address and continue to payment$")
    public void verifyDeliveryAddressIsSelected(){
        deliveryAddress = new DeliveryAddress(driver);
        deliveryAddress.verifyDeliveryAddressIsSelectedForCustomer();
        deliveryAddress.clickOnContinueToPayment();
    }

}
