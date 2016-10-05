package TestsRestaurant;

import TestClass.GlobalMethods.GlobalMethods;
import TestClass.Restaurant.ForgotPasswordClass;
import TestClass.Restaurant.SignInClass;
import TestClass.Restaurant.SignUpClass.SignUpStep1Class;
import TestClass.Restaurant.StartPageClassMobile;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by dmitry on 12.05.16.
 */
public class SignInTest {

    AppiumDriver driver = null;
    WebDriver driverBrowser = null;
    DesiredCapabilities capabilities;
    SignInClass signInClass;
    StartPageClassMobile startPageClassMobile;
    SignUpStep1Class signUpStep1Class;
    ForgotPasswordClass forgotPasswordClass;

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
            forgotPasswordClass = PageFactory.initElements(driver, ForgotPasswordClass.class);
            startPageClassMobile = PageFactory.initElements(driver, StartPageClassMobile.class);
        } else {
            signInClass = PageFactory.initElements(driverBrowser, SignInClass.class);
            signUpStep1Class = PageFactory.initElements(driverBrowser, SignUpStep1Class.class);
            forgotPasswordClass = PageFactory.initElements(driverBrowser, ForgotPasswordClass.class);
            startPageClassMobile = PageFactory.initElements(driverBrowser, StartPageClassMobile.class);
        }

        startPageClassMobile.chooseDevice();
        startPageClassMobile.signUpClick();
        signInClass.chooseDevice();
    }

    @After
    public void after() throws InterruptedException {
        Thread.sleep(1000);
        if(driver != null) {
            driver.quit();
        } else {
            driverBrowser.close();
        }
    }

    @Test
    public void testCase4() {
        signInClass.signInClick("","");
        Assert.assertFalse("Sign in ENABLED!",signInClass.getSignInButton().isEnabled());

    }

    @Test
    public void testCase5() throws InterruptedException {
        signInClass.getPassword().sendKeys("111111");
        boolean result = GlobalMethods.validationEmail(signInClass.getEmail(),signInClass.getSignInButton());
        Assert.assertEquals("Email validation not correct!",result,true);
    }

    @Test
    public void testCase14() throws InterruptedException {
        signInClass.signUpClick();
        signUpStep1Class.chooseDevice();
        if(GlobalMethods.chooseDevice().equals("web")){
            Assert.assertTrue("Error!",driver.getCurrentUrl().equals(GlobalMethods.getUrl() + "/registration"));
        } else{
            Assert.assertTrue("Error!",signUpStep1Class.getLogoMobile().isDisplayed());
        }

    }

    @Test
    public void testCase15() throws InterruptedException {
        signInClass.forgotPasswordClick();
        forgotPasswordClass.chooseDevice();
        if(GlobalMethods.chooseDevice().equals("web")){
            Assert.assertTrue("Error!",driver.getCurrentUrl().equals(GlobalMethods.getUrl() + "/forgot-password"));
        } else{
            Assert.assertTrue("Error!",forgotPasswordClass.getEmail().isDisplayed());
        }
    }

}
