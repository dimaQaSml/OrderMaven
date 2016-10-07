package TestsClient.MainScreenSidebarDeleteTest;


import TestClass.Client.MainScreenSidebarAddClass.MainScreenSidebarAddOrderClass;
import TestClass.Client.MainScreenSidebarClass.MainScreenClass;
import TestClass.Client.MainScreenSidebarClass.MainScreenSidebarFavoriteOrderClass;
import TestClass.Client.MainScreenSidebarDeleteClass.MainScreenSidebarFavoriteOrderDeleteClass;
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
 * Created by dmitry on 01.08.16.
 */
public class MainScreenSidebarFavoriteOrderDeleteTest {
    AppiumDriver driver = null;
    WebDriver driverBrowser = null;
    DesiredCapabilities capabilities;
    SignInClass signInClass;
    MainScreenClass mainScreenClass;
    MainScreenSidebarFavoriteOrderClass mainScreenSidebarFavoriteOrderClass;
    MainScreenSidebarAddOrderClass mainScreenSidebarAddOrderClass;
    MainScreenSidebarFavoriteOrderDeleteClass mainScreenSidebarFavoriteOrderDeleteClass;
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
            mainScreenSidebarFavoriteOrderClass = PageFactory.initElements(driver, MainScreenSidebarFavoriteOrderClass.class);
            mainScreenSidebarAddOrderClass = PageFactory.initElements(driver, MainScreenSidebarAddOrderClass.class);
            mainScreenSidebarFavoriteOrderDeleteClass = PageFactory.initElements(driver,MainScreenSidebarFavoriteOrderDeleteClass.class);


        } else {
            signInClass = PageFactory.initElements(driverBrowser, SignInClass.class);
            mainScreenClass = PageFactory.initElements(driverBrowser, MainScreenClass.class);
            mainScreenSidebarFavoriteOrderClass = PageFactory.initElements(driverBrowser, MainScreenSidebarFavoriteOrderClass.class);
            mainScreenSidebarAddOrderClass = PageFactory.initElements(driverBrowser, MainScreenSidebarAddOrderClass.class);
            mainScreenSidebarFavoriteOrderDeleteClass = PageFactory.initElements(driverBrowser,MainScreenSidebarFavoriteOrderDeleteClass.class);
            driverBrowser.get(GlobalMethods.getUrl());
            driverBrowser.manage().window().maximize();
        }

        signInClass.chooseDevice();
        signInClass.signInClick(GlobalMethods.getRealPhone(), GlobalMethods.getPassword());
        mainScreenClass.chooseDevice();
        mainScreenClass.getFavoriteOrderSection().click();
        mainScreenSidebarFavoriteOrderClass.chooseDevice();
        mainScreenSidebarFavoriteOrderClass.addOrderButtonClick();
        mainScreenSidebarAddOrderClass.chooseDevice();
        mainScreenSidebarAddOrderClass.addOrder(GlobalMethods.getRestaurant(), GlobalMethods.getOrder());
        mainScreenSidebarFavoriteOrderClass.chooseDevice();
        before = mainScreenSidebarFavoriteOrderClass.countOrdersElementsBefore();
        mainScreenSidebarFavoriteOrderClass.getEditOrderButton().get(0).click();
        mainScreenSidebarFavoriteOrderClass.getDeleteOrderButton().get(0).click();
    }

    /*@After
    public void after(){
        driver.close();
    }*/

    @Ignore
    @Test
    public void testCase37() throws InterruptedException {
        mainScreenSidebarFavoriteOrderDeleteClass.deleteNoClick();
        boolean result = mainScreenSidebarFavoriteOrderClass.checkDeleteOrder(before);
        Assert.assertTrue(!result);
    }

    @Ignore
    @Test
    public void testCase38() throws InterruptedException {
        mainScreenSidebarFavoriteOrderDeleteClass.deleteYesClick();
        boolean result = mainScreenSidebarFavoriteOrderClass.checkDeleteOrder(before);
        Assert.assertTrue(result);
    }
}
