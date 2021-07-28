package Base;

import com.thoughtworks.gauge.AfterScenario;
import com.thoughtworks.gauge.BeforeScenario;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import log.Log;
import org.aspectj.weaver.ast.And;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.FluentWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    protected static AppiumDriver<MobileElement> appiumDriver;
    protected static FluentWait<AppiumDriver<MobileElement>> appiumDriverFluentWait;
    Log log =new Log();
    @BeforeScenario
    public void setUp() throws MalformedURLException {

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "52005052ead36527");
        desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,
                "com.ozdilek.ozdilekteyim");
        desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,
                "com.ozdilek.ozdilekteyim.MainActivity");
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
        desiredCapabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 6000);
        desiredCapabilities.setCapability("platformVersion", "10");
        desiredCapabilities.setCapability("autoGrantPermissions",true);

        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        appiumDriver = new AndroidDriver(url,desiredCapabilities);

        appiumDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        appiumDriverFluentWait = new FluentWait<AppiumDriver<MobileElement>>(appiumDriver);
        appiumDriverFluentWait.withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(450))
                .ignoring(NoSuchElementException.class);

    }
    @AfterScenario
    public void tearDown(){
        if (appiumDriver!=null){
            log.info("!!UYGULAMA KAPATILDI!! ");
            appiumDriver.quit();
        }
    }
}
