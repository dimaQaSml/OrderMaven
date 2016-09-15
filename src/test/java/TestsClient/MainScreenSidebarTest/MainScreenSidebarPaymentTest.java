package TestsClient.MainScreenSidebarTest;

import Client.*;
import Client.MainScreenSidebarAddClass.MainScreenSidebarAddAddressClass;
import Client.MainScreenSidebarAddClass.MainScreenSidebarAddOrderClass;
import Client.MainScreenSidebarAddClass.MainScreenSidebarAddPaymentsClass;
import Client.MainScreenSidebarAddClass.MainScreenSidebarAddQuickOrderClass;
import Client.MainScreenSidebarClass.MainScreenClass;
import Client.MainScreenSidebarClass.MainScreenSidebarAddressClass;
import Client.MainScreenSidebarClass.MainScreenSidebarFavoriteOrderClass;
import Client.MainScreenSidebarClass.MainScreenSidebarPaymentsClass;
import Client.MainScreenSidebarDeleteClass.MainScreenSidebarAddressDeleteClass;
import Client.MainScreenSidebarDeleteClass.MainScreenSidebarFavoriteOrderDeleteClass;
import Client.MainScreenSidebarDeleteClass.MainScreenSidebarPaymentsDeleteClass;
import GlobalMethods.GlobalMethods;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dmitry on 07.06.16.
 */
public class MainScreenSidebarPaymentTest {

    AppiumDriver driver = null;
    WebDriver driverBrowser = null;
    DesiredCapabilities capabilities;
    SignInClass signInClass;
    MainScreenClass mainScreenClass;
    MainScreenSidebarPaymentsClass mainScreenSidebarPaymentsClass;
    MainScreenSidebarAddPaymentsClass mainScreenSidebarAddPaymentsClass;
    MainScreenSidebarPaymentsDeleteClass mainScreenSidebarPaymentsDeleteClass;
    List<WebElement> before;

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
            mainScreenSidebarPaymentsClass = PageFactory.initElements(driver, MainScreenSidebarPaymentsClass.class);
            mainScreenSidebarAddPaymentsClass = PageFactory.initElements(driver, MainScreenSidebarAddPaymentsClass.class);
            mainScreenSidebarPaymentsDeleteClass = PageFactory.initElements(driver, MainScreenSidebarPaymentsDeleteClass.class);

        } else {
            signInClass = PageFactory.initElements(driverBrowser, SignInClass.class);
            mainScreenClass = PageFactory.initElements(driverBrowser, MainScreenClass.class);
            mainScreenSidebarPaymentsClass = PageFactory.initElements(driverBrowser, MainScreenSidebarPaymentsClass.class);
            mainScreenSidebarAddPaymentsClass = PageFactory.initElements(driverBrowser, MainScreenSidebarAddPaymentsClass.class);
            mainScreenSidebarPaymentsDeleteClass = PageFactory.initElements(driverBrowser, MainScreenSidebarPaymentsDeleteClass.class);
        }
        before = new ArrayList<>();
        driver.get(GlobalMethods.getUrl());
        driver.manage().window().maximize();
        signInClass.chooseDevice();
        signInClass.signInClick("+79280373736","123456");
        mainScreenClass.chooseDevice();
        mainScreenClass.getPaymentSection().click();
        mainScreenSidebarPaymentsClass.chooseDevice();
        before = mainScreenSidebarPaymentsClass.countPaymentsElementsBefore();
    }

    /*@After
    public void after(){
        driver.close();
    }*/


    @Ignore
    @Test
    public void testCase57() throws InterruptedException {
        mainScreenSidebarPaymentsClass.getDeleteCardButton().get(0).click();
        mainScreenSidebarPaymentsDeleteClass.chooseDevice();
        mainScreenSidebarPaymentsDeleteClass.deleteNoClick();
        /*try{
            mainScreenSidebarPaymentsClass.chooseDevice();
            boolean result = mainScreenSidebarPaymentsClass.checkDeletePayment()
        } catch(){
            Assert.fail("Error!");
        }
        Assert.assertFalse("Error!", result);*/
    }

    @Ignore
    @Test
    public void testCase58() throws InterruptedException {
        mainScreenSidebarPaymentsClass.getDeleteCardButton().get(0).click();
        mainScreenSidebarPaymentsDeleteClass.chooseDevice();
        mainScreenSidebarPaymentsDeleteClass.deleteYesClick();
        boolean result = mainScreenSidebarPaymentsClass.checkDeletePayment(before);
        Assert.assertTrue("Error!",result);
    }


    @Ignore
    @Test
    public void testCase59() throws InterruptedException {
        mainScreenSidebarPaymentsClass.addPaymentButtonClick();
        mainScreenSidebarAddPaymentsClass.chooseDevice();
        mainScreenSidebarAddPaymentsClass.addPayment(GlobalMethods.getNumberCard1(), GlobalMethods.getNumberCard2(), GlobalMethods.getDateCardMonth(), GlobalMethods.getDateCardYear(), GlobalMethods.getCvvCard());
        mainScreenSidebarPaymentsClass.chooseDevice();
        //TODO
        /*if(mainScreenSidebarAddressClass.getRestaurantName().equals("TestRestaurant") && mainScreenSidebarAddressClass.getOrderName().equals("TestOrder") && mainScreenSidebarAddressClass.getDescription().equals("TestDescription2")) {
            Assert.assertTrue(true);
        } else {
            Assert.fail("Error!");
        }*/
    }

}
