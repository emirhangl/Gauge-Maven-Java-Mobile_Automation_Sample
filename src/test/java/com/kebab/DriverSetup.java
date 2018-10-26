package com.kebab;

import com.thoughtworks.gauge.AfterSuite;
import com.thoughtworks.gauge.BeforeSuite;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.net.URL;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class DriverSetup {
    protected AppiumDriver<MobileElement> driver;
    public static WebDriverWait wait;


    @BeforeSuite
    public void setup() throws IOException {
//        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
//        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "ASUS_Z00AD");
//        capabilities.setCapability("platformName", "Android");
//        capabilities.setCapability("udid", "192.168.0.35:4000");
//        capabilities.setCapability("appPackage", "com.pozitron.hepsiburada");
//        capabilities.setCapability("appActivity", "com.hepsiburada.ui.startup.SplashActivity");
//        capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
//        capabilities.setCapability(MobileCapabilityType.FULL_RESET, false);
//        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
//
//        // driver = (AndroidDriver<MobileElement>) new RemoteWebDriver( new URL("http://192.168.60.134:4444/wd/hub"), capabilities);
//        driver = new  AndroidDriver<MobileElement> (new URL("http://0.0.0.0:5000/wd/hub"), capabilities);

        //EMULATOR
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Nexus 6 API 27");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("udid", "emulator-5554");
        capabilities.setCapability("appPackage", "com.pozitron.hepsiburada");
        capabilities.setCapability("appActivity", "com.hepsiburada.ui.startup.SplashActivity");
        capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
        capabilities.setCapability(MobileCapabilityType.FULL_RESET, false);
        capabilities.setCapability("noReset", false);
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");

        driver = new  AndroidDriver<MobileElement> (new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver,10);

    }

    @AfterSuite
    public void tearDown() {
        if(driver != null) {
            driver.quit();
        }
    }
}
