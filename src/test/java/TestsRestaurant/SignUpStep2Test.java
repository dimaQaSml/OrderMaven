package TestsRestaurant;

import TestClass.GlobalMethods.GlobalMethods;
import TestClass.GlobalMethods.ValidationClass;
import TestClass.Restaurant.ForgotPasswordClass;
import TestClass.Restaurant.SignInClass;
import TestClass.Restaurant.SignUpClass.SignUpStep1Class;
import TestClass.Restaurant.SignUpClass.SignUpStep2Class;
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
 * Created by dmitry on 19.05.16.
 */
public class SignUpStep2Test {
    AppiumDriver driver = null;
    WebDriver driverBrowser = null;
    DesiredCapabilities capabilities;
    FirefoxProfile firefoxProfile;
    SignInClass signInClass;
    SignUpStep1Class signUpStep1Class;
    SignUpStep2Class signUpStep2Class;
    ForgotPasswordClass forgotPasswordClass;

    String name = "testName";
    String email = GlobalMethods.getEmail();
    String password = GlobalMethods.getPassword();
    String confirmPassword = GlobalMethods.getPassword();

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
            forgotPasswordClass = PageFactory.initElements(driver,ForgotPasswordClass.class);
            driverBrowser.get(GlobalMethods.getUrl());
        } else {
            signInClass = PageFactory.initElements(driverBrowser, SignInClass.class);
            signUpStep1Class = PageFactory.initElements(driverBrowser, SignUpStep1Class.class);
            signUpStep2Class = PageFactory.initElements(driverBrowser, SignUpStep2Class.class);
            forgotPasswordClass = PageFactory.initElements(driverBrowser,ForgotPasswordClass.class);
        }
        signUpStep1Class.chooseDevice();
        signUpStep1Class.signUpClick(name,email,password,confirmPassword);
        signUpStep2Class.chooseDevice();
    }

    @After
    public void after(){
        driverBrowser.quit();
    }


    @Test
    public void testCase16() throws InterruptedException {
        signUpStep2Class.addPhotoLogo();
        Thread.sleep(500);
        String src = signUpStep2Class.getLogoImage().getAttribute("src");
        Assert.assertTrue("Error!",!src.contains("stub_icon.png"));
    }


    @Test
    public void testCase17() throws InterruptedException {
        signUpStep2Class.addRestoImages("wert.jpeg");
        Assert.assertTrue("Error!",signUpStep2Class.getRestoImageArea().isDisplayed());
    }

    @Test
    public void testCase18() throws InterruptedException {
        signUpStep2Class.addPhotoMenu("wert.jpeg");
        Assert.assertTrue("Error!",signUpStep2Class.getMenuImageArea().isDisplayed());
    }


    @Test
    public void testCase19() throws InterruptedException {
        signUpStep2Class.addPhotoFiveImages();
        Assert.assertTrue("Error!",signUpStep2Class.getRestoImageArea().isDisplayed());
    }


    @Test
    public void testCase20() throws InterruptedException {
        signUpStep2Class.addPhotoFiveMenu();
        Assert.assertTrue("Error!",signUpStep2Class.getMenuImageArea().isDisplayed());
    }


    @Test
    public void testCase21() throws InterruptedException {
        signUpStep2Class.addRestoImages("wert.jpeg");
        signUpStep2Class.getRestoImageClose().click();
        Assert.assertTrue("Error!",!signUpStep2Class.getRestoImageArea().isDisplayed());
    }


    @Test
    public void testCase22() throws InterruptedException {
        signUpStep2Class.addPhotoMenu("wert.jpeg");
        signUpStep2Class.getMenuImageClose().click();
        Assert.assertTrue("Error!",!signUpStep2Class.getMenuImageArea().isDisplayed());
    }


    @Test
    public void testCase23() throws InterruptedException {
        boolean result = ValidationClass.validationSignUpRestaurantStep2(signUpStep2Class,"wert.jpeg","qwer","sdf.jpg","bnm.jpg");
        Assert.assertTrue("Error!", result);
    }


    @Test
    public void testCase66() throws InterruptedException {
        signUpStep2Class.getKosherInput().click();
        signUpStep2Class.getNotKosherInput().click();
        boolean result = signUpStep2Class.checkCombobox();
        Assert.assertTrue("Error!", result);

    }


    @Test
    public void testCase67() throws InterruptedException {
        boolean result = ValidationClass.validationSignUpRestaurantStep2(signUpStep2Class,"wert.jpeg","qwer","sdf.jpg","bnm.jpg");
        Assert.assertTrue("Error!", result);
    }

}
