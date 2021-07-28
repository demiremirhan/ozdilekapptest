package pages;

import Base.BaseTest;
import log.Log;
import org.openqa.selenium.By;

public class CategoriesPage extends BaseTest {

    Log log = new Log();
    By categoriesPageChecker = By.xpath("//android.widget.LinearLayout[@content-desc=\"Kategoriler\"]/android.widget.TextView");
    By kadinCategoryElement = By.xpath("//androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[2]");
    By pantolonCategoryElement = By.xpath("//android.widget.RelativeLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[4]");

    public boolean checkCategoriesPage(){
        if (appiumDriver.findElement(categoriesPageChecker).isEnabled()){
            log.info("kategoriler sayfası açıldı.");
            return true;
        }else {
            log.error("Kategoriler sayfasına ulaşılamadı.");
            return false;
        }
    }
    public void clickKadinCat(){
        appiumDriver.findElement(kadinCategoryElement).click();
        log.info("Kadın kategorisine tıklandı");
    }
    public void  clickPantCat(){
        appiumDriver.findElement(pantolonCategoryElement).click();
        log.info("Pantolon sekmesine tıklandı.");
    }
}
