package TestsRestaurant;

import TestClass.GlobalMethods.GlobalMethods;
import TestClass.Restaurant.SignInClass;
import TestClass.Restaurant.SignUpClass.*;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by dmitry on 31.05.16.
 */
public class SignUpAllSteps {

    AppiumDriver driver = null;
    WebDriver driverBrowser = null;
    DesiredCapabilities capabilities;
    SignInClass signInClass;
    SignUpStep1Class signUpStep1Class;
    SignUpStep2Class signUpStep2Class;
    SignUpStep3Class signUpStep3Class;
    SignUpStep4Class signUpStep4Class;
    SignUpStep5Class signUpStep5Class;
    FirefoxProfile firefoxProfile;


    @Before
    public void before() throws InterruptedException, MalformedURLException {

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
            signInClass = PageFactory.initElements(driver, SignInClass.class);
            signUpStep1Class = PageFactory.initElements(driver, SignUpStep1Class.class);
            signUpStep2Class = PageFactory.initElements(driver, SignUpStep2Class.class);
            signUpStep3Class = PageFactory.initElements(driver, SignUpStep3Class.class);
            signUpStep4Class = PageFactory.initElements(driver, SignUpStep4Class.class);
            signUpStep5Class = PageFactory.initElements(driver, SignUpStep5Class.class);
        } else {
            signInClass = PageFactory.initElements(driverBrowser, SignInClass.class);
            signUpStep1Class = PageFactory.initElements(driverBrowser, SignUpStep1Class.class);
            signUpStep2Class = PageFactory.initElements(driverBrowser, SignUpStep2Class.class);
            signUpStep3Class = PageFactory.initElements(driverBrowser, SignUpStep3Class.class);
            signUpStep4Class = PageFactory.initElements(driverBrowser, SignUpStep4Class.class);
            signUpStep5Class = PageFactory.initElements(driverBrowser, SignUpStep5Class.class);
        }

