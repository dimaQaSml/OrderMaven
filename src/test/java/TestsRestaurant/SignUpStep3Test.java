package TestsRestaurant;

import TestClass.GlobalMethods.GlobalMethods;
import TestClass.Restaurant.SignInClass;
import TestClass.Restaurant.SignUpClass.SignUpStep1Class;
import TestClass.Restaurant.SignUpClass.SignUpStep2Class;
import TestClass.Restaurant.SignUpClass.SignUpStep3Class;
import TestClass.Restaurant.SignUpClass.SignUpStep4Class;
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
 * Created by dmitry on 26.05.16.
 */
public class SignUpStep3Test {

    WebDriver driverBrowser;
    AppiumDriver driver;
    SignInClass signInClass;
    DesiredCapabilities capabilities;
    SignUpStep1Class signUpStep1Class;
    SignUpStep2Class signUpStep2Class;
    SignUpStep3Class signUpStep3Class;
    SignUpStep4Class signUpStep4Class;
    FirefoxProfile firefoxProfile;

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
            signUpStep1Class = PageFactory.initElements(driver, SignUpStep1Class.class);
            signUpStep2Class = PageFactory.initElements(driver, SignUpStep2Class.class);
            signUpStep3Class = PageFactory.initElements(driver,SignUpStep3Class.class);
            signUpStep4Class = PageFactory.initElements(driver,SignUpStep4Class.class);
        } else {
            signInClass = PageFactory.initElements(driverBrowser, SignInClass.class);
            signUpStep1Class = PageFactory.initElements(driverBrowser, SignUpStep1Class.class);
            signUpStep2Class = PageFactory.initElements(driverBrowser, SignUpStep2Class.class);
            signUpStep3Class = PageFactory.initElements(driverBrowser,SignUpStep3Class.class);
            signUpStep4Class = PageFactory.initElements(driverBrowser,SignUpStep4Class.class);
        }
        signInClass.chooseDevice();
        signInClass.signUpClick();
        signUpStep1Class.chooseDevice();
        signUpStep1Class.signUpClick(name,email,password,confirmPassword);
        signUpStep2Class.chooseDevice();
        signUpStep2Class.signUpClick(name,"qwer.jpg","wert.jpeg");
        signUpStep3Class.chooseDevice();
    }

    @After
    public void after() throws InterruptedException {
        driver.close();
    }

    @Test
    public void testCase25() throws InterruptedException {
        boolean result = GlobalMethods.ValidationSignUpRestaurantStep3(driver,signUpStep3Class,address,city,state,country,zipCode);
        Assert.assertTrue("Error!",result);
    }

    @Test
    public void testCase26() throws InterruptedException {
         boolean result = GlobalMethods.validationCountry(signUpStep3Class.getCountry(),signUpStep3Class.getCountrySelect());
        Assert.assertTrue("Error!",result);
    }

    @Test
    public void testCase32() throws InterruptedException {
        boolean result = signUpStep3Class.makeAreaTest32();
        Assert.assertTrue("Error!",result);
    }

    @Test
    public void testCase33() throws InterruptedException {
        driver.manage().window().maximize();
        boolean result = signUpStep3Class.makeAreaTest33();
        Assert.assertTrue("Error!",result);
    }

    @Test
    public void testCase34() throws InterruptedException {
        driver.manage().window().maximize();
        boolean result = signUpStep3Class.makeAreaTest34();
        Assert.assertTrue("Error!",result);
    }

    @Test
    public void testCase35() throws InterruptedException {
        driver.manage().window().maximize();
        boolean result = signUpStep3Class.makeAreaTest35();
        Assert.assertTrue("Error!",result);
    }

    @Test
    public void testCase36() throws InterruptedException {
        driver.manage().window().maximize();
        boolean result = signUpStep3Class.makeAreaTest36();
        Assert.assertTrue("Error!",result);
    }


    @Test
    public void testCase27() throws InterruptedException {
        driver.manage().window().maximize();
        boolean result = signUpStep3Class.makeAreaTest27();
        Assert.assertTrue("Error!",result);
    }


    @Test
    public void testCase28() throws InterruptedException {
        driver.manage().window().maximize();
        boolean result = signUpStep3Class.makeAreaTest28();
        Assert.assertTrue("Error!",result);
    }


    @Test
    public void testCase29() throws InterruptedException {
        driver.manage().window().maximize();
        boolean result = signUpStep3Class.makeAreaTest29();
        Assert.assertTrue("Error!",result);
    }

    @Test
    public void testCase30() throws InterruptedException {
        driver.manage().window().maximize();
        boolean result = signUpStep3Class.makeAreaTest30();
        Assert.assertTrue("Error!",result);
    }

    @Test
    public void testCase38() throws InterruptedException {
        driver.manage().window().maximize();
        boolean result = signUpStep3Class.makeAreaTest38();
        Assert.assertTrue("Error!",result);
    }

    @Test
    public void testCase39() throws InterruptedException {
        driver.manage().window().maximize();
        boolean result = signUpStep3Class.makeAreaTest39();
        Assert.assertTrue("Error!",result);
    }


    @Test
    public void testCase40() throws InterruptedException {
        driver.manage().window().maximize();
        boolean result = signUpStep3Class.makeAreaTest40();
        Assert.assertTrue("Error!",result);
    }


    @Test
    public void testCase41() throws InterruptedException {
        driver.manage().window().maximize();
        boolean result = signUpStep3Class.makeAreaTest41();
        Assert.assertTrue("Error!",result);
    }

    @Test
    public void testCase42() throws InterruptedException {
        driver.manage().window().maximize();
        signUpStep3Class.makeAreaTest42();
        signUpStep2Class.chooseDevice();
        Assert.assertTrue("Error!",signUpStep2Class.getLogoImage().isDisplayed());
    }

    @Test
    public void testCase43() throws InterruptedException {
        driver.manage().window().maximize();
        signUpStep3Class.makeAreaTest43();
        signUpStep4Class.chooseDevice();
        Assert.assertTrue("Error!",signUpStep4Class.getCheckbox().isDisplayed());
    }
}
