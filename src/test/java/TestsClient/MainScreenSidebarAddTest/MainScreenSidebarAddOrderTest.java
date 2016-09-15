package TestsClient.MainScreenSidebarAddTest;

import Client.*;
import Client.MainScreenSidebarAddClass.MainScreenSidebarAddAddressClass;
import Client.MainScreenSidebarAddClass.MainScreenSidebarAddOrderClass;
import Client.MainScreenSidebarClass.MainScreenSidebarFavoriteOrderClass;
import Client.MainScreenSidebarDeleteClass.MainScreenSidebarFavoriteOrderDeleteClass;
import GlobalMethods.GlobalMethods;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import junit.framework.Assert;
import org.junit.After;
import org.openqa.selenium.WebElement;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

/**
 * Created by dmitry on 03.06.16.
 */
public class MainScreenSidebarAddOrderTest {

    AppiumDriver driver = null;
    WebDriver driverBrowser = null;
    DesiredCapabilities capabilities;
    SignInClass signInClass;
    MainScreenSidebarFavoriteOrderClass mainScreenSidebarFavoriteOrderClass;
    MainScreenSidebarAddOrderClass mainScreenSidebarAddOrderClass;
    MainScreenSidebarFavoriteOrderDeleteClass mainScreenSidebarFavoriteOrderDeleteClass;

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
            mainScreenSidebarFavoriteOrderClass = PageFactory.initElements(driver, MainScreenSidebarFavoriteOrderClass.class);
            mainScreenSidebarAddOrderClass = PageFactory.initElements(driver, MainScreenSidebarAddOrderClass.class);
            mainScreenSidebarFavoriteOrderDeleteClass = PageFactory.initElements(driver, MainScreenSidebarFavoriteOrderDeleteClass.class);
        } else {
            signInClass = PageFactory.initElements(driver, SignInClass.class);
            mainScreenSidebarFavoriteOrderClass = PageFactory.initElements(driverBrowser, MainScreenSidebarFavoriteOrderClass.class);
            mainScreenSidebarAddOrderClass = PageFactory.initElements(driverBrowser, MainScreenSidebarAddOrderClass.class);
            mainScreenSidebarFavoriteOrderDeleteClass = PageFactory.initElements(driverBrowser, MainScreenSidebarFavoriteOrderDeleteClass.class);
        }


        driver.get(GlobalMethods.getUrl());
        driver.manage().window().maximize();
        signInClass.chooseDevice();
        signInClass.signInClick("+79280373736","123456");
        mainScreenSidebarFavoriteOrderClass.chooseDevice();
    }

    @After
    public void after(){
        driver.close();
    }

    //@Ignore
    @Test
    public void testCase23() throws InterruptedException {
        List<WebElement> before = mainScreenSidebarFavoriteOrderClass.countOrdersElementsBefore();
        mainScreenSidebarFavoriteOrderClass.addOrderButtonClick();
        mainScreenSidebarAddOrderClass.chooseDevice();
        mainScreenSidebarAddOrderClass.addOrder(GlobalMethods.getRestaurant(),GlobalMethods.getOrder());
        mainScreenSidebarFavoriteOrderClass.chooseDevice();
        boolean result = mainScreenSidebarFavoriteOrderClass.checkAddOrder(before);
        if(result){
            mainScreenSidebarFavoriteOrderClass.deleteOrder(before);
        }
        Assert.assertTrue("Error!", result);
    }

    //@Ignore
    @Test
    public void testCase24() throws InterruptedException {
        mainScreenSidebarFavoriteOrderClass.addOrderButtonClick();
        mainScreenSidebarAddOrderClass.chooseDevice();
        boolean result = mainScreenSidebarAddOrderClass.restaurantValidation();
        Assert.assertTrue("Error!",result);
    }

    //@Ignore
    @Test
    public void testCase25() throws InterruptedException {
        mainScreenSidebarFavoriteOrderClass.addOrderButtonClick();
        mainScreenSidebarAddOrderClass.chooseDevice();
        boolean result = GlobalMethods.validationAddOrder(mainScreenSidebarAddOrderClass, GlobalMethods.getRestaurant(),GlobalMethods.getOrder(),"testDescription");
        Assert.assertTrue("Error!",result);
    }

    //@Ignore
    @Test
    public void testCase26() throws InterruptedException {
        mainScreenSidebarFavoriteOrderClass.addOrderButtonClick();
        mainScreenSidebarAddOrderClass.chooseDevice();
        mainScreenSidebarAddOrderClass.cancelClick();
        mainScreenSidebarFavoriteOrderClass.chooseDevice();
        Assert.assertTrue("Error!", driver.getCurrentUrl().equals(GlobalMethods.getUrl() + "/"));
    }

    //@Ignore
    @Test
    public void testCase31() throws InterruptedException {
        List<WebElement> before = mainScreenSidebarFavoriteOrderClass.countOrdersElementsBefore();
        mainScreenSidebarFavoriteOrderClass.addOrderButtonClick();
        mainScreenSidebarAddOrderClass.chooseDevice();
        //mainScreenSidebarAddOrderClass.addOrder(GlobalMethods.getRestaurant(),GlobalMethods.getOrder());
        mainScreenSidebarAddOrderClass.addOrder("test","test");
        mainScreenSidebarFavoriteOrderClass.chooseDevice();
        boolean result = mainScreenSidebarFavoriteOrderClass.checkAddOrder(before);
        if(result) {
            mainScreenSidebarFavoriteOrderClass.getEditOrderButton().get(before.size()).click();
            mainScreenSidebarAddOrderClass.chooseDevice();
            System.out.println(mainScreenSidebarAddOrderClass.getRestaurantName().getAttribute("value") + " " + mainScreenSidebarAddOrderClass.getOrderName().getAttribute("value"));
            if (mainScreenSidebarAddOrderClass.getRestaurantName().getAttribute("value").equals(GlobalMethods.getRestaurant()) && mainScreenSidebarAddOrderClass.getOrderName().getAttribute("value").equals(GlobalMethods.getOrder())) {
                mainScreenSidebarFavoriteOrderClass.deleteOrder(before);
                Assert.assertTrue(true);
            } else {
                mainScreenSidebarFavoriteOrderClass.deleteOrder(before);
                Assert.fail("Error!");
            }
        } else{
            Assert.fail("Order is not created!");
        }
    }

    //@Ignore
    @Test
    public void testCase32() throws InterruptedException {
        List<WebElement> before = mainScreenSidebarFavoriteOrderClass.countOrdersElementsBefore();
        mainScreenSidebarFavoriteOrderClass.addOrderButtonClick();
        mainScreenSidebarAddOrderClass.chooseDevice();
        mainScreenSidebarAddOrderClass.addOrder(GlobalMethods.getRestaurant(),GlobalMethods.getOrder());
        mainScreenSidebarFavoriteOrderClass.chooseDevice();
        boolean result = mainScreenSidebarFavoriteOrderClass.checkAddOrder(before);
        if(result) {
            mainScreenSidebarFavoriteOrderClass.getAddQuickOrderButton().get(before.size()).click();
            mainScreenSidebarAddOrderClass.chooseDevice();
            mainScreenSidebarAddOrderClass.addOrder("TestRestaurant", "TestOrder");
            mainScreenSidebarFavoriteOrderClass.chooseDevice();
            mainScreenSidebarFavoriteOrderClass.getAddQuickOrderButton().get(before.size()).click();
            if (mainScreenSidebarAddOrderClass.getRestaurantName().equals("TestRestaurant") && mainScreenSidebarAddOrderClass.getOrderName().equals("TestOrder")) {
                mainScreenSidebarFavoriteOrderClass.deleteOrder(before);
                Assert.assertTrue(true);
            } else {
                mainScreenSidebarFavoriteOrderClass.deleteOrder(before);
                Assert.fail("Error!");
            }
        } else{
            Assert.fail("Order is not created!");
        }
    }

    @Ignore
    @Test
    public void testCase34() throws InterruptedException {
        mainScreenSidebarFavoriteOrderClass.getEditOrderButton().get(0).click();
        mainScreenSidebarAddOrderClass.chooseDevice();
        mainScreenSidebarAddOrderClass.getCancelButton().click();
        try {
            mainScreenSidebarFavoriteOrderClass.chooseDevice();
        } catch (org.openqa.selenium.TimeoutException e){
            org.junit.Assert.fail();
        }
        Assert.assertTrue(true);
    }


}

