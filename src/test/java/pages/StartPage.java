package pages;

import Base.BaseTest;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import log.Log;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class StartPage extends BaseTest {
    Log log = new Log();

    By alisveriseBaslaButonu = By.id("com.ozdilek.ozdilekteyim:id/tv_startShoppingStore");
    By alisverisIcon = By.id("com.ozdilek.ozdilekteyim:id/iv_storeIcon");
    public boolean checkOpenActivity(){
        appiumDriverFluentWait.until(ExpectedConditions.elementToBeClickable(alisveriseBaslaButonu));
        if (appiumDriver.findElement(alisverisIcon).isDisplayed()){
            log.info("Uygulamanın açılması kontrol edildi.");
            return true;
        }else {
            log.error("Uygulamanın açılması gerçekleşmedi");
            return false;
        }
    }

    public void clickAlisverisetTikla(){
        appiumDriver.findElement(alisveriseBaslaButonu).click();
        System.out.println("Alışverişe başla butonuna basıldı");
        log.info("Alisveris butonuna tiklandi.");
    }
}
