package TestsClient.OrderNowTest;

import TestClass.Client.MainScreenSidebarClass.MainScreenClass;
import TestClass.Client.OrderNowClass.*;
import TestClass.Client.Restaurant.RestaurantModalClass;
import TestClass.Client.Restaurant.RestaurantScreenClass;
import TestClass.Client.SignInClass;
import TestClass.GlobalMethods.GlobalMethods;
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
 * Created by dmitry on 10.08.16.
 */
public class PaymentMethodTest {

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
                driverBrowser = GlobalMethods.web();
                break;
            case "ios":
                GlobalMethods.ios(capabilities, driver);
                break;
            case "android":
                GlobalMethods.android(capabilities, driver);
                break;
        }
        if(driverBrowser != null) {
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
            driverBrowser.get(GlobalMethods.getUrl());
            driverBrowser.manage().window().maximize();
        }

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
    }

    @After
    public void after(){
        driverBrowser.quit();
    }

    @Test
    public void testCase131() throws InterruptedException {
        boolean result = paymentMethodClass.testCase131();
        org.junit.Assert.assertTrue(result);
    }

    @Test
    public void testCase132() throws InterruptedException {
        boolean result = paymentMethodClass.testCase132();
        org.junit.Assert.assertTrue(result);
    }

    @Test
    public void testCase133() throws InterruptedException {
        boolean result = paymentMethodClass.testCase133();
        org.junit.Assert.assertTrue(result);
    }

}
