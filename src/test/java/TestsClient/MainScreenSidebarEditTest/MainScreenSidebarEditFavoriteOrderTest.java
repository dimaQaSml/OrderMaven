package TestsClient.MainScreenSidebarEditTest;

import Client.MainScreenSidebarAddClass.MainScreenSidebarAddAddressClass;
import Client.MainScreenSidebarAddClass.MainScreenSidebarAddOrderClass;
import Client.MainScreenSidebarClass.MainScreenClass;
import Client.MainScreenSidebarClass.MainScreenSidebarAddressClass;
import Client.MainScreenSidebarClass.MainScreenSidebarFavoriteOrderClass;
import Client.MainScreenSidebarDeleteClass.MainScreenSidebarAddressDeleteClass;
import Client.MainScreenSidebarDeleteClass.MainScreenSidebarFavoriteOrderDeleteClass;
import Client.SignInClass;
import GlobalMethods.GlobalMethods;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by dmitry on 01.08.16.
 */
public class MainScreenSidebarEditFavoriteOrderTest {
    AppiumDriver driver = null;
    WebDriver driverBrowser = null;
    DesiredCapabilities capabilities;
    SignInClass signInClass;
    MainScreenClass mainScreenClass;
    MainScreenSidebarFavoriteOrderClass mainScreenSidebarFavoriteOrderClass;
    MainScreenSidebarAddOrderClass mainScreenSidebarAddOrderClass;

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
            mainScreenSidebarFavoriteOrderClass = PageFactory.initElements(driver, MainScreenSidebarFavoriteOrderClass.class);
            mainScreenSidebarAddOrderClass = PageFactory.initElements(driver, MainScreenSidebarAddOrderClass.class);

        } else {
            signInClass = PageFactory.initElements(driverBrowser, SignInClass.class);
            mainScreenClass = PageFactory.initElements(driverBrowser, MainScreenClass.class);
            mainScreenSidebarFavoriteOrderClass = PageFactory.initElements(driverBrowser, MainScreenSidebarFavoriteOrderClass.class);
            mainScreenSidebarAddOrderClass = PageFactory.initElements(driverBrowser, MainScreenSidebarAddOrderClass.class);
        }

        driver.get(GlobalMethods.getUrl());
        driver.manage().window().maximize();
        signInClass.chooseDevice();
        signInClass.signInClick("+79280373736","123456");
        mainScreenClass.chooseDevice();
        mainScreenClass.getFavoriteOrderSection().click();
        mainScreenSidebarFavoriteOrderClass.chooseDevice();
        mainScreenSidebarFavoriteOrderClass.addOrderButtonClick();
        mainScreenSidebarAddOrderClass.chooseDevice();
        mainScreenSidebarAddOrderClass.addOrder(GlobalMethods.getRestaurant(), GlobalMethods.getOrder());
        mainScreenSidebarFavoriteOrderClass.chooseDevice();
        mainScreenSidebarFavoriteOrderClass.getEditOrderButton().get(0).click();
        mainScreenSidebarAddOrderClass.chooseDevice();

    }

    /*@After
    public void after(){
        driver.close();
    }*/

    @Ignore
    @Test
    public void testCase31() throws InterruptedException {
        boolean result = mainScreenSidebarAddOrderClass.checkEditAddressFields(GlobalMethods.getRestaurant(), GlobalMethods.getOrder());
        Assert.assertTrue(result);
    }

    @Ignore
    @Test
    public void testCase32() throws InterruptedException {
        mainScreenSidebarAddOrderClass.editOrder(GlobalMethods.getRestaurant(), GlobalMethods.getOrder());
        mainScreenSidebarFavoriteOrderClass.getEditOrderButton().get(0).click();
        boolean result = mainScreenSidebarAddOrderClass.checkEditAddressFields("editRest", "editOrder");
        Assert.assertTrue(result);
    }


}
