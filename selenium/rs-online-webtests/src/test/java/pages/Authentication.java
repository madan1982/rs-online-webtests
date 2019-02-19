package pages;

import library.WebLibrary;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Authentication extends WebLibrary {
    private WebDriver driver;
    public Authentication(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(name = "username")
    private WebElement userNameEdit;

    @FindBy(name = "j_password")
    private WebElement passwordEdit;

    @FindBy(name = "loginBtn")
    private WebElement loginButton;

    public void login(String userName, String password){
        userNameEdit.sendKeys(userName);
        passwordEdit.sendKeys(password);
        loginButton.click();
    }
}
