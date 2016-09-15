package TestsRestaurant;

import GlobalMethods.GlobalMethods;
import Restaurant.ForgotPasswordClass;
import Restaurant.MainScreenMyRestaurant;
import Restaurant.SignInClass;
import Restaurant.SignUpClass.SignUpStep1Class;
import Restaurant.StartPageClassMobile;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import junit.framework.Assert;
import org.json.JSONException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by dmitry on 04.07.16.
 */
public class MainScreenMyRestaurantTest {

    AppiumDriver driver = null;
    WebDriver driverBrowser = null;
    DesiredCapabilities capabilities;
    MainScreenMyRestaurant mainScreenMyRestaurant;
    FirefoxProfile firefoxProfile;

    @Before
    public void before() throws MalformedURLException, InterruptedException {

        switch (GlobalMethods.chooseDevice()){
            case "web":
                ProfilesIni profile = new ProfilesIni();
                firefoxProfile = profile.getProfile("QA");
                driverBrowser = new FirefoxDriver(firefoxProfile);
                driverBrowser.get(GlobalMethods.getUrl());
                break;
            case "ios":
                capabilities = new DesiredCapabilities();
                capabilities.setCapability("appium-version", "1.0");
                capabilities.setCapability("platformName", "iOS");
                capabilities.setCapability("platformVersion", "9.2");
                capabilities.setCapability("deviceName", "iPhone 5s");
                capabilities.setCapability("app", "/Users/dmitry/Downloads/OrderAppManager-6.ipa");
                driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
                break;
            case "android":
                capabilities = new DesiredCapabilities();
                capabilities.setCapability("appium-version", "1.0");
                capabilities.setCapability("platformName", "Android");
                capabilities.setCapability("platformVersion", "4.4");
                capabilities.setCapability("deviceName", "rtyuetrrtyurtuyftytykufuykfkuyfuyvgylughiulhuiftyehsesgrrt");
                capabilities.setCapability("app", "/Users/dmitry/Downloads/app-stage-release-1.apk");
                capabilities.setCapability("appPackage", "ps.orderapp.rest");
                capabilities.setCapability("appActivity", "ps.orderapp.rest.views.welcome.WelcomeActivity");
                driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
                break;
        }
        if(driver != null) {
            mainScreenMyRestaurant = PageFactory.initElements(driver, MainScreenMyRestaurant.class);
        } else {
            mainScreenMyRestaurant = PageFactory.initElements(driverBrowser, MainScreenMyRestaurant.class);
        }
        driver.get(GlobalMethods.getUrl());
        driver.manage().window().maximize();

    }

    @After
    public void after() throws InterruptedException {
        Thread.sleep(1000);
        driver.close();
    }

    @Test
    public void testCase70() throws InterruptedException, IOException, JSONException {
        boolean result = mainScreenMyRestaurant.testCase70();
        Assert.assertTrue("Data is not correct!",result);
    }

    @Test
    public void testCase71() throws InterruptedException, IOException, JSONException {
        boolean result = mainScreenMyRestaurant.testCase71();
        Assert.assertTrue("Data is not correct!",result);
    }

/*    @Test
    public void qwe() throws InterruptedException, IOException, JSONException {
        mainScreenMyRestaurant.getResponceRestaurantData();
        Assert.assertTrue("Email validation not correct!",true);
    }*/

}
