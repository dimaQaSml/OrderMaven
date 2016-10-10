package TestsClient.MainScreenSidebarAddTest;

import TestClass.Client.AuthorizationClass;
import TestClass.Client.MainScreenSidebarAddClass.MainScreenSidebarAddOrderClass;
import TestClass.Client.MainScreenSidebarClass.MainScreenSidebarFavoriteOrderClass;
import TestClass.Client.MainScreenSidebarDeleteClass.MainScreenSidebarFavoriteOrderDeleteClass;
import TestClass.Client.SignInClass;
import TestClass.GlobalMethods.GlobalMethods;
import TestClass.GlobalMethods.ValidationClass;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import junit.framework.Assert;
import org.junit.After;
import org.openqa.selenium.By;
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
    AuthorizationClass authorizationClass;

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
            signInClass = PageFactory.initElements(driverBrowser, SignInClass.class);
            mainScreenSidebarFavoriteOrderClass = PageFactory.initElements(driverBrowser, MainScreenSidebarFavoriteOrderClass.class);
            mainScreenSidebarAddOrderClass = PageFactory.initElements(driverBrowser, MainScreenSidebarAddOrderClass.class);
            mainScreenSidebarFavoriteOrderDeleteClass = PageFactory.initElements(driverBrowser, MainScreenSidebarFavoriteOrderDeleteClass.class);
            authorizationClass = PageFactory.initElements(driverBrowser, AuthorizationClass.class);
            driverBrowser.manage().window().maximize();

        } else {
            signInClass = PageFactory.initElements(driver, SignInClass.class);
            mainScreenSidebarFavoriteOrderClass = PageFactory.initElements(driver, MainScreenSidebarFavoriteOrderClass.class);
            mainScreenSidebarAddOrderClass = PageFactory.initElements(driver, MainScreenSidebarAddOrderClass.class);
            mainScreenSidebarFavoriteOrderDeleteClass = PageFactory.initElements(driver, MainScreenSidebarFavoriteOrderDeleteClass.class);

        }
        authorizationClass.chooseDevice();
        authorizationClass.getSignInButton().click();
        signInClass.chooseDevice();
        signInClass.signInClick(GlobalMethods.getRealPhone(), GlobalMethods.getPassword());
        mainScreenSidebarFavoriteOrderClass.chooseDevice();
    }

    /*@After
    public void after(){
        driverBrowser.quit();
    }*/

    @Ignore
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

    //TODO уточнить работу списка
    @Ignore
    @Test
    public void testCase24() throws InterruptedException {
        mainScreenSidebarFavoriteOrderClass.addOrderButtonClick();
        mainScreenSidebarAddOrderClass.chooseDevice();
        boolean result = mainScreenSidebarAddOrderClass.restaurantValidation(mainScreenSidebarAddOrderClass);
        Assert.assertTrue("Error!",result);
    }

    @Ignore
    @Test
    public void testCase25() throws InterruptedException {
        mainScreenSidebarFavoriteOrderClass.addOrderButtonClick();
        mainScreenSidebarAddOrderClass.chooseDevice();
        boolean result = ValidationClass.validationAddOrder(mainScreenSidebarAddOrderClass, GlobalMethods.getRestaurant(),GlobalMethods.getOrder());
        Assert.assertTrue("Error!",result);
    }

    @Ignore
    @Test
    public void testCase26() throws InterruptedException {
        mainScreenSidebarFavoriteOrderClass.addOrderButtonClick();
        mainScreenSidebarAddOrderClass.chooseDevice();
        mainScreenSidebarAddOrderClass.cancelClick();
        Thread.sleep(1000);
        try {
            if (mainScreenSidebarAddOrderClass.getSubmitButton().isDisplayed()) {
                org.junit.Assert.fail("Error1!");
            }
        } catch (org.openqa.selenium.StaleElementReferenceException e){
            org.junit.Assert.assertTrue(true);
        }

    }

    @Ignore
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
            mainScreenSidebarFavoriteOrderClass.setEditOrderButton(driverBrowser.findElements(By.xpath(".//*[@id='Container']/div[2]/div/div[3]/div[2]/div/div[2]/img[2]")));
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

    //TODO не работает добавление карты - тест не пройдет
    @Ignore
    @Test
    public void testCase32() throws InterruptedException {
        List<WebElement> before = mainScreenSidebarFavoriteOrderClass.countOrdersElementsBefore();
        mainScreenSidebarFavoriteOrderClass.addOrderButtonClick();
        mainScreenSidebarAddOrderClass.chooseDevice();
        mainScreenSidebarAddOrderClass.addOrder(GlobalMethods.getRestaurant(),GlobalMethods.getOrder());
        mainScreenSidebarFavoriteOrderClass.chooseDevice();
        boolean result = mainScreenSidebarFavoriteOrderClass.checkAddOrder(before);
        if(result) {
            mainScreenSidebarFavoriteOrderClass.setEditOrderButton(driverBrowser.findElements(By.xpath(".//*[@id='Container']/div[2]/div/div[3]/div[2]/div/div[2]/img[2]")));
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

    //@Ignore
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

