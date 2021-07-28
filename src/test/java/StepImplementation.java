import Base.BaseTest;
import com.thoughtworks.gauge.Step;
import io.appium.java_client.TouchAction;
import log.Log;
import org.junit.Assert;
import org.openqa.selenium.By;
import pages.*;
public class StepImplementation extends BaseTest {


    StartPage startPage = new StartPage();
    MainPage mainPage = new MainPage();
    CategoriesPage categoriesPage = new CategoriesPage();
    ProductsPage productsPage = new ProductsPage();
    LoginPage loginPage = new LoginPage();

    @Step("Uygulama açılması kontrol edilir")
    public void checkOpenActivity(){
        startPage.checkOpenActivity();
        Assert.assertTrue(startPage.checkOpenActivity());
    }
    @Step("Alışveriş yap butonuna tıklanır")
    public void clickAlisverisetTikla(){
        startPage.clickAlisverisetTikla();
    }
    @Step("Alışveriş sayfasının açıldığı doğrulanır")
    public void checkMainPage(){
        Assert.assertTrue("Anasayfa açılışı gerçekleşemedi.",mainPage.checkMainPage());
        mainPage.checkMainPage();
    }
    @Step("Kategoriler sayfası açılır")
    public void categoiesPageClick(){
        mainPage.clickCategoriesPage();
    }
    @Step("Kategoriler sayfası açıldığı doğrulanır.")
    public void checkCatPage(){
     categoriesPage.checkCategoriesPage();
     Assert.assertTrue("Kategoriler sayfası açılışında hata oluştu.",categoriesPage.checkCategoriesPage());
    }
    @Step("Kadın seçeneğine tıklanır")
    public void clickKadinElement(){
        categoriesPage.clickKadinCat();
    }
    @Step("Pantolon sekmesi seçilir")
    public void clickPant(){
        categoriesPage.clickPantCat();
    }
    @Step("Ekranı kaydır")
    public void swipeScreen(){
        productsPage.swipeScreen(1250,290);
        productsPage.swipeScreen(1250,250);
        productsPage.swipeScreen(1250,200);
        productsPage.swipeScreen(1250,150);
        productsPage.swipeScreen(1250,100);
    }

    @Step("Son ürünü favorilere ekle")
    public void addFav(){
        productsPage.clickLastFav();
    }
    @Step("Giriş yap sayfasının açıldıgı kontrol edilir")
    public void checkLoginPage(){
        Assert.assertTrue("Giriş yap sayfası açılamadı.",loginPage.checkLoginPage());
        loginPage.checkLoginPage();
    }
    @Step("Geri butonuna basılır")
    public void clickBackButton(){
        loginPage.clickBackButton();
    }
    @Step("ürünlerin yeniden listelendiği gözlemlenir")
    public void checkReturnPage(){
        Assert.assertTrue("ürünler yeniden gözlenemedi.",productsPage.checkProductsPage());
        productsPage.checkProductsPage();
    }
    @Step("Hesabım ikonuna tıklanır")
    public void clickLoginPage(){
        productsPage.clickLoginPage();
    }
    @Step("Sepetim sayfasına tıklanır")
    public void clickCartPage(){
        productsPage.clickCartPage();
    }
    @Step("<x> saniye kadar beklendi")
    public void waitForSecond(int x) throws InterruptedException {
        Thread.sleep(1000*x);
        System.out.println(x+ "saniye kadar beklendi");
    }
}
