package TestsRestaurant;

import TestClass.GlobalMethods.GlobalMethods;
import TestClass.Restaurant.MainScreenMyRestaurant;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import junit.framework.Assert;
import org.json.JSONException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by dmitry on 04.07.16.
 */
public class MainScreenMyRestaurantTest {

    AppiumDriver driver = null;
    WebDriver driverBrowser = null;
    DesiredCapabilities capabilities;
    MainScreenMyRestaurant mainScreenMyRestaurant;
    FirefoxProfile firefoxProfile;

    @Before
    public void before() throws MalformedURLException, InterruptedException {

        switch (GlobalMethods.chooseDevice()){
            case "web":
                GlobalMethods.web();
                break;
            case "ios":
                GlobalMethods.ios(capabilities, driver);
                break;
            case "android":
                GlobalMethods.android(capabilities, driver);
                break;
        }
        if(driver != null) {
            mainScreenMyRestaurant = PageFactory.initElements(driver, MainScreenMyRestaurant.class);
            driverBrowser.get(GlobalMethods.getUrl());
        } else {
            mainScreenMyRestaurant = PageFactory.initElements(driverBrowser, MainScreenMyRestaurant.class);
        }
        driver.get(GlobalMethods.getUrl());
        driver.manage().window().maximize();

    }

    @After
    public void after() throws InterruptedException {
        Thread.sleep(1000);
        driver.close();
    }

    @Test
    public void testCase70() throws InterruptedException, IOException, JSONException {
        boolean result = mainScreenMyRestaurant.testCase70();
        Assert.assertTrue("Data is not correct!",result);
    }

    @Test
    public void testCase71() throws InterruptedException, IOException, JSONException {
        boolean result = mainScreenMyRestaurant.testCase71();
        Assert.assertTrue("Data is not correct!",result);
    }

/*    @Test
    public void qwe() throws InterruptedException, IOException, JSONException {
        mainScreenMyRestaurant.getResponceRestaurantData();
        Assert.assertTrue("Email validation not correct!",true);
    }*/

}
