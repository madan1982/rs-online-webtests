package config;

import com.google.inject.Inject;
import cucumber.api.java.After;
import org.openqa.selenium.WebDriver;

public class Hooks {
    @Inject
    private WebDriver driver;

    @After
    public void after () {driver.quit();}
}
