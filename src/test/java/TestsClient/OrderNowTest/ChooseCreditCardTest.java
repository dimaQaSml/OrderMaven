package TestsClient.OrderNowTest;

import Client.MainScreenSidebarAddClass.MainScreenSidebarAddQuickOrderClass;
import Client.MainScreenSidebarClass.MainScreenClass;
import Client.MainScreenSidebarClass.MainScreenSidebarAddressClass;
import Client.MainScreenSidebarClass.MainScreenSidebarFavoriteOrderClass;
import Client.MainScreenSidebarClass.MainScreenSidebarPaymentsClass;
import Client.OrderNowClass.*;
import Client.Restaurant.RestaurantModalClass;
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
 * Created by dmitry on 11.08.16.
 */
public class ChooseCreditCardTest {

    AppiumDriver driver = null;
    WebDriver driverBrowser = null;
    DesiredCapabilities capabilities;
    SignInClass signInClass;
    MainScreenClass mainScreenClass;
    ChooseOrderClass chooseOrderClass;
    RestaurantModalClass restaurantModalClass;
    RestaurantScreenClass restaurantScreenClass;
    PaymentMethodClass paymentMethodClass;
    ChooseCreditCardClass chooseCreditCardClass;
    SummarySendClass summarySendClass;
    AddAddressClass addAddressClass;

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
            paymentMethodClass = PageFactory.initElements(driver, PaymentMethodClass.class);
            chooseCreditCardClass = PageFactory.initElements(driver, ChooseCreditCardClass.class);
            summarySendClass = PageFactory.initElements(driver, SummarySendClass.class);
            addAddressClass = PageFactory.initElements(driver, AddAddressClass.class);
        } else {
            signInClass = PageFactory.initElements(driverBrowser, SignInClass.class);
            mainScreenClass = PageFactory.initElements(driverBrowser, MainScreenClass.class);
            chooseOrderClass = PageFactory.initElements(driverBrowser, ChooseOrderClass.class);
            paymentMethodClass = PageFactory.initElements(driverBrowser, PaymentMethodClass.class);
            chooseCreditCardClass = PageFactory.initElements(driverBrowser, ChooseCreditCardClass.class);
            summarySendClass = PageFactory.initElements(driverBrowser, SummarySendClass.class);
            addAddressClass = PageFactory.initElements(driverBrowser, AddAddressClass.class);
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
        chooseOrderClass.getTypeNewOrder().sendKeys("test");
        chooseOrderClass.getSubmitButton().click();
        addAddressClass.chooseDevice();
        addAddressClass.getGetLocationButton().click();
        addAddressClass.getSubmitButton().click();
        paymentMethodClass.chooseDevice();
        paymentMethodClass.getCreditCardMethod().click();
        chooseCreditCardClass.chooseDevice();
    }

    @After
    public void after(){
        driver.close();
    }


    @Test
    public void testCase145() throws InterruptedException {
        boolean result = chooseCreditCardClass.testCase145();
        org.junit.Assert.assertTrue(result);
    }

    @Test
    public void testCase148() throws InterruptedException {
        boolean result = chooseCreditCardClass.testCase148();
        org.junit.Assert.assertTrue(result);
    }

    @Test
    public void testCase149() throws InterruptedException {
        boolean result = chooseCreditCardClass.testCase149();
        org.junit.Assert.assertTrue(result);
    }

}
