package config;

import com.google.inject.Provider;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;

import java.util.concurrent.TimeUnit;

public class Driver implements Provider<WebDriver> {

    private WebDriver driver;

    @Override
    public WebDriver get() {
        initializeDriver ("chrome");
        return driver;
    }

    private void initializeDriver(String browser) {
        switch ( browser.toLowerCase() ){
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "browserdrivers/chromedriver.exe");
                driver = new ChromeDriver(getChromeOptions());
                break;
            case "firefox":
                System.setProperty("webdriver.gecko.driver", "browserdrivers/geckodriver.exe");
                driver = new FirefoxDriver();
                break;
            case "ie":
                System.setProperty("webdriver.ie.driver", "browserdrivers/IEDriverServer.exe");
                driver = new InternetExplorerDriver();
                break;
            default:
                System.setProperty("webdriver.chrome.driver", "browserdrivers/chromedriver.exe");
                driver = new ChromeDriver(getChromeOptions());
                break;
        }
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    private ChromeOptions getChromeOptions() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        chromeOptions.addArguments("enable-automation");
        chromeOptions.setExperimentalOption("useAutomationExtension", false);
        chromeOptions.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.DISMISS);
        return chromeOptions;
    }
}
