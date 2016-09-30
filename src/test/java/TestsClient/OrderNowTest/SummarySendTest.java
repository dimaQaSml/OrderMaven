package TestsClient.OrderNowTest;

import Client.MainScreenSidebarAddClass.MainScreenSidebarAddOrderClass;
import Client.MainScreenSidebarAddClass.MainScreenSidebarAddQuickOrderClass;
import Client.MainScreenSidebarClass.MainScreenClass;
import Client.MainScreenSidebarClass.MainScreenSidebarFavoriteOrderClass;
import Client.MainScreenSidebarDeleteClass.MainScreenSidebarFavoriteOrderDeleteClass;
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
public class SummarySendTest {

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
                GlobalMethods.web(driverBrowser);
                break;
            case "ios":
                GlobalMethods.ios(capabilities, driver);
                break;
            case "android":
                GlobalMethods.android(capabilities, driver);
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
        paymentMethodClass.getCashMethod().click();
        summarySendClass.chooseDevice();
    }

    @After
    public void after(){
        driver.close();
    }


    @Test
    public void testCase136() throws InterruptedException {
        boolean result = summarySendClass.testCase136();
        org.junit.Assert.assertTrue(result);
    }

    @Test
    public void testCase137() throws InterruptedException {
        boolean result = summarySendClass.testCase137();
        org.junit.Assert.assertTrue(result);
    }

    @Test
    public void testCase138() throws InterruptedException {
        boolean result = summarySendClass.testCase138();
        org.junit.Assert.assertTrue(result);
    }




}
