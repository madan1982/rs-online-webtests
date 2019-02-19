package library;

import com.google.inject.Inject;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class WebLibrary {

    @Inject
    private WebDriver driver;

    public static void closeSurveyPopUpIfExist(WebDriver driver){
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        List<WebElement> closeSurveyPopUp = driver.findElements(By.id("fsrFocusFirst"));
        if( !(closeSurveyPopUp.isEmpty()) ) {
            waitForMilliSeconds(500);
            driver.findElement(By.id("fsrFocusFirst")).click();
        }
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    public void waitForInvisibility(WebElement webElement, int maxSeconds) {
        long startTime = System.currentTimeMillis();
        try {
            while (System.currentTimeMillis() - startTime < maxSeconds * 1000 && webElement.isDisplayed()) {}
        } catch (StaleElementReferenceException ignored) {
        }
    }

    public static void waitForMilliSeconds(int milliSeconds){
        try {
            Thread.sleep(milliSeconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
