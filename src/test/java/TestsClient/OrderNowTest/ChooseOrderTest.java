package TestsClient.OrderNowTest;

import Client.MainScreenSidebarClass.MainScreenClass;
import Client.OrderNowClass.*;
import Client.Restaurant.RestaurantModalClass;
import Client.Restaurant.RestaurantQuickOrderClass;
import Client.Restaurant.RestaurantScreenClass;
import Client.SignInClass;
import GlobalMethods.GlobalMethods;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by dmitry on 05.08.16.
 */
public class ChooseOrderTest {

    AppiumDriver driver = null;
    WebDriver driverBrowser = null;
    DesiredCapabilities capabilities;
    SignInClass signInClass;
    MainScreenClass mainScreenClass;
    ChooseOrderClass chooseOrderClass;
    RestaurantModalClass restaurantModalClass;
    RestaurantScreenClass restaurantScreenClass;

    @Before
    public void before() throws InterruptedException, MalformedURLException {
        switch (GlobalMethods.chooseDevice()){
            case "web":
                driverBrowser = new FirefoxDriver();
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
            signInClass = PageFactory.initElements(driver, SignInClass.class);
            mainScreenClass = PageFactory.initElements(driver, MainScreenClass.class);
            chooseOrderClass = PageFactory.initElements(driver, ChooseOrderClass.class);
            restaurantModalClass = PageFactory.initElements(driver, RestaurantModalClass.class);
            restaurantScreenClass = PageFactory.initElements(driver, RestaurantScreenClass.class);
        } else {
            signInClass = PageFactory.initElements(driverBrowser, SignInClass.class);
            mainScreenClass = PageFactory.initElements(driverBrowser, MainScreenClass.class);
            chooseOrderClass = PageFactory.initElements(driverBrowser, ChooseOrderClass.class);
            restaurantModalClass = PageFactory.initElements(driverBrowser, RestaurantModalClass.class);
            restaurantScreenClass = PageFactory.initElements(driverBrowser, RestaurantScreenClass.class);
        }


        driver.get(GlobalMethods.getUrl());
        driver.manage().window().maximize();
        signInClass.chooseDevice();
        signInClass.signInClick(GlobalMethods.getPhone(), GlobalMethods.getPassword());
        mainScreenClass.chooseDevice();
        mainScreenClass.getRestaurantsScreen().click();
        restaurantScreenClass.chooseDevice();
        restaurantScreenClass.getNameRestaurant().get(0).click();
        restaurantModalClass.chooseDevice();
        restaurantModalClass.getOrderNowButton().click();
        chooseOrderClass.chooseDevice();
    }

    @After
    public void after(){
        driver.close();
    }


    @Test
    public void testCase117() throws InterruptedException {
        boolean result = chooseOrderClass.testCase117();
        org.junit.Assert.assertTrue(result);
    }

    @Test
    public void testCase118() throws InterruptedException {
        boolean result = chooseOrderClass.testCase118();
        org.junit.Assert.assertTrue(result);
    }

    @Test
    public void testCase120() throws InterruptedException {
        boolean result = chooseOrderClass.testCase120();
        org.junit.Assert.assertTrue(result);
    }

    @Test
    public void testCase121() throws InterruptedException {
        boolean result = chooseOrderClass.testCase121();
        org.junit.Assert.assertTrue(result);
    }

    @Test
    public void testCase122() throws InterruptedException {
        boolean result = chooseOrderClass.testCase122();
        org.junit.Assert.assertTrue(result);
    }

    @Test
    public void testCase123() throws InterruptedException {
        boolean result = chooseOrderClass.testCase123();
        org.junit.Assert.assertTrue(result);
    }

    @Test
    public void testCase124() throws InterruptedException {
        boolean result = chooseOrderClass.testCase124();
        org.junit.Assert.assertTrue(result);
    }

    @Test
    public void testCase125() throws InterruptedException {
        boolean result = chooseOrderClass.testCase125();
        org.junit.Assert.assertTrue(result);
    }

    @Test
    public void testCase129() throws InterruptedException {
        boolean result = chooseOrderClass.testCase129();
        org.junit.Assert.assertTrue(result);
    }

}
