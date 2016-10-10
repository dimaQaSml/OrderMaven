package TestsClient.MainScreenSidebarTest;


import TestClass.Client.MainScreenSidebarAddClass.MainScreenSidebarAddAddressClass;
import TestClass.Client.MainScreenSidebarClass.MainScreenClass;
import TestClass.Client.MainScreenSidebarClass.MainScreenSidebarAddressClass;
import TestClass.Client.MainScreenSidebarDeleteClass.MainScreenSidebarAddressDeleteClass;
import TestClass.Client.SignInClass;
import TestClass.GlobalMethods.GlobalMethods;
import TestClass.GlobalMethods.ValidationClass;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import junit.framework.Assert;
import org.junit.After;
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
public class MainScreenSidebarAddressTest {

    AppiumDriver driver = null;
    WebDriver driverBrowser = null;
    DesiredCapabilities capabilities;
    SignInClass signInClass;
    MainScreenClass mainScreenClass;
    MainScreenSidebarAddressClass mainScreenSidebarAddressClass;
    MainScreenSidebarAddAddressClass mainScreenSidebarAddAddressClass;
    MainScreenSidebarAddressDeleteClass mainScreenSidebarAddressDeleteClass;
    List<WebElement> before;

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
            mainScreenSidebarAddressClass = PageFactory.initElements(driver, MainScreenSidebarAddressClass.class);
            mainScreenSidebarAddAddressClass = PageFactory.initElements(driver, MainScreenSidebarAddAddressClass.class);
            mainScreenSidebarAddressDeleteClass = PageFactory.initElements(driver, MainScreenSidebarAddressDeleteClass.class);


        } else {
            signInClass = PageFactory.initElements(driverBrowser, SignInClass.class);
            mainScreenClass = PageFactory.initElements(driverBrowser, MainScreenClass.class);
            mainScreenSidebarAddressClass = PageFactory.initElements(driverBrowser, MainScreenSidebarAddressClass.class);
            mainScreenSidebarAddAddressClass = PageFactory.initElements(driverBrowser, MainScreenSidebarAddAddressClass.class);
            mainScreenSidebarAddressDeleteClass = PageFactory.initElements(driverBrowser, MainScreenSidebarAddressDeleteClass.class);
            driverBrowser.get(GlobalMethods.getUrl());
            driverBrowser.manage().window().maximize();
        }



        signInClass.chooseDevice();
        signInClass.signInClick(GlobalMethods.getRealPhone(), GlobalMethods.getPassword());
        mainScreenClass.chooseDevice();
        mainScreenClass.getAddressSection().click();
        mainScreenSidebarAddressClass.chooseDevice();
        before = mainScreenSidebarAddressClass.countAddressElementsBefore();
    }

    @After
    public void after(){
        driverBrowser.quit();
    }


    @Ignore
    @Test
    public void testCase43() throws InterruptedException {
        mainScreenSidebarAddressClass.addAddressButtonClick();
        mainScreenSidebarAddAddressClass.chooseDevice();
        mainScreenSidebarAddAddressClass.addAddress(GlobalMethods.getCity(), GlobalMethods.getAddress(), GlobalMethods.getName());
        mainScreenSidebarAddressClass.chooseDevice();
        mainScreenSidebarAddressClass.getEditAddressButton().get(0).click();
        if(mainScreenSidebarAddAddressClass.getCity().equals(GlobalMethods.getCity())
                && mainScreenSidebarAddAddressClass.getAddress().equals(GlobalMethods.getAddress()) && mainScreenSidebarAddAddressClass.getName().equals(GlobalMethods.getName())) {
            Assert.assertTrue(true);
        } else {
            Assert.fail("Error!");
        }
    }

    @Ignore
    @Test
    public void testCase44() throws InterruptedException {
        mainScreenSidebarAddressClass.addAddressButtonClick();
        mainScreenSidebarAddAddressClass.chooseDevice();
        mainScreenSidebarAddAddressClass.addAddress(GlobalMethods.getCity(), GlobalMethods.getAddress(), GlobalMethods.getName());
        mainScreenSidebarAddressClass.chooseDevice();
        mainScreenSidebarAddressClass.getEditAddressButton().get(0).click();
        mainScreenSidebarAddAddressClass.chooseDevice();
        mainScreenSidebarAddAddressClass.addAddress(GlobalMethods.getCityEdit(), GlobalMethods.getAddressEdit(), GlobalMethods.getHomeEdit());
        mainScreenSidebarAddressClass.chooseDevice();
        mainScreenSidebarAddressClass.getEditAddressButton().get(0).click();
        if(mainScreenSidebarAddAddressClass.getCity().equals("EditCity")
                && mainScreenSidebarAddAddressClass.getAddress().equals("EditStreet") && mainScreenSidebarAddAddressClass.getName().equals("EditNumber")) {
            Assert.assertTrue(true);
        } else {
            Assert.fail("Error!");
        }
    }

    @Ignore
    @Test
    public void testCase45() throws InterruptedException {
        mainScreenSidebarAddressClass.addAddressButtonClick();
        mainScreenSidebarAddAddressClass.chooseDevice();
        mainScreenSidebarAddAddressClass.addAddress(GlobalMethods.getCity(), GlobalMethods.getAddress(), GlobalMethods.getName());
        mainScreenSidebarAddressClass.chooseDevice();
        mainScreenSidebarAddressClass.getEditAddressButton().get(0).click();
        mainScreenSidebarAddAddressClass.chooseDevice();
        mainScreenSidebarAddAddressClass.getCancelButton().click();
        /*try{
            mainScreenSidebarAddressClass.chooseDevice();
        } catch(){
            Assert.fail("Error!");
        }*/
        Assert.assertTrue(true);
    }

    @Ignore
    @Test
    public void testCase48() throws InterruptedException {
        mainScreenSidebarAddressClass.getDeleteAddressButton().get(0).click();
        mainScreenSidebarAddressDeleteClass.chooseDevice();
        mainScreenSidebarAddressDeleteClass.deleteNoClick();
        /*try{
            mainScreenSidebarFavoriteOrderClass.chooseDevice();
            boolean result = mainScreenSidebarFavoriteOrderClass.checkDeleteOrder()
        } catch(){
            Assert.fail("Error!");
        }
        Assert.assertFalse("Error!", result);*/
    }

    @Ignore
    @Test
    public void testCase49() throws InterruptedException {
        mainScreenSidebarAddressClass.getDeleteAddressButton().get(0).click();
        mainScreenSidebarAddressDeleteClass.chooseDevice();
        mainScreenSidebarAddressDeleteClass.deleteYesClick();
        boolean result = mainScreenSidebarAddressClass.checkDeleteAddress(before);
        Assert.assertTrue("Error!",result);
    }

    @Ignore
    @Test
    public void testCase50() throws InterruptedException {
        mainScreenSidebarAddressClass.addAddressButtonClick();
        mainScreenSidebarAddAddressClass.chooseDevice();
        mainScreenSidebarAddAddressClass.addAddress(GlobalMethods.getCity(), GlobalMethods.getAddress(), GlobalMethods.getName());
        mainScreenSidebarAddressClass.chooseDevice();
        //TODO
        /*if(mainScreenSidebarAddressClass.getRestaurantName().equals("TestRestaurant") && mainScreenSidebarAddressClass.getOrderName().equals("TestOrder") && mainScreenSidebarAddressClass.getDescription().equals("TestDescription2")) {
            Assert.assertTrue(true);
        } else {
            Assert.fail("Error!");
        }*/
    }

    @Ignore
    @Test
    public void testCase39() throws InterruptedException {
        mainScreenSidebarAddressClass.addAddressButtonClick();
        mainScreenSidebarAddAddressClass.chooseDevice();
        mainScreenSidebarAddAddressClass.addAddress(GlobalMethods.getCity(), GlobalMethods.getAddress(), GlobalMethods.getName());
        mainScreenSidebarAddressClass.chooseDevice();
        org.junit.Assert.assertTrue(mainScreenSidebarAddressClass.checkAddAddress(before));
    }

    @Ignore
    @Test
    public void testCase40() throws InterruptedException {
        mainScreenSidebarAddressClass.addAddressButtonClick();
        mainScreenSidebarAddAddressClass.chooseDevice();
        boolean result = ValidationClass.validationAddAddress(mainScreenSidebarAddAddressClass,GlobalMethods.getCity(), GlobalMethods.getAddress(), GlobalMethods.getName());
        org.junit.Assert.assertTrue(result);
    }

    @Ignore
    @Test
    public void testCase41() throws InterruptedException {
        mainScreenSidebarAddressClass.addAddressButtonClick();
        mainScreenSidebarAddAddressClass.chooseDevice();
        mainScreenSidebarAddAddressClass.cancelClick();
        /*try{
            mainScreenSidebarAddressClass.chooseDevice();
        } catch (){
            Assert.fail();
        }*/
        Assert.assertTrue(true);
    }

    @Ignore
    @Test
    public void testCase42() throws InterruptedException {
        mainScreenSidebarAddressClass.addAddressButtonClick();
        mainScreenSidebarAddAddressClass.chooseDevice();
        boolean result = mainScreenSidebarAddAddressClass.testCase42();
        Assert.assertTrue(result);
    }

    @Ignore
    @Test
    public void testCase76() throws InterruptedException {
        mainScreenSidebarAddressClass.addAddressButtonClick();
        mainScreenSidebarAddAddressClass.chooseDevice();
        boolean result = mainScreenSidebarAddAddressClass.testCase76();
        org.junit.Assert.assertTrue(result);
    }

    @Ignore
    @Test
    public void testCase63() throws InterruptedException {
        mainScreenSidebarAddressClass.addAddressButtonClick();
        mainScreenSidebarAddAddressClass.chooseDevice();
        boolean result = mainScreenSidebarAddAddressClass.testCase63();
        org.junit.Assert.assertTrue(result);
    }

    @Ignore
    @Test
    public void testCase85() throws InterruptedException {
        mainScreenSidebarAddressClass.addAddressButtonClick();
        mainScreenSidebarAddAddressClass.chooseDevice();
        boolean result = mainScreenSidebarAddAddressClass.testCase85();
        org.junit.Assert.assertTrue(result);
    }

}
