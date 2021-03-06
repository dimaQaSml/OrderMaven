package TestsRestaurant;

import GlobalMethods.GlobalMethods;
import Restaurant.*;
import Restaurant.SignUpClass.SignUpStep1Class;
import Restaurant.SignUpClass.SignUpStep2Class;
import Restaurant.SignUpClass.SignUpStep3Class;
import Restaurant.SignUpClass.SignUpStep4Class;
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
 * Created by dmitry on 30.05.16.
 */
public class SignUpStep4Test {
    FirefoxProfile firefoxProfile;
    WebDriver driverBrowser;
    AppiumDriver driver;
    SignInClass signInClass;
    DesiredCapabilities capabilities;
    SignUpStep1Class signUpStep1Class;
    SignUpStep2Class signUpStep2Class;
    SignUpStep3Class signUpStep3Class;
    SignUpStep4Class signUpStep4Class;

    String name = "testName";
    String email = GlobalMethods.getEmail();
    String password = GlobalMethods.getPassword();
    String confirmPassword = GlobalMethods.getPassword();

    String address = "testAddress";
    String city = "Krasnodar";
    String state = "Krasnodarskiy kray";
    String country = "Russia";
    String zipCode = "350000";

    @Before
    public void before() throws InterruptedException, MalformedURLException {
        switch (GlobalMethods.chooseDevice()){
            case "web":
                ProfilesIni profile = new ProfilesIni();
                firefoxProfile = profile.getProfile("QA");
                driverBrowser = new FirefoxDriver(firefoxProfile);
                driver.get(GlobalMethods.getUrl());
                driverBrowser.manage().window().maximize();
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
            signUpStep1Class = PageFactory.initElements(driver, SignUpStep1Class.class);
            signUpStep2Class = PageFactory.initElements(driver, SignUpStep2Class.class);
            signUpStep3Class = PageFactory.initElements(driver, SignUpStep3Class.class);
            signUpStep4Class = PageFactory.initElements(driver, SignUpStep4Class.class);
        } else {
            signInClass = PageFactory.initElements(driverBrowser, SignInClass.class);
            signUpStep1Class = PageFactory.initElements(driverBrowser, SignUpStep1Class.class);
            signUpStep2Class = PageFactory.initElements(driverBrowser, SignUpStep2Class.class);
            signUpStep3Class = PageFactory.initElements(driverBrowser, SignUpStep3Class.class);
            signUpStep4Class = PageFactory.initElements(driverBrowser, SignUpStep4Class.class);
        }

        signInClass.chooseDevice();
        signInClass.signUpClick();
        signUpStep1Class.chooseDevice();
        signUpStep1Class.signUpClick(name,email,password,confirmPassword);
        signUpStep2Class.chooseDevice();
        signUpStep2Class.signUpClick(name,"qwer.jpg","wert.jpeg");
        signUpStep3Class.chooseDevice();
        signUpStep3Class.signUpClick(address,city,state,country,zipCode);
        signUpStep4Class.chooseDevice();
    }

    @After
    public void after() throws InterruptedException {
        Thread.sleep(1000);
        driver.close();
    }

    @Test
    public void testCase44() throws InterruptedException {
        boolean result = signUpStep4Class.testCase44();
        Assert.assertTrue("Error!",result);
    }


    @Test
    public void testCase45() throws InterruptedException {
        boolean result = signUpStep4Class.testCase45();
        Assert.assertTrue("Error!",result);
    }

    @Test
    public void testCase46() throws InterruptedException {
        boolean result = signUpStep4Class.testCase46();
        Assert.assertTrue("Error!",result);
    }

    @Test
    public void testCase47() throws InterruptedException {
        boolean result = signUpStep4Class.testCase47();
        Assert.assertTrue("Error!",result);
    }

    @Test
    public void testCase100() throws InterruptedException {
        signUpStep4Class.signUpClick();
    }
}
