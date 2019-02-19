package pages;

import library.WebLibrary;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class DeliveryAddress extends WebLibrary {
    private WebDriver driver;
    public DeliveryAddress(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(className = "title")
    private WebElement titleElement;

    @FindBy(className = "firstName")
    private WebElement firstNameEdit;

    @FindBy(className = "surName")
    private WebElement surNameEdit;

    @FindBy(className = "contactNumber")
    private WebElement contactNumberEdit;

    @FindBy(className = "companyNameOne")
    private WebElement nameEdit;

    @FindBy(id = "deliveryCollectionForm:GuestDeliveryAddressWidgetAction_companyNameTwo_decorate:GuestDeliveryAddressWidgetAction_companyNameTwo")
    private WebElement tradingNameEdit;

    @FindBy(className = "addressLineOne")
    private WebElement addressLineOneEdit;

    @FindBy(id = "deliveryCollectionForm:GuestDeliveryAddressWidgetAction_addressLineTwo_decorate:GuestDeliveryAddressWidgetAction_addressLineTwo")
    private WebElement addressLineTwoEdit;

    @FindBy(id = "deliveryCollectionForm:GuestDeliveryAddressWidgetAction_addressLineThree_decorate:GuestDeliveryAddressWidgetAction_addressLineThree")
    private WebElement townEdit;

    @FindBy(id="deliveryCollectionForm:GuestDeliveryAddressWidgetAction_selectedRegion_decorate:selectedRegion")
    private WebElement countyElement;

    @FindBy(className = "postCode")
    private WebElement postCodeEdit;

    @FindBy(id = "checkoutSecurelyBtn")
    private WebElement continueToPaymentButton;

    @FindBy(className = "listAddressItemdataTd")
    private WebElement addressElement;

    public void enterPersonalAndContactDetails(String title, String firstName, String surName, String contactNum){
        Select titleList = new Select(titleElement);
        titleList.selectByVisibleText(title.trim());
        firstNameEdit.sendKeys(firstName.trim());
        surNameEdit.sendKeys(surName.trim());
        contactNumberEdit.sendKeys(contactNum.trim());
    }

    public void enterDeliveryAddress(String name, String tradingName, String addressLine1, String addressLine2, String town, String county, String postCode){
        nameEdit.sendKeys(name.trim());
        tradingNameEdit.sendKeys(tradingName.trim());
        addressLineOneEdit.sendKeys(addressLine1.trim());
        addressLineTwoEdit.sendKeys(addressLine2.trim());
        townEdit.sendKeys(town.trim());
        Select countyList = new Select(countyElement);
        countyList.selectByValue(county.trim());
        postCodeEdit.sendKeys(postCode.trim());
    }

    public void clickOnContinueToPayment(){
        continueToPaymentButton.click();
    }

    public void verifyDeliveryAddressIsSelectedForCustomer() {
        Assert.assertTrue(addressElement.isDisplayed());
    }

}
