package TestsClient.MainScreenSidebarAddTest;

import Client.*;
import Client.ForgotPasswordClass;
import Client.MainScreenSidebarAddClass.MainScreenSidebarAddAddressClass;
import Client.MainScreenSidebarClass.MainScreenClass;
import Client.MainScreenSidebarClass.MainScreenSidebarAddressClass;
import Client.SignInClass;
import GlobalMethods.GlobalMethods;
import Restaurant.*;
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
import java.util.List;

/**
 * Created by dmitry on 06.06.16.
 */
public class MainScreenSidebarAddAddressTest {

    AppiumDriver driver = null;
    WebDriver driverBrowser = null;
    DesiredCapabilities capabilities;
    SignInClass signInClass;
    MainScreenClass mainScreenClass;
    MainScreenSidebarAddressClass mainScreenSidebarAddressClass;
    MainScreenSidebarAddAddressClass mainScreenSidebarAddAddressClass;

    @Before
    public void before() throws InterruptedException, MalformedURLException {
        switch (GlobalMethods.chooseDevice()){
            case "web":
                driverBrowser = new FirefoxDriver();
                driverBrowser.get(GlobalMethods.getUrl());
                break;
            case "ios":
                capabilities = new DesiredCapabilities();
                capabilities.setCapability("app ium-version", "1.0");
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
            mainScreenSidebarAddressClass = PageFactory.initElements(driver, MainScreenSidebarAddressClass.class);
            mainScreenSidebarAddAddressClass = PageFactory.initElements(driver, MainScreenSidebarAddAddressClass.class);
        } else {
            signInClass = PageFactory.initElements(driverBrowser, SignInClass.class);
            mainScreenClass = PageFactory.initElements(driverBrowser, MainScreenClass.class);
            mainScreenSidebarAddressClass = PageFactory.initElements(driverBrowser, MainScreenSidebarAddressClass.class);
            mainScreenSidebarAddAddressClass = PageFactory.initElements(driverBrowser, MainScreenSidebarAddAddressClass.class);
        }


        driver.get(GlobalMethods.getUrl());
        driver.manage().window().maximize();
        signInClass.chooseDevice();
        signInClass.signInClick("+79280373736","123456");
        mainScreenClass.chooseDevice();
        mainScreenClass.getAddressSection().click();
        mainScreenSidebarAddressClass.chooseDevice();
    }

    /*@After
    public void after(){
        driver.close();
    }*/


    @Ignore
    @Test
    public void testCase39() throws InterruptedException {
        List<WebElement> before = mainScreenSidebarAddressClass.countAddressElementsBefore();
        mainScreenSidebarAddressClass.addAddressButtonClick();
        mainScreenSidebarAddAddressClass.chooseDevice();
        mainScreenSidebarAddAddressClass.addAddress(GlobalMethods.getCity(), GlobalMethods.getAddress(), GlobalMethods.getHome());
        boolean result = mainScreenSidebarAddressClass.checkAddAddress(before);
        Assert.assertTrue("Error!", result);
    }

    @Ignore
    @Test
    public void testCase40() throws InterruptedException {
        mainScreenSidebarAddressClass.addAddressButtonClick();
        boolean result = GlobalMethods.validationAddAddress(mainScreenSidebarAddAddressClass, GlobalMethods.getCity(), GlobalMethods.getAddress(), GlobalMethods.getHome());
        Assert.assertTrue("Error!", result);
    }

    @Ignore
    @Test
    public void testCase41() throws InterruptedException {
        mainScreenSidebarAddressClass.addAddressButtonClick();
        mainScreenSidebarAddAddressClass.chooseDevice();
        mainScreenSidebarAddAddressClass.cancelClick();
        /*try {
            mainScreenSidebarAddressClass.chooseDevice();
        } catch(){
            Assert.fail("Error!");
        }*/
        Assert.assertTrue(true);
    }

    @Ignore
    @Test
    public void testCase42() throws InterruptedException {
        mainScreenSidebarAddressClass.addAddressButtonClick();
        mainScreenSidebarAddAddressClass.chooseDevice();
        mainScreenSidebarAddAddressClass.getGetLocationButton().click();
        boolean result = mainScreenSidebarAddAddressClass.getLocation();
        Assert.assertTrue("Error!", result);
    }



}
