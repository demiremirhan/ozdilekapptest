package pages;

import Base.BaseTest;
import log.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BaseTest {

Log log = new Log();

By loginPageChecker = By.id("com.ozdilek.ozdilekteyim:id/btnLogin");
By backButton = By.id("com.ozdilek.ozdilekteyim:id/ivBack");
    By loginButton = By.id("com.ozdilek.ozdilekteyim:id/btnLogin");

public boolean checkLoginPage(){
    appiumDriverFluentWait.until(ExpectedConditions.elementToBeClickable(loginButton));
    if (appiumDriver.findElement(loginPageChecker).getText().equals("Giriş Yap")){
        log.info("Giriş yap ekranı doğrulandı.");
        return true;
    }else{
        log.error("Giriş yap ekranı getirilemedi.");
        return false;
    }
}
public void clickBackButton(){
    appiumDriver.findElement(backButton).click();
    log.info("Geri butonuna basıldı.");
}

}

