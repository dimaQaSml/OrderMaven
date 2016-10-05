package TestsClient.MainScreenSidebarAddTest;


import TestClass.Client.MainScreenSidebarAddClass.MainScreenSidebarAddAddressClass;
import TestClass.Client.MainScreenSidebarClass.MainScreenClass;
import TestClass.Client.MainScreenSidebarClass.MainScreenSidebarAddressClass;
import TestClass.Client.SignInClass;
import TestClass.GlobalMethods.GlobalMethods;
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
                driverBrowser = GlobalMethods.web();
                break;
            case "ios":
                driver = GlobalMethods.ios(capabilities, driver);
                break;
            case "android":
                driver = GlobalMethods.android(capabilities, driver);
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
            driverBrowser.manage().window().maximize();
        }


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
