package core;

import cucumber.api.Scenario;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSStartScreenRecordingOptions;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.ConfigProperties;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static util.RecordingScreen.gerarRecordingScreen;
import static util.ScreenShot.gerarScreenShot;

public class DriverFactory extends AbstractTestNGCucumberTests {
    public static ThreadLocal<Scenario> testScenario = new ThreadLocal<>();
    public static AppiumDriver<MobileElement> driver;
    public static WebDriverWait wait;

    public static AppiumDriver<?> getDriver() {
        if(driver == null) {
            try {
                setUpAppium();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
        return driver;
    }

    private static void setUpAppium() throws MalformedURLException {

        ConfigProperties properties = ConfigProperties.getInstance();
        String environment = properties.getEnvironment();

        final String URL_STRING = "http://127.0.0.1:4723/wd/hub";
        URL url = new URL(URL_STRING);
        DesiredCapabilities capabilities = new DesiredCapabilities();
        switch (environment) {
            case "android":
                capabilities.setCapability("deviceName", "Pixel_XL_API_30");
                capabilities.setCapability("platformName", "Android");
                capabilities.setCapability("appWaitPackage", "com.ifood.testqa");
                capabilities.setCapability("appWaitActivity", "host.exp.exponent.MainActivity");
                capabilities.setCapability("adbExecTimeout", "80000");
                capabilities.setCapability("disableWindowAnimation", true);
                capabilities.setCapability(AndroidMobileCapabilityType.RESET_KEYBOARD, true); // Necessario add porque o teclado estava bloqueando a visializacao do campo
                File objFile = new File("apk/ifood-test.apk");
                capabilities.setCapability("app", objFile.getAbsolutePath());

                driver = new AndroidDriver<MobileElement>(url, capabilities);


                wait = new WebDriverWait(driver, 10);
                driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);


                ((AndroidDriver) driver).startRecordingScreen();
                break;

            case "ios":
                capabilities.setCapability("platformName", "iOS");

                //emulator
                capabilities.setCapability("deviceName", "iPhone 11 Pro Max");
                capabilities.setCapability("udid", "CEFAEA45-6D4E-447E-93B5-AF98980AA7C9");
                capabilities.setCapability("platformVersion", "13.6");
                capabilities.setCapability("app", "com.ifood.qa.app");
                capabilities.setCapability("automationName", "XCUITest");
                File objFile2 = new File("/Users/leandro/Documents/Estudos/prova/teste/apk/ifood-test.app");
                capabilities.setCapability("app", objFile2.getAbsolutePath());


                driver = new IOSDriver<MobileElement>(url, capabilities);
                wait = new WebDriverWait(driver, 10);
                driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

                ((IOSDriver) driver).startRecordingScreen(new IOSStartScreenRecordingOptions().withVideoType("h264"));
                break;
        }
    }

    public static void killDriver() throws IOException {
        if(driver != null) {
            gerarScreenShot();
            gerarRecordingScreen();
            driver.quit();
            driver = null;
        }
    }
}