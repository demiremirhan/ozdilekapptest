package pages;

import Base.BaseTest;
import log.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainPage extends BaseTest {

    Log log = new Log();
    By slider = By.id("com.ozdilek.ozdilekteyim:id/viewpager");
    By categoriesPageIcon = By.id("com.ozdilek.ozdilekteyim:id/nav_categories");
    public boolean checkMainPage(){
        appiumDriverFluentWait.until(ExpectedConditions.elementToBeClickable(categoriesPageIcon));
        if (appiumDriver.findElement(slider).isDisplayed()){
            log.info("Anasayfa açıldı.");
            return true;
        }else {
            log.error("Anasayfa açılmasında hata oluştu.");
            return false;
        }
    }
    public void clickCategoriesPage(){
        appiumDriver.findElement(categoriesPageIcon).click();
        log.info("Kategoriler sayfasına tıklandı.");
    }

}
