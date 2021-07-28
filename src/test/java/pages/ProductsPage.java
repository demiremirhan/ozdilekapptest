package pages;

import Base.BaseTest;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import log.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class ProductsPage extends BaseTest {
    Log log = new Log();

    By products = By.xpath("//android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout");
    By productsPageChecker = By.id("com.ozdilek.ozdilekteyim:id/relLayChangeColumnCount");
    By loginIcon = By.id("com.ozdilek.ozdilekteyim:id/nav_account");
    By cartIcon = By.id("com.ozdilek.ozdilekteyim:id/nav_cart");

    public void swipeScreen(int h1,int h2){
        TouchAction action = new TouchAction(appiumDriver);
        Dimension dimensions = appiumDriver.manage().window().getSize();
        Double screenHeightStart = dimensions.getHeight() * 0.5;
        h1 = screenHeightStart.intValue();
        Double screenHeightEnd = dimensions.getHeight() * 0.2;
        h2 = screenHeightEnd.intValue();
        action.press(PointOption.point(0,h1))
                .waitAction(new WaitOptions().withDuration(Duration.ofMillis(600)))
                .moveTo(PointOption.point(0, h2))
                .release()
                .perform();
        log.info("Ekran kaydırıldı.");
    }

    public void clickLastFav(){
        // last özelliğinin nasıl kullanacağımı bilmediğimden bu şekilde bir notasyon izledim.
       int a= appiumDriver.findElements(products).size();
       String xpath ="//androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout["+a+"]/android.view.ViewGroup/android.widget.ImageView[2]";
       By favIcon= By.xpath(xpath);
       appiumDriver.findElement(favIcon).click();
       log.info("Ekrandaki son ürün favorilere eklendi.");
}
    public boolean checkProductsPage(){
        if (appiumDriver.findElement(productsPageChecker).isDisplayed()){
            log.info("Ürünler sayfasına geri dönüldü.");
            return true;
        }else{
            log.error("Ürünler sayfasına ulaşılırken hata oldu.");
            return false;
        }
    }
    public void clickLoginPage(){

        log.info("Hesabım sayfasına gidildi.");
        appiumDriver.findElement(loginIcon).click();
    }
    public void clickCartPage(){
        appiumDriverFluentWait.until(ExpectedConditions.elementToBeClickable(cartIcon));
        log.info("Sepetim sayfasına gidildi.");
        appiumDriver.findElement(cartIcon).click();
    }
}