        driver.get(GlobalMethods.getUrl());
        signInClass.chooseDevice();
        signInClass.signUpClick();
        signUpStep1Class.chooseDevice();
    }

    @After
    public void after() throws InterruptedException {
        Thread.sleep(1000);
        driver.close();
    }

    @Test
    public void testCase13() throws InterruptedException {
        signUpStep1Class.signUpClick(GlobalMethods.getNameUserRestaurant(),GlobalMethods.getEmail(),GlobalMethods.getPassword(),GlobalMethods.getPassword());
        signUpStep2Class.chooseDevice();
        signUpStep2Class.signUpClick(GlobalMethods.getNameRestaurant(),"wert.jpeg","bnm.jpg");
        signUpStep3Class.chooseDevice();
        signUpStep3Class.signUpClick(GlobalMethods.getAddressRestaurant(),GlobalMethods.getCityRestaurant(),GlobalMethods.getStateRestaurant(),GlobalMethods.getCountryRestaurant(),GlobalMethods.getZipCodeRestaurant());
        signUpStep4Class.chooseDevice();
        signUpStep4Class.signUpClick();
        signUpStep5Class.chooseDevice();
        signUpStep5Class.signUpClick();
        Assert.assertTrue("Error!",driver.getCurrentUrl().equals(GlobalMethods.getUrl() + "/login"));
    }

    @Test
    public void testCase69() throws InterruptedException {
        signUpStep1Class.signUpClick(GlobalMethods.getNameUserRestaurant(),GlobalMethods.getEmail(),GlobalMethods.getPassword(),GlobalMethods.getPassword());
        signUpStep2Class.chooseDevice();
        signUpStep2Class.signUpClick(GlobalMethods.getNameRestaurant(),"wert.jpeg","bnm.jpg");
        signUpStep3Class.chooseDevice();
        signUpStep3Class.signUpClick(GlobalMethods.getAddressRestaurant(),GlobalMethods.getCityRestaurant(),GlobalMethods.getStateRestaurant(),GlobalMethods.getCountryRestaurant(),GlobalMethods.getZipCodeRestaurant());
        signUpStep4Class.chooseDevice();
        signUpStep4Class.signUpFullClick();
        signUpStep5Class.chooseDevice();
        signUpStep5Class.signUpClick();
        Assert.assertTrue("Error!",driver.getCurrentUrl().equals(GlobalMethods.getUrl() + "/login"));
    }


    @Test
    public void testCase68() throws InterruptedException {
        signUpStep1Class.signUpClick(GlobalMethods.getNameUserRestaurant(),GlobalMethods.getEmail(),GlobalMethods.getPassword(),GlobalMethods.getPassword());
        signUpStep2Class.chooseDevice();
        signUpStep2Class.signUpEmptyClick(GlobalMethods.getNameRestaurant());
        signUpStep3Class.chooseDevice();
        signUpStep3Class.signUpClick(GlobalMethods.getAddressRestaurant(),GlobalMethods.getCityRestaurant(),GlobalMethods.getStateRestaurant(),GlobalMethods.getCountryRestaurant(),GlobalMethods.getZipCodeRestaurant());
        signUpStep4Class.chooseDevice();
        signUpStep4Class.getSignUpButton().click();
        signUpStep5Class.chooseDevice();
        signUpStep5Class.signUpClick();
        Assert.assertTrue("Error!",driver.getCurrentUrl().equals(GlobalMethods.getUrl() + "/login"));
    }

    @Test
    public void testCase65() throws InterruptedException {
        signUpStep1Class.signUpClick(GlobalMethods.getNameUserRestaurant(),GlobalMethods.getEmail(),GlobalMethods.getPassword(),GlobalMethods.getPassword());
        signUpStep2Class.chooseDevice();
        signUpStep2Class.signUpEmptyClick(GlobalMethods.getNameRestaurant());
        signUpStep3Class.chooseDevice();
        signUpStep3Class.signUpClick(GlobalMethods.getAddressRestaurant(),GlobalMethods.getCityRestaurant(),GlobalMethods.getStateRestaurant(),GlobalMethods.getCountryRestaurant(),GlobalMethods.getZipCodeRestaurant());
        signUpStep4Class.chooseDevice();
        signUpStep4Class.getSignUpButton().click();
        signUpStep5Class.chooseDevice();
        signUpStep5Class.signUpClick();
        signInClass.chooseDevice();
        signInClass.signUpClick();
        signUpStep1Class.chooseDevice();

        signUpStep1Class.signUpClick(GlobalMethods.getNameUserRestaurant(),GlobalMethods.getEmail(),GlobalMethods.getPassword(),GlobalMethods.getPassword());
        signUpStep2Class.chooseDevice();
        signUpStep2Class.signUpEmptyClick(GlobalMethods.getNameRestaurant());
        signUpStep3Class.chooseDevice();
        signUpStep3Class.signUpClick(GlobalMethods.getAddressRestaurant(),GlobalMethods.getCityRestaurant(),GlobalMethods.getStateRestaurant(),GlobalMethods.getCountryRestaurant(),GlobalMethods.getZipCodeRestaurant());
        signUpStep4Class.chooseDevice();
        boolean result = signUpStep4Class.testCase65();
        Assert.assertTrue("Error!",result);
    }

    @Test
    public void testCase64() throws InterruptedException {
        signUpStep1Class.signUpClick(GlobalMethods.getNameUserRestaurant(),GlobalMethods.getEmail(),GlobalMethods.getPassword(),GlobalMethods.getPassword());
        signUpStep2Class.chooseDevice();
        signUpStep2Class.signUpEmptyClick(GlobalMethods.getNameRestaurant());
        signUpStep3Class.chooseDevice();
        signUpStep3Class.signUpSearchClick(GlobalMethods.getSearchAddressRestaurant());
        signUpStep4Class.chooseDevice();
        signUpStep4Class.getSignUpButton().click();
        signUpStep5Class.chooseDevice();
        signUpStep5Class.signUpClick();
        Assert.assertTrue("Error!",driver.getCurrentUrl().equals(GlobalMethods.getUrl() + "/login"));
    }

}
